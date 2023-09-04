package cn.enterprisys.web.modules.sys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.enterprisys.web.modules.sys.entity.SysUserOperationLog;
import cn.enterprisys.web.modules.sys.form.SysOperationLogForm;

import java.util.List;


public interface SysUserOperationLogService extends IService<SysUserOperationLog> {
    /**
     * 查询功能
     * @param sysOperationLogForm
     * @param page
     * @return
     */
    List<SysUserOperationLog> queryOperationList(SysOperationLogForm sysOperationLogForm, IPage page);

    /**
     * 查询操作类型
     * @return
     */
    List<SysUserOperationLog> queryType();
}
