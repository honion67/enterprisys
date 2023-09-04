package cn.enterprisys.web.modules.sys.service;

import cn.enterprisys.web.modules.sys.form.LoginForm;

import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;


public interface SignService {

    /**
     * 用户登录
     *
     * @param form
     * @param session
     * @throws Exception
     */
    void checkLogin(LoginForm form, HttpSession session) throws Exception;


    boolean verifyCaptcha(String userInputCode, HttpSession session);

    /**
     * 生成校验码图片
     *
     * @param session
     * @return
     * @throws Exception
     */
    BufferedImage createVerifyCodeImage(HttpSession session) throws Exception;
}
