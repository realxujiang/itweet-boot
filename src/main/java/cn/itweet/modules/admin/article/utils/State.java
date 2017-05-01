package cn.itweet.modules.admin.article.utils;

/**
 * Created by whoami on 30/04/2017.
 */
public class State {
    /**
     * 文章发布状态，0为未发布
     */
    private static Integer unPublished = 0;
    /**
     * 文章发布状态，1为已发布
     */
    private static Integer isPublished = 1;

    public static Integer getUnPublished() {
        return unPublished;
    }

    public static void setUnPublished(Integer unPublished) {
        State.unPublished = unPublished;
    }

    public static Integer getIsPublished() {
        return isPublished;
    }

    public static void setIsPublished(Integer isPublished) {
        State.isPublished = isPublished;
    }
}
