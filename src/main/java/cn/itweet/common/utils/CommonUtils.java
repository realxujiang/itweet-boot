package cn.itweet.common.utils;

import cn.itweet.modules.admin.user.entity.SysPermission;
import cn.itweet.modules.admin.user.repository.PermissionRepository;
import cn.itweet.modules.admin.user.repository.PermissionRoleRepository;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by whoami on 22/03/2017.
 */
public class CommonUtils {

    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");

    /**
     * 格式化时间
     * @param time
     * @return
     */
    public static String parseToTime(Date time) {
        return sdf.format(time);
    }

    /**
     * 比较两个List元素是否相同
     * @param a
     * @param b
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> boolean compare(List<T> a, List<T> b) {
        if(a.size() != b.size())
            return false;
        Collections.sort(a);
        Collections.sort(b);
        for(int i=0;i<a.size();i++){
            if(!a.get(i).equals(b.get(i)))
                return false;
        }
        return true;
    }

    /**
     *
     * @param obj1  传入的值
     * @param obj2  数据库取出的值
     * @return
     */
    public static List<Integer> getDeleteElements(List<Integer> obj1,List<Integer> obj2) {
        List<Integer> intersectionElements = getIntersectionElements(obj1, obj2);
        List<Integer> delElems = getDelElems(obj2, intersectionElements);
        return delElems;
    }

    private static List<Integer> getDelElems(List<Integer> obj2, List<Integer> intersectionElements) {
        List<Integer> dElems = new ArrayList<>();
        for (int i=0; i < obj2.size(); i++) {
            for (int j=0; j<intersectionElements.size(); j++) {
                if (obj2.get(i) != intersectionElements.get(j)) {
                    dElems.add(obj2.get(i));
                }
            }
        }
        return dElems;
    }

    /**
     *
     * @param obj1  传入的值
     * @param obj2  数据库取出的值
     * @return
     */
    public static List<Integer>  getAggrandizeElements(List<Integer> obj1,List<Integer> obj2) {
        List<Integer> intersectionElements = getIntersectionElements(obj1, obj2);
        for (int i=0; i < obj1.size(); i++) {
            for (int j=0; j<intersectionElements.size(); j++) {
                if (obj1.get(i) == intersectionElements.get(j)) {
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
            for (int x=0; x<obj2.size(); x++) {
                if (tmp == obj2.get(x)) {
                    intersectionElements.add(tmp);
                }
            }
        }
        return intersectionElements;
    }

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(2);
        a.add(3);
        a.add(1);
        a.add(4);

        List<Integer> b = new ArrayList<>();
        b.add(2);
        b.add(19);

        List<Integer> list = getDeleteElements(a,b);
        for (Integer i: list) {
            System.out.println("getDeleteElements: "+i);
        }

        List<Integer> list2 = getAggrandizeElements(a,b);
        for (Integer i: list2) {
            System.out.println("getAggrandizeElements: "+i);
        }

        List<Integer> c = Arrays.asList(1,2,3,4);
        List<Integer> d = Arrays.asList(4,3,2,1);
        System.out.println(compare(c, d));
    }
}
