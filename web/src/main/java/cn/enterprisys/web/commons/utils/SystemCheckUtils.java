package cn.enterprisys.web.commons.utils;

import cn.enterprisys.web.commons.config.SysConstant;
import cn.enterprisys.web.commons.config.SystemConfig;
import cn.enterprisys.web.commons.entity.LayuiPage;
import link.ahsj.core.utils.base.AppAssertUtil;

import java.util.Objects;

/**
 * 系统校验工具类
 */
public class SystemCheckUtils {


    private static SystemConfig systemConfig = null;

    private SystemCheckUtils() {
    }

    private static SystemCheckUtils obj = null;


    public static SystemCheckUtils getInstance() {
        synchronized (SystemCheckUtils.class) {
            if (obj == null) {
                obj = new SystemCheckUtils();
            }
            return obj;
        }

    }


    /**
     * 校验分页数据大小
     * @param page
     */
    public void checkMaxPage(LayuiPage page) {
        if (Objects.nonNull(page)) {
            if (SysConstant.PAGE_ERR) {
                AppAssertUtil.isErr(page.getLimit() >= SysConstant.PAGE_MAX_RECORD, String.format("每页记录数超出%s条限制", SysConstant.PAGE_MAX_RECORD));
            } else {
                if (SysConstant.PAGE_MAX_RECORD < page.getLimit()) {
                    page.setLimit(SysConstant.PAGE_MAX_RECORD);
                }
            }
        }
    }
}