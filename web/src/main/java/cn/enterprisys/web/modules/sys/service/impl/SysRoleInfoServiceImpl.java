package cn.enterprisys.web.modules.sys.service.impl;

import cn.enterprisys.web.modules.sys.mapper.SysRoleInfoMapper;
import cn.enterprisys.web.modules.sys.service.SysRoleInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.enterprisys.web.modules.sys.entity.SysRoleInfo;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SysRoleInfoServiceImpl extends ServiceImpl<SysRoleInfoMapper, SysRoleInfo> implements SysRoleInfoService {

    @Override
    public List<SysRoleInfo> queryUserRole(String userId) {
        return baseMapper.queryUserRole(userId);
    }

}
