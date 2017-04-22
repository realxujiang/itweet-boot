package cn.itweet.modules.admin.document.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by whoami on 22/04/2017.
 */
@ConfigurationProperties("storage")
public class StorageProperties {

    /**
     * Folder location for storing files
     */
    private String location = "target/classes/static/upload/images/";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
