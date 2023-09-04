package cn.enterprisys.web.modules.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cn.enterprisys.web.modules.sys.entity.SysRoleInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface SysRoleInfoMapper extends BaseMapper<SysRoleInfo> {

    /**
     * 查询用户角色
     *
     * @param userId
     * @return
     */
    List<SysRoleInfo> queryUserRole(@Param("userId") String userId);

}
