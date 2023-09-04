package cn.enterprisys.web.commons.components.loginlog;

import com.baomidou.mybatisplus.extension.api.R;
import cn.enterprisys.web.modules.sys.entity.SysUser;

import java.util.function.Function;

//日志模板

public interface LoginLogTemplate {

    /**
     * 记录日志
     *
     * @param sysUser
     * @param function
     */
    void record(Function<SysUser, R> function, SysUser sysUser);
}
