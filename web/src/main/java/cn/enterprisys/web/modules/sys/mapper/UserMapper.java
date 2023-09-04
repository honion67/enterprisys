package cn.enterprisys.web.modules.sys.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import cn.enterprisys.web.modules.sys.form.SysUserForm;
import cn.enterprisys.web.modules.sys.vo.SysUserVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserMapper {

    /**
     * 查询用户列表
     *
     * @param sysUserForm
     * @param page
     * @return
     */
    List<SysUserVo> queryList(@Param("sysUserForm") SysUserForm sysUserForm , @Param("page")IPage page);

}
