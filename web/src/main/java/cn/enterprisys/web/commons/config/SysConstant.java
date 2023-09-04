package cn.enterprisys.web.commons.config;

import java.io.File;


public interface SysConstant {


   //业务后缀
    public static final String BUSI_PREFIX = ":";

    //每页查询最大记录数

    Integer PAGE_MAX_RECORD = 200;

    //分页报错,如果是false就会用最大值赋值,如果是true,就会抛出异常

    boolean PAGE_ERR = false;

    //系统超级管理员

    String SUPER_USER = "admin";

    //顶级角色id

    String ADMIN_RILE_PID = "0000";

    String ADMIN_ORG_PID = "0000";

    //Path separator.

    String FILE_SEPARATOR = File.separator;
}
