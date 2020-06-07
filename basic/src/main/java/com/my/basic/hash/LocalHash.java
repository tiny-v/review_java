package com.my.basic.hash;

import java.util.HashMap;

public class LocalHash {

    public static void main(String[] args){
        String str1 = "aa";
        String str2 = new String("aa");
        System.out.println("str1 hashcode:"+ str1.hashCode());
        System.out.println("str2 hashcode:"+ str2.hashCode());
        System.out.println("str1==str2:"+ str1==str2);
        HashMap<String, String> map = new HashMap();
        map.put(str1, "abc");
        map.put(str2, "bcd");
        System.out.println(map.get(str1));
        System.out.println(map.get(str2));

        Double a = 1.1;
    }



}
