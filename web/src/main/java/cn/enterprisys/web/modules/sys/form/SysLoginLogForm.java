package cn.enterprisys.web.modules.sys.form;


import cn.enterprisys.web.modules.sys.entity.SysUserLoginLog;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SysLoginLogForm extends SysUserLoginLog {
    private String startDate;
    private String endDate;
}
