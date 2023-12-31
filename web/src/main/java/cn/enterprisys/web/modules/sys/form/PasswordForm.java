package cn.enterprisys.web.modules.sys.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 修改密码表单
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PasswordForm implements Serializable {

    @NotBlank(message = "原密码不能为空")
    private String oldPassword;

    /**
     * 前端加密接收时无效进行验证,如要正则验证请解析完成后
     */
    @NotBlank(message = "新密码不能为空")
    @Length(min = 6, message = "密码不能少6位数")
    private String newPassword;

}
