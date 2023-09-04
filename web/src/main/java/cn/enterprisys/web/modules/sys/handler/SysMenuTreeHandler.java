package cn.enterprisys.web.modules.sys.handler;

import cn.enterprisys.web.modules.sys.entity.SysMenu;
import cn.enterprisys.web.modules.sys.vo.SysMenuList;
import cn.enterprisys.web.commons.builder.SysMenuTreeSelect;

import java.util.List;


public interface SysMenuTreeHandler {

    /***
     * 解析成树形结构
     * @param sysMenus
     * @return
     */
    List<SysMenu> parseTree(List<SysMenu> sysMenus);

    /**
     * 树结构格式封装
     * @param stringList
     * @return
     */
    List<SysMenuList>  parseList(List<SysMenuList> stringList);

    /**
     * 封装树形下拉框
     * @param sysMenuTreeSelects
     * @return
     */
    List<SysMenuTreeSelect> parseMenuList(List<SysMenuTreeSelect> sysMenuTreeSelects);
}
