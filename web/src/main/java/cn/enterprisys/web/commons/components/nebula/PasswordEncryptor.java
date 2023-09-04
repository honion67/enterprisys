package cn.enterprisys.web.commons.components.nebula;


public interface PasswordEncryptor {

    /**
     * 默认密码
     */
    String DEFAULT_PASSWORD = "123456@!Ab";

    /**
     * 加密密码
     *
     * @param password 要加密的密码
     * @return
     */
    String encrypt(String password);

    /**
     * 解密密码
     *
     * @param encryptedPassword 已加密过的密码
     * @return
     */
    String decrypt(String encryptedPassword);
}
