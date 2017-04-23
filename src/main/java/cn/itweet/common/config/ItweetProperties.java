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
}
