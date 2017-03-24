package cn.itweet.common.utils;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by whoami on 22/03/2017.
 */
public class CommonUtilsTests {

    @Test
    public void getDeleteElementsTest() {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(3);
        a.add(4);

        List<Integer> b = new ArrayList<>();
        b.add(3);
        b.add(7);
        b.add(6);

        List<Integer> list = CommonUtils.getDeleteElements(a,b);
        System.out.println(list.toString());
        Assert.assertEquals(2,list.size());
    }

    @Test
    public void getAggrandizeElements() {
        List<Integer> a = new ArrayList<>();
        a.add(3);
        a.add(7);
        a.add(6);
        a.add(8);
        a.add(9);

        List<Integer> b = new ArrayList<>();
        b.add(3);
        b.add(7);
        b.add(6);

        List<Integer> list = CommonUtils.getAggrandizeElements(a,b);
        System.out.println(list.toString());
        Assert.assertEquals(2,list.size());
    }

}
