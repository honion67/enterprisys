package cn.enterprisys.web;

import cn.enterprisys.WebApplication;
import cn.enterprisys.web.commons.enums.DeleteType;
import cn.enterprisys.web.modules.sys.mapper.MenuMapper;
import cn.enterprisys.web.modules.sys.entity.SysMenu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {WebApplication.class, SysMenuInfoTest.class})
public class SysMenuInfoTest {

    @Autowired
    private MenuMapper menuMapper;

    @Test
    public void testSave(){
        SysMenu sysMenu = new SysMenu();
        sysMenu.setMenuName("地图");
        sysMenu.setMenuCode("map");
        sysMenu.setMenuIcon("");
        sysMenu.setMenuType(2);
        sysMenu.setSort(31);
        sysMenu.setMenuCode("echarts");
        sysMenu.setMenuUrl("echarts/map.ftl");
        sysMenu.setDisable(DeleteType.NORMAL);
        menuMapper.insert(sysMenu);
    }

}
