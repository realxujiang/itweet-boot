package cn.itweet.common.exception;

/**
 * 说明：
 * 包名：cn.itweet.common.exception
 * 项目名：itweet-boot
 * 创建人：孙大飞
 * 创建时间：2017/3/16.
 */
public class ValidateException  extends Exception{
    public ValidateException() {
        super();
    }

    public ValidateException(String message) {
        super(message);
    }

    public ValidateException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidateException(Throwable cause) {
        super(cause);
    }

    protected ValidateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
