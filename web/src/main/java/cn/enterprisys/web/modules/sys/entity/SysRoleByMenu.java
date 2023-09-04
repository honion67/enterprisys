package cn.enterprisys.web.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@TableName("SYS_ROLE_MENU")
public class SysRoleByMenu {

    private String roleId;

    private String menuCode;
}
