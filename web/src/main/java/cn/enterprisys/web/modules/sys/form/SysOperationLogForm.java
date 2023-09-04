package cn.enterprisys.web.modules.sys.form;


import cn.enterprisys.web.modules.sys.entity.SysUserOperationLog;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SysOperationLogForm extends SysUserOperationLog {
    private String startDate;
    private String endDate;
}
