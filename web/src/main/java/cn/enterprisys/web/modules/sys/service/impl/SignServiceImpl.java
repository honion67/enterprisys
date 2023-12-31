package cn.enterprisys.web.modules.sys.service.impl;

import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import cn.enterprisys.web.commons.components.loginlog.LoginLogTemplate;
import cn.enterprisys.web.commons.components.nebula.PasswordEncryptor;
import cn.enterprisys.web.commons.components.nebula.VerifyCodeGenerator;
import cn.enterprisys.web.commons.entity.CodeMsg;
import cn.enterprisys.web.commons.enums.DeleteType;
import cn.enterprisys.web.modules.sys.entity.SysUser;
import cn.enterprisys.web.modules.sys.form.LoginForm;
import cn.enterprisys.web.modules.sys.service.SignService;
import cn.enterprisys.web.modules.sys.service.SysUserService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.code.kaptcha.Producer;
import link.ahsj.core.utils.base.AppAssertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

@Service
public class SignServiceImpl implements SignService {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private PasswordEncryptor passwordEncryptor;
    @Autowired
    private VerifyCodeGenerator verifyCodeGenerator;
    @Autowired
    private Producer producer;
    @Autowired
    private LoginLogTemplate loginLogTemplate;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void checkLogin(LoginForm form, HttpSession session) throws Exception {
        // 验证验证码
        if (!verifyCaptcha(form.getCode(), session)) {
            throw new Exception("验证码不正确");
        }
        SysUser sysUser = this.parse2SysUser(form, session);
        loginLogTemplate.record(args -> {
            SysUser dbUser = sysUserService.getOne(
                    Wrappers.<SysUser>lambdaUpdate()
                            .eq(SysUser::getUsername, sysUser.getUsername())
            );
            AppAssertUtil.isNull(dbUser, CodeMsg.ACCOUNT_OR_PASSWORD_ERR_MSG);
            AppAssertUtil.isErr(dbUser.getLoginStatus().equals(DeleteType.DISABLE), CodeMsg.ACCOUNT_UNALLOW_LOGIN);
            AppAssertUtil.isErr(dbUser.getDisable().equals(DeleteType.DISABLE), CodeMsg.ACCOUNT_LOCKED);
            AppAssertUtil.isErr(!dbUser.getPassword().equals(passwordEncryptor.encrypt(sysUser.getPassword())), CodeMsg.ACCOUNT_OR_PASSWORD_ERR_MSG);

            dbUser.setLoginTime(LocalDateTime.now());
            sysUserService.updateById(dbUser);
            //将用户信息放入session中
            session.setAttribute(LoginForm.LOGIN_USER_KEY, dbUser);
            return null;
        }, sysUser);
    }

    @Override
    public boolean verifyCaptcha(String userInputCode, HttpSession session) {
        String generatedCode = (String) session.getAttribute(LoginForm.LOGIN_CODE_STR);
        return userInputCode.equalsIgnoreCase(generatedCode);
    }

    @Override
    public BufferedImage createVerifyCodeImage(HttpSession session) throws Exception {
        String text = verifyCodeGenerator.generate(LoginForm.LOGIN_CODE_STR, session);

        return producer.createImage(text);
    }

    private SysUser parse2SysUser(LoginForm form, HttpSession session) throws Exception {
        //获取session存储的验证码
        String code = (String) session.getAttribute(LoginForm.LOGIN_CODE_STR);
        //获取session存储的私钥
        String privateKey = (String) session.getAttribute(LoginForm.KEY_PAIR_STR);
        RSA rsa = new RSA(privateKey, null);
        AppAssertUtil.isNull(code, CodeMsg.LOGIN_CODE_ERR_MSG);
        AppAssertUtil.isNull(privateKey, CodeMsg.LOGIN_CODE_ERR_MSG);
        //AppAssertUtil.isErr(code.equals(form.getCode()), "验证码不正确");

        //解密账号和密码
        String username = rsa.decryptStr(form.getUsername(), KeyType.PrivateKey);
        String password = rsa.decryptStr(form.getPassword(), KeyType.PrivateKey);
        return new SysUser(username, password);
    }
}
