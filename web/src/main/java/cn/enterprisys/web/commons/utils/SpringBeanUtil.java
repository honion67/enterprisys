package cn.enterprisys.web.commons.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**

 * @Component
 * public class AnotherClass {
 *      /...
 * }

 * public class MyClass {
 *     private AnotherClass anotherClass = SpringBeanUtil.getBean(AnotherClass.class)
 * }

 */
@Component
public class SpringBeanUtil implements ApplicationContextAware {
    protected static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    /**
     * 通过bean name 获取bean
     *
     * @param name
     * @return
     */
    public static Object getBean(String name) {
        return context.getBean(name);
    }

    /**
     * 通过bean的类型 获取bean
     *
     * @param clz
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> clz) {
        return context.getBean(clz);
    }

    /**
     * 通过bean name 和bean 的类型 获取bean对象
     *
     * @param clz
     * @param <T>
     * @return
     */
    public static <T> T getBean(String name, Class<T> clz) {
        return context.getBean(name, clz);
    }
}
