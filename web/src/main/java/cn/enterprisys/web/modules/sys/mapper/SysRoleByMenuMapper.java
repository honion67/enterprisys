package cn.enterprisys.web.modules.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cn.enterprisys.web.modules.sys.entity.SysRoleByMenu;
import org.apache.ibatis.annotations.Param;


public interface SysRoleByMenuMapper extends BaseMapper<SysRoleByMenu> {
    /**
     * 删除中间表数据
     * @param roleId
     */
    void deleteRoleAndMenu(@Param("roleId") String roleId);

    /**
     * 删除中间表数据
     * @param menuId
     */
    void deleteMenuAndRole(@Param("menuCode") String menuId);
}
