package cn.enterprisys.web.modules.sys.form;

import link.ahsj.core.annotations.AddGroup;
import link.ahsj.core.annotations.UpdateGroup;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.List;


@Getter
@Setter
public class RoleMenuForm {
    /**
     * 菜单的权限标识
     */
    private List<String> authMenuCodes;


    @NotBlank(message = "角色ID不能为空", groups = {UpdateGroup.class})
    private String roleId;


    @NotBlank(message = "角色名称不能空", groups = {UpdateGroup.class, AddGroup.class})
    private String roleName;


    @NotBlank(message = "所属角色不能空", groups = {UpdateGroup.class, AddGroup.class})
    private String pid;

    @NotBlank(message = "角色编码不能空", groups = {UpdateGroup.class, AddGroup.class})
    private String roleCode;


    @NotBlank(message = "角色描述不能空", groups = {UpdateGroup.class, AddGroup.class})
    private String description;

    private int level;

    /**
     * 业务层级
     */
    private String businessLevel;








}
