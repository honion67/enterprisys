package cn.enterprisys.web.commons.utils;

import org.springframework.context.annotation.Configuration;

/**
 * public class MyClass {
 *     private String demoProperty = SpringPropertiesUtil.getDemoProperty()
 * }
 * spring容器启动的时候会向SpringPropertiesUtil的setDemoProperty注入属性
 * 而setDemoProperty.demoProperty属性是静态变量所以可以读取到
解决自己new出来的对象无法注入属性字段的问题
 */
@Configuration
public class SpringPropertiesUtil {

    private static String demoProperty;

    public static String getDemoProperty() {
        return SpringPropertiesUtil.demoProperty;
    }
    //@Value("${demoProperty}")
    public void setDemoProperty(String demoProperty) {
        SpringPropertiesUtil.demoProperty = demoProperty;
    }
}
