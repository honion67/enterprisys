package cn.enterprisys.web.modules.sys.service.impl;

import cn.enterprisys.web.modules.sys.mapper.SysUserMapper;
import cn.enterprisys.web.modules.sys.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.enterprisys.web.modules.sys.entity.SysUser;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Override
    public SysUser queryUserInfo(String id) {
        return baseMapper.queryUserInfo(id);
    }
}
