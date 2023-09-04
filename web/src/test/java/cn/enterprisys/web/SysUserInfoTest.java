package cn.enterprisys.web;

import cn.enterprisys.WebApplication;
import cn.enterprisys.web.modules.sys.service.SysUserService;
import cn.enterprisys.web.modules.sys.service.UserRoleMenuService;
import cn.enterprisys.web.modules.sys.entity.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {WebApplication.class, SysUserInfoTest.class})
public class SysUserInfoTest {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private UserRoleMenuService roleInfoService;

    @Test
    public void testSave() {
        List<SysUser> list = sysUserService.list();
        list.forEach(System.out::println);
    }

    @Test
    public void testSelect() {
        List list = sysUserService.list(sysUserService.lambdaQuery().like(true, SysUser::getUsername, "admin").getWrapper());
        list.forEach(System.out::println);
    }
}
