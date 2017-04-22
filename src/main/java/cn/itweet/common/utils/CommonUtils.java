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
     * @param obj  传入的值
     * @param dbElems  数据库取出的值
     * @return
     */
    public static List<Integer> getDeleteElements(List<Integer> obj,List<Integer> dbElems) {
        List<Integer> intersectionElements = getIntersectionElements(obj, dbElems);
        List<Integer> delElems = getNoDuplicateElems(dbElems, intersectionElements);
        return delElems;
    }

    private static List<Integer> getNoDuplicateElems(List<Integer> obj2, List<Integer> intersectionElements) {
        Collection<Integer> NoDuplicateElems = CollectionUtil.getDiffentNoDuplicate(intersectionElements,obj2);
        List<Integer> delElems = new ArrayList<>();
        for (Integer del : NoDuplicateElems) {
            delElems.add(del);
        }
        return delElems;
    }

    /**
     *
     * @param obj  传入的值
     * @param dbElems  数据库取出的值
     * @return
     */
    public static List<Integer>  getAggrandizeElements(List<Integer> obj,List<Integer> dbElems) {
        List<Integer> intersectionElements = getIntersectionElements(obj, dbElems);
        List<Integer> aggElems = getNoDuplicateElems(obj, intersectionElements);
//        for (int i=0; i < obj.size(); i++) {
//            for (int j=0; j<intersectionElements.size(); j++) {
//                if (obj.get(i) == intersectionElements.get(j)) {
//                    obj.remove(i);
//                }
//            }
//        }
        return aggElems;
    }

    /**
     * 获取两个集合类中元素的交集
     * @param obj1
     * @param obj2
     * @return
     */
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
