package cn.itweet.modules.admin.article.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by whoami on 17/04/2017.
 */
public class ArticleUtils {
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");

    /**
     * 格式化时间
     * @param time
     * @return
     */
    public static String parseToTime(Date time) {
        return sdf.format(time);
    }
}
