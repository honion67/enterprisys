package cn.enterprisys.web.modules.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import cn.enterprisys.web.modules.sys.entity.SysUserOperationLog;
import cn.enterprisys.web.modules.sys.form.SysOperationLogForm;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface SysUserOperationLogMapper extends BaseMapper<SysUserOperationLog> {
    /**
     * 日志查询
     * @param sysOperationLogForm
     * @param page
     * @return
     */
    List<SysUserOperationLog> queryOperationList(@Param("sysOperationLogForm") SysOperationLogForm sysOperationLogForm, IPage page);

    /**
     * 查询操作类型
     * @return
     */
    List<SysUserOperationLog> queryType();
}
