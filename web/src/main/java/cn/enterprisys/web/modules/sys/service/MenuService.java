package cn.enterprisys.web.modules.sys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import cn.enterprisys.web.modules.sys.entity.SysMenu;
import cn.enterprisys.web.modules.sys.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface MenuService  {



    /**
     * 查询上级ID
     *
     * @param childId
     * @return
     */
    String queryParentId(@Param("childId") String childId);

    /**
     * 树形结构
     *
     * @param
     * @param page
     * @return
     */
    List<Map> queryList(IPage page);


    /**
     * 根据用户名查询对应的权限菜单
     *
     * @param username
     * @return
     */
    List<SysMenu> selectByUserName(String username);

    /**
     * 查询用户左侧菜单
     *
     * @param sysUser
     * @return
     */
    List<SysMenu> queryUserLeftMenu(SysUser sysUser);

}
