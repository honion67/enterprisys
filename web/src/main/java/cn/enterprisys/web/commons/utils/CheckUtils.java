package cn.enterprisys.web.commons.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import cn.enterprisys.web.commons.config.SysConstant;
import cn.enterprisys.web.commons.config.SystemConfig;
import link.ahsj.core.utils.base.AppAssertUtil;

import java.util.Objects;

//系统校验工具类

public class CheckUtils {


    private static SystemConfig systemConfig = null;

    private CheckUtils() {
    }

    private static CheckUtils obj = null;


    public static CheckUtils getInstance() {
        synchronized (CheckUtils.class) {
            if (obj == null) {
                obj = new CheckUtils();
            }
            return obj;
        }

    }


    //校验分页数据大小

    public void checkMaxPage(IPage<?> page) {
        if (Objects.nonNull(page)) {
            if (SysConstant.PAGE_ERR) {
                AppAssertUtil.isErr(page.getSize() >= SysConstant.PAGE_MAX_RECORD, String.format("每页记录数超出%s条限制", SysConstant.PAGE_MAX_RECORD));
            } else {
                if (SysConstant.PAGE_MAX_RECORD < page.getSize()) {
                    page.setSize(SysConstant.PAGE_MAX_RECORD);
                }
            }
        }
    }
}