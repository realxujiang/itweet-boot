package cn.itweet.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 包名：cn.itweet.common.utils
 * 项目名：itweet-boot
 * 创建人：孙大飞
 * 创建时间：2017/4/22.
 */
public class TimeMillisUtils {

    private static SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd-HHmmss");

    /**
     * 以当前时间为时间戳
     * @return
     */
    public static String getTimeMillis(){
        return df.format(new Date());
    }
}
