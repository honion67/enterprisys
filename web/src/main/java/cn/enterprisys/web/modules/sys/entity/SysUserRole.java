package cn.enterprisys.web.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@TableName("SYS_USER_ROLE")
@AllArgsConstructor
@NoArgsConstructor
public class SysUserRole implements Serializable {

    private String userId;
    private String roleId;
}
