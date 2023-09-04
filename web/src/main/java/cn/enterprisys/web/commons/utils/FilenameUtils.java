package cn.enterprisys.web.commons.utils;

import cn.enterprisys.web.commons.config.SysConstant;
import link.ahsj.core.utils.base.AppAssertUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.lang.NonNull;
import org.springframework.util.Assert;

import java.io.File;


public class FilenameUtils {

    private FilenameUtils() {
    }


    @NonNull
    public static String getBasename(@NonNull String filename) {
        AppAssertUtil.isBlank(filename, "Filename must not be blank");

        // Find the last slash
        int separatorLastIndex = StringUtils.lastIndexOf(filename, File.separatorChar);

        if (separatorLastIndex == filename.length() - 1) {
            return "";
        }

        if (separatorLastIndex >= 0 && separatorLastIndex < filename.length() - 1) {
            filename = filename.substring(separatorLastIndex + 1);
        }

        // Find last dot
        int dotLastIndex = StringUtils.lastIndexOf(filename, '.');

        if (dotLastIndex < 0) {
            return filename;
        }

        return filename.substring(0, dotLastIndex);
    }

    //文件扩展名
    @NonNull
    public static String getExtension(@NonNull String filename) {

        AppAssertUtil.isBlank(filename, "Filename must not be blank");
        // Find the last slash
        int separatorLastIndex = StringUtils.lastIndexOf(filename, File.separatorChar);

        if (separatorLastIndex == filename.length() - 1) {
            return "";
        }

        if (separatorLastIndex >= 0 && separatorLastIndex < filename.length() - 1) {
            filename = filename.substring(separatorLastIndex + 1);
        }

        // Find last dot
        int dotLastIndex = StringUtils.lastIndexOf(filename, '.');

        if (dotLastIndex < 0) {
            return "";
        }

        return filename.substring(dotLastIndex + 1);
    }

    //路径分隔符
    public static String changeFileSeparatorToUrlSeparator(@NonNull String pathname) {
        Assert.hasText(pathname, "Path name must not be blank");

        return pathname.replace(SysConstant.FILE_SEPARATOR, "/");
    }

}
