package com.dean;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: Dean
 * @Date: 2018/8/9 15:26
 * @Description:
 */
public class TestCollection {

    @Test
    public void testParallam(){

        Set<String> s = new HashSet();
        s.add("aaaa");
        s.add("bbbb");
        s.add("cccc");
        s.add("dddd");

//        s.parallelStream().forEach( (str) -> {
//            System.out.println(str);
//        });


        s.parallelStream().filter((str) -> {
            if(StringUtils.isNotBlank(str) && str.equals("aaaa")){
                return false;
            }else{
                return true;
            }
        }).forEach((str) -> {
            System.out.println(str);
        });
    }

}
