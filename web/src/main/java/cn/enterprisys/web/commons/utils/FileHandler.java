package cn.enterprisys.web.commons.utils;

import cn.enterprisys.web.commons.config.SysConstant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;

//文件上传删除
public interface FileHandler {

    MediaType IMAGE_TYPE = MediaType.valueOf("image/*");


    static boolean isImageType(@Nullable String mediaType) {
        return mediaType != null && IMAGE_TYPE.includes(MediaType.valueOf(mediaType));
    }


    static boolean isImageType(@Nullable MediaType mediaType) {
        return mediaType != null && IMAGE_TYPE.includes(mediaType);
    }

    //目录名称
    @NonNull
    static String normalizeDirectory(@NonNull String dir) {
        Assert.hasText(dir, "Directory full name must not be blank");

        return StringUtils.appendIfMissing(dir, SysConstant.FILE_SEPARATOR);
    }

    //上传文件
    @NonNull
    UploadResult upload(@NonNull MultipartFile file,@NonNull String workDir);


    void delete(@NonNull String key, String workDir) ;

}
