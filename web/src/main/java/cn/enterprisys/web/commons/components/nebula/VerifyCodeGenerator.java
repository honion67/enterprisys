package cn.enterprisys.web.commons.components.nebula;

import javax.servlet.http.HttpSession;


public interface VerifyCodeGenerator {

    /**
     * 生成校验码文本
     *
     * @param key
     * @param session
     * @return
     * @throws Exception
     */
    String generate(String key, HttpSession session) throws Exception;
}
