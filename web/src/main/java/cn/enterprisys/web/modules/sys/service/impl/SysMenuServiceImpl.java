package cn.enterprisys.web.modules.sys.service.impl;

import cn.enterprisys.web.modules.sys.mapper.SysMenuMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.enterprisys.web.modules.sys.entity.SysMenu;
import cn.enterprisys.web.modules.sys.service.SysMenuService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;


@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    /**
     * 查询上级ID
     *
     * @param childId
     * @return
     */
    @Override
    public String queryParentId(String childId) {
        return sysMenuMapper.queryParentId(childId);
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
        return sysMenuMapper.queryList(page);
    }

    @Override
    public List<SysMenu> queryMenuParentName(String parentMenuCode) {
        return sysMenuMapper.queryMenuParentName(parentMenuCode);
    }

    @Override
    public List<SysMenu> selectByUserName(String username) {
        return sysMenuMapper.selectByUserName(username);
    }

    @Override
    public List<SysMenu> queryRoleMenus(String roleId) {
        if (StringUtils.isEmpty(roleId)) {
            return Collections.EMPTY_LIST;
        }
        return sysMenuMapper.queryRoleMenus(roleId);
    }
}
