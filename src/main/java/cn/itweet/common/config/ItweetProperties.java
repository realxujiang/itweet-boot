package cn.itweet.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by whoami on 23/04/2017.
 */
@Component
public class ItweetProperties {

    @Value("${application.upload.suffix}")
    private String uploadSuffix;

    @Value("${application.upload.type.image}")
    private String uploadTypeImage;

    @Value("${application.upload.type.files}")
    private String uploadTypeFiles;

    @Value("${application.page.size}")
    private Integer pagSize;

    @Value("${application.front}")
    private String theme;

    public String getUploadSuffix() {
        return uploadSuffix;
    }

    public void setUploadSuffix(String uploadSuffix) {
        this.uploadSuffix = uploadSuffix;
    }

    public String getUploadTypeImage() {
        return uploadTypeImage;
    }

    public void setUploadTypeImage(String uploadTypeImage) {
        this.uploadTypeImage = uploadTypeImage;
    }

    public String getUploadTypeFiles() {
        return uploadTypeFiles;
    }

    public void setUploadTypeFiles(String uploadTypeFiles) {
        this.uploadTypeFiles = uploadTypeFiles;
    }

    public Integer getPagSize() {
        return pagSize;
    }

    public void setPagSize(Integer pagSize) {
        this.pagSize = pagSize;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
}
