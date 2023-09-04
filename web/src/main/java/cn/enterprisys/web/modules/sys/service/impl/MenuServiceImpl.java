package cn.enterprisys.web.modules.sys.service.impl;

import cn.enterprisys.web.modules.sys.handler.SysMenuTreeHandler;
import cn.enterprisys.web.modules.sys.service.MenuService;
import cn.enterprisys.web.modules.sys.service.SysMenuService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import cn.enterprisys.web.commons.config.SysConstant;
import cn.enterprisys.web.commons.enums.DeleteType;
import cn.enterprisys.web.modules.sys.entity.SysMenu;
import cn.enterprisys.web.modules.sys.entity.SysUser;
import cn.enterprisys.web.commons.entity.CacheKeyConstant;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class MenuServiceImpl   implements MenuService {


    @Autowired
    private SysMenuService sysMenuService;
    @Autowired
    private SysMenuTreeHandler sysMenuTreeHandler;
    /**
     * 查询上级ID
     *
     * @param childId
     * @return
     */
    @Override
    public String queryParentId(String childId) {
        return sysMenuService.queryParentId(childId);
    }

    /**
     * 树形结构
     *
     * @param
     * @param page
     * @return
     */
    @Override
    public List<Map> queryList(IPage page) {
        return sysMenuService.queryList(page);
    }

    @Cacheable(value = CacheKeyConstant.MENU_CACHE_KEY, key = "'menu:'.concat(#username)")
    @Override
    public List<SysMenu> selectByUserName(String username) {
        List<SysMenu> menuList;
        if (username.equals(SysConstant.SUPER_USER)) {
            menuList = sysMenuService.list(new QueryWrapper<SysMenu>().orderByDesc("SORT"));
        } else {
            menuList = sysMenuService.selectByUserName(username);
        }
        return menuList;
    }

    @Override
    public List<SysMenu> queryUserLeftMenu(SysUser sysUser) {
        //获取用户左侧菜单
        List<SysMenu> sysMenus = this.selectByUserName(sysUser.getUsername());
        List<Integer> types = Arrays.asList(1, 2, 3);
        //过滤掉按钮菜单
        if (CollectionUtils.isNotEmpty(sysMenus)) {
            sysMenus = sysMenus.stream().filter(m -> types.contains(m.getMenuType())).collect(Collectors.toList());
            sysMenus = sysMenus.stream().filter(m -> DeleteType.NORMAL.equals(m.getDisable())).collect(Collectors.toList());
        }
        //解析成树形结构菜单
        return sysMenuTreeHandler.parseTree(sysMenus);
    }


}
