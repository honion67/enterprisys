package cn.enterprisys.web.modules.sys.form;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class SysUserForm {

    private String username;
    private String nickName;
    private String phone;
    private String deptId;
    private String businessLevel;
    private Integer disable;
    private List<String> roles;

}
