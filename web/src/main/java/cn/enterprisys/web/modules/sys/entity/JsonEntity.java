package cn.enterprisys.web.modules.sys.entity;

import cn.enterprisys.web.commons.utils.JacksonUtil;
import cn.enterprisys.web.commons.utils.SpringBeanUtil;


public class JsonEntity {

    @Override
    public String toString() {
        JacksonUtil jacksonUtil = SpringBeanUtil.getBean(JacksonUtil.class);
        return jacksonUtil.objToJsonStr(this);
    }
}
