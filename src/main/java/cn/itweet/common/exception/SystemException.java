package cn.itweet.common.exception;

import java.io.IOException;

/**
 * Created by whoami on 13/03/2017.
 */
public class SystemException extends Exception{
    public SystemException(String message) {
        super(message);
    }

    public SystemException(String message, IOException e) {
        super(message,e);
    }

}
