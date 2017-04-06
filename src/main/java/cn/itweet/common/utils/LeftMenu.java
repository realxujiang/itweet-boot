package cn.itweet.common.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by whoami on 05/04/2017.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LeftMenu {

    /**
     * 权限定义ROLE_*
     * @return
     */
    public String remark();

    /**
     * 默认值：add开头表示添加，update表示更新，list开头表示列表，delete开头表示删除
     * @return
     */
    public String value();

    /**
     *  父类标识
     * @return
     */
    public String pname();

    /**
     * 当前类的标识
     * @return
     */
    public String pcname();

    /**
     *  请求路径
     * @return
     */
    public String href() default "";
}
