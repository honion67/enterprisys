package cn.enterprisys.web.modules.sys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import cn.enterprisys.web.modules.sys.entity.SysUserOperationLog;
import cn.enterprisys.web.modules.sys.form.SysOperationLogForm;

import java.util.List;

/**
 * 用户操作日志表 服务类
 */
public interface UserOperationLogService  {
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
