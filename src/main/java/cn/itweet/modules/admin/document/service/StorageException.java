package cn.itweet.modules.admin.document.service;

/**
 * Created by whoami on 22/04/2017.
 */
public class StorageException extends RuntimeException {

    public StorageException(String message) {
        super(message);
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }

}
