package com.company;

import java.util.HashMap;
import java.util.Map;

public class RightLeft {
    Map<String, Integer> left;

    Map<String, Integer> right;



    public void setUp(){

        left = new HashMap<String, Integer>();

        left.put("a", 1);

        left.put("b", 2);

        left.put("c", 3);



        right = new HashMap<String, Integer>();

        right.put("b", 2);

        right.put("c", 4);

        right.put("d", 5);
    }
    /*

     * <pre>

     * 備住：有兩個Map left right，請在Test()內完成程式碼輸出以下內容

     *

     * 1.key一樣value不一樣的內容

     * 2.key一樣value一樣的內容

     * 3.key只存在left不存在right的內容

     * 4.key只存在right不存在left的內容

     *

     */



    public void Test(){

        System.out.println("Map Answer 1.");
        for(Object key: left.keySet()){
            if (right.get(key)!=null){
                if (!left.get(key).equals(right.get(key))){
                   System.out.println("leftkey = " + key + " value = " + left.get(key));
                   System.out.println("rightkey = " + key + " value = " + right.get(key));
                }
            }
        }

        System.out.println("Map Answer 2.");
        for(Object key: left.keySet()){
            if (right.get(key)!=null){
                if (left.get(key).equals(right.get(key))){
                    System.out.println("leftkey = " + key + " value = " + left.get(key));
                    System.out.println("rightkey = " + key + " value = " + right.get(key));
                }
            }
        }

        System.out.println("Map Anser 3.");
        for(Object key: left.keySet()){
            if (right.get(key)==null){
                System.out.println("leftkey = " + key + " value = " + left.get(key));
            }
        }

        System.out.println("Map Anser 4.");
        for(Object key: right.keySet()){
            if (left.get(key)==null){
                System.out.println("rightkey = " + key + " value = " + right.get(key));
            }
        }

    }
}
