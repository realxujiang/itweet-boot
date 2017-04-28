package cn.itweet.common.utils;

import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by whoami on 28/04/2017.
 */
public class SimpleSortBuilder {

    /**
     * 调用的时候使用SimpleSortBuilder.generateSort("name","xh_d");表示先以name升序，之后以xh降序
     */
    public static Sort generateSort(String... fields) {
        List<Sort.Order> orders = new ArrayList<Sort.Order>();
        for(String f:fields) {
            orders.add(generateOrder(f));
        }
        return new Sort(orders);
    }

    private static Sort.Order generateOrder(String f) {
        Sort.Order order = null;
        String[] ff = f.split("_");
        if(ff.length>=2) {
            if(ff[1].equals("d")) {
                order = new Sort.Order(Sort.Direction.DESC,ff[0]);
            } else {
                order = new Sort.Order(Sort.Direction.ASC,ff[0]);
            }
            return order;
        }
        order = new Sort.Order(f);
        return order;
    }
}
