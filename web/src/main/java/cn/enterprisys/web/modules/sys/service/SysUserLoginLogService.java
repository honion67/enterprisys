package cn.enterprisys.web.modules.sys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.enterprisys.web.modules.sys.entity.SysUserLoginLog;
import cn.enterprisys.web.modules.sys.form.SysLoginLogForm;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserLoginLogService extends IService<SysUserLoginLog> {
    /**
     * 查询列表
     * @param sysLoginLogForm
     * @param page
     * @return
     */
    List<SysUserLoginLog> queryLoginLogList(@Param("sysLoginLogForm") SysLoginLogForm sysLoginLogForm, IPage page);
}
