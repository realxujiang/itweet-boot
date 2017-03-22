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
        a.add(5);
        a.add(6);

        List<Integer> b = new ArrayList<>();
        b.add(2);
        b.add(3);
        b.add(4);
        b.add(5);
        b.add(7);

        List<Integer> list = CommonUtils.getDeleteElements(a,b);
        Assert.assertEquals(2,list.size());
    }

    @Test
    public void getAggrandizeElements() {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(3);
        a.add(4);
        a.add(5);

        List<Integer> b = new ArrayList<>();
        b.add(2);
        b.add(3);
        b.add(4);
        b.add(5);
        b.add(7);

        List<Integer> list = CommonUtils.getAggrandizeElements(a,b);
        Assert.assertEquals(1,list.size());
    }

}
