package cn.itweet.modules.admin.article.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by whoami on 17/04/2017.
 */
public class ArticleUtils {

    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");

    /**
     * 文章类型为 ： blog
     */
    private static final int isBlog = 0;
    /**
     * 文章类型为：tweet
     */
    private static final int isTweet = 1;

    /**
     * 文章发布状态，0为未发布
     */
    private static Integer unPublished = 0;
    /**
     * 文章发布状态，1为已发布
     */
    private static Integer isPublished = 1;

    /**
     * 格式化时间
     * @param time
     * @return
     */
    public static String parseToTime(Date time) {
        return sdf.format(time);
    }

    public static int getIsBlog() {
        return isBlog;
    }

    public static int getIsTweet() {
        return isTweet;
    }

    public static Integer getUnPublished() {
        return unPublished;
    }

    public static Integer getIsPublished() {
        return isPublished;
    }
}
