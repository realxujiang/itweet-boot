package cn.itweet.common.utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * Created by whoami on 28/04/2017.
 */
public class SimplePageBuilder {

    /**
     * 以常量的形式存储，在实际的运用中应该从properties文件中取得，思路都一样
     * */
    public static final int size = 10;

    public static Pageable generate(int page, int size, Sort sort) {
        if(sort==null) return new PageRequest(page, size);
        return new PageRequest(page, size, sort);
    }

    public static Pageable generate(int page) {
        return generate(page,size,null);
    }

    public static Pageable generate(int page,Sort sort) {
        return generate(page,size,sort);
    }
}
