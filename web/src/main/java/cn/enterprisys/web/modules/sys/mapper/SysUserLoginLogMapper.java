package cn.enterprisys.web.modules.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import cn.enterprisys.web.modules.sys.entity.SysUserLoginLog;
import cn.enterprisys.web.modules.sys.form.SysLoginLogForm;
import org.apache.ibatis.annotations.Param;

import java.util.List;


 public interface SysUserLoginLogMapper extends BaseMapper<SysUserLoginLog> {

    /**
     * 查询列表
     * @param sysLoginLogForm
     * @param page
     * @return
     */
    List<SysUserLoginLog> queryLoginLogList(@Param("sysLoginLogForm") SysLoginLogForm sysLoginLogForm, IPage page);
}
