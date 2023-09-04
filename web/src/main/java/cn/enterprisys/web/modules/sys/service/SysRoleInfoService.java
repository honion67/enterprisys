package cn.enterprisys.web.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.enterprisys.web.modules.sys.entity.SysRoleInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface SysRoleInfoService extends IService<SysRoleInfo> {

    /**
     * 查询用户角色
     *
     * @param userId
     * @return
     */
    List<SysRoleInfo> queryUserRole(@Param("userId") String userId);

}
