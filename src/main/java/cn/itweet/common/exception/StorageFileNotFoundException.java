package cn.itweet.common.exception;

/**
 * Created by whoami on 22/04/2017.
 */
public class StorageFileNotFoundException extends RuntimeException {

    public StorageFileNotFoundException(String message) {
        super(message);
    }

    public StorageFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}