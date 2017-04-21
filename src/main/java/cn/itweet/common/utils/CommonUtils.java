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
        Collection<Integer> delElems = CollectionUtil.getDiffentNoDuplicate(intersectionElements,obj2);
        List<Integer> delE = new ArrayList<>();
        for (Integer del : delElems) {
            delE.add(del);
        }
        return delE;
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

}
