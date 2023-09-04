package cn.enterprisys.web.modules;

import cn.enterprisys.web.modules.sys.form.LoginForm;
import cn.enterprisys.web.modules.sys.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;

public abstract class BaseController {

    @Autowired
    private HttpSession session;

    protected SysUser getUser() {
        return (SysUser) session.getAttribute(LoginForm.LOGIN_USER_KEY);
    }
}
