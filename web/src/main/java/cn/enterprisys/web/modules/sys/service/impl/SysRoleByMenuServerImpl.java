package cn.enterprisys.web.modules.sys.service.impl;

import cn.enterprisys.web.modules.sys.mapper.SysRoleByMenuMapper;
import cn.enterprisys.web.modules.sys.service.SysRoleByMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.enterprisys.web.modules.sys.entity.SysRoleByMenu;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class SysRoleByMenuServerImpl extends ServiceImpl<SysRoleByMenuMapper, SysRoleByMenu> implements SysRoleByMenuService {

    @Autowired
    private SysRoleByMenuMapper sysRoleByMenuMapper;

    @Override
    public void deleteRoleAndMenu(String roleId) {
        sysRoleByMenuMapper.deleteRoleAndMenu(roleId);
    }

    @Override
    public void deleteMenuAndRole(String menuId) {
        sysRoleByMenuMapper.deleteMenuAndRole(menuId);
    }
}
