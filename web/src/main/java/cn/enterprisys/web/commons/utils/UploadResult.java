package cn.enterprisys.web.commons.utils;

import lombok.Data;
import lombok.ToString;
import org.springframework.http.MediaType;


@Data
@ToString
public class UploadResult {

    /**
     * 文件名字
     */
    private String filename;

    private String filePath;

    private String key;

    private String thumbPath;

    private String suffix;

    private MediaType mediaType;

    private Long size;

    private Integer width;

    private Integer height;

}
