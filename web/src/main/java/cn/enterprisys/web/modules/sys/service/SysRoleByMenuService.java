package cn.enterprisys.web.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.enterprisys.web.modules.sys.entity.SysRoleByMenu;
import org.springframework.stereotype.Service;


@Service
public interface SysRoleByMenuService extends IService<SysRoleByMenu> {

    /**
     * 删除中间表数据
     * @param roleId
     */
    void deleteRoleAndMenu(String roleId);

    /**
     * 删除中间表数据
     * @param menuId
     */
    void deleteMenuAndRole(String menuId);


}
