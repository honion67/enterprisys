package cn.enterprisys.web.modules.sys.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;


@Data
public class LoginForm {

    public static final String KEY_PAIR_STR = "keyPair";
    public static final String LOGIN_CODE_STR = "captcha";
    public static final String LOGIN_USER_KEY = "user";
    public static final String NO_LOGIN_TO_URL_SCRIPT = "<script>top.location.href='%s/sign/login.html'</script>";

    @NotBlank(message = "账号不能为空")
    private String username;
    @NotBlank(message = "密码不能为空")
    private String password;
    @NotBlank(message = "验证码不能为空")
    private String code;
}
