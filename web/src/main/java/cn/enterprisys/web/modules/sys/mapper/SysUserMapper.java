package cn.enterprisys.web.modules.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cn.enterprisys.web.modules.sys.entity.SysUser;
import org.apache.ibatis.annotations.Param;

public interface SysUserMapper extends BaseMapper<SysUser> {



    /**
     * 查询用户相关信息
     *
     * @param id
     * @return
     */
    SysUser queryUserInfo(@Param("userId") String id);
}
