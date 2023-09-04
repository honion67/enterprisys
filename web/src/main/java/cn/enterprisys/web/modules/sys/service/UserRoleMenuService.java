package cn.enterprisys.web.modules.sys.service;

import cn.enterprisys.web.modules.sys.entity.SysRoleInfo;
import cn.enterprisys.web.modules.sys.form.RoleMenuForm;

import java.util.List;

/**
 * 用户角色关系 角色菜单关系 相关操作
 */
public interface UserRoleMenuService {

    /**
     * 查询可用的角色列表
     *
     * @return
     */
    List<SysRoleInfo> queryEnableRole();


    /**
     *  添加角色跟菜单相关关系
     * @param roleMenuForm
     */
    boolean insertRoleAndMenu(RoleMenuForm roleMenuForm);


    /**
     * 更新角色角色跟菜单相关关系
     * @param roleMenuForm
     */
    boolean updateRoleAndMenu(RoleMenuForm roleMenuForm);





}
