package cn.itweet.common.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by whoami on 22/03/2017.
 */
public class CommonUtils {

    /**
     *
     * @param obj1  传入的值
     * @param obj2  数据库取出的值
     * @return
     */
    public static List<Integer> getDeleteElements(List<Integer> obj1,List<Integer> obj2) {
        List<Integer> intersectionElements = getIntersectionElements(obj1, obj2);
        for (int i=0; i < obj2.size(); i++) {
            for (int j=0; j<intersectionElements.size(); j++) {
                if (obj2.get(i).equals(intersectionElements.get(j))) {
                    obj2.remove(i);
                }
            }
        }
        return obj2;
    }

    /**
     *
     * @param obj1  传入的值
     * @param obj2  数据库取出的值
     * @return
     */
    public static List<Integer>  getAggrandizeElements(List<Integer> obj1,List<Integer> obj2) {
        List<Integer> intersectionElements = getIntersectionElements(obj1, obj2);
        List<Integer> aggrandizeElements = getAggElements(obj1, intersectionElements);
        return aggrandizeElements;
    }

    private static List<Integer> getAggElements(List<Integer> obj1, List<Integer> intersectionElements) {
        for (int i=0; i < obj1.size(); i++) {
            for (int j=0; j<intersectionElements.size(); j++) {
                if (obj1.get(i).equals(intersectionElements.get(j))) {
                    obj1.remove(i);
                }
            }
        }
        return obj1;
    }

    private static List<Integer> getIntersectionElements(List<Integer> obj1, List<Integer> obj2) {
        List<Integer> intersectionElements = new ArrayList<>();
        for (int i=0; i < obj1.size();i++ ) {
            int tmp = obj1.get(i);
            for (int x=0; x<obj2.size();x++) {
                if (tmp == obj2.get(x)) {
                    intersectionElements.add(tmp);
                }
            }
        }
        return intersectionElements;
    }

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(3);
        a.add(4);
        a.add(5);
        a.add(6);

        List<Integer> b = new ArrayList<>();
        b.add(2);
        b.add(3);
        b.add(4);
        b.add(5);
        b.add(7);

        List<Integer> list = getDeleteElements(a,b);
        for (Integer i: list) {
            System.out.println(i);
        }

    }
}
