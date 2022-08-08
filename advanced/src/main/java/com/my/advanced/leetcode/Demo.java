package com.my.advanced.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class Demo {



    public String longestPalindrome(String s) {
        int sLen = s.length();
        boolean[][] flag = new boolean[sLen][sLen];
        if(sLen<2){
            return s;
        }
        for(int gap = 0; gap<sLen; gap++){
            int skip = sLen - gap;
            for(int i=0; i<=gap; i++){
                String temp = s.substring(i, i+skip);
                if(temp.length() == 1){
                    continue;
                }
                String result = validate(temp);
                if(!("").equals(result)){
                    return result;
                }
            }
        }
        return s.substring(0, 1);
    }

    public String validate(String s){
        String temp = s;
        while(temp.length()>1){
            String start = temp.substring(0, 1);
            if(!temp.endsWith(start)){
                return "";
            }
            temp = temp.substring(1, temp.length()-1);
            if(temp.length()<=1){
                return s;
            }
        }
        return "";
    }

    public static void ping() throws IOException, InterruptedException {
        while(true){
            System.out.println("===========Start==========");
            System.out.println(new Date());
            Process p = Runtime.getRuntime().exec("ping 192.168.0.1");
            //获取输出流，并包装到BufferedReader中
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(), "gbk"));
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            p.waitFor();
            System.out.println("==========End===========");
            System.out.println("");
            System.out.println("");
            Thread.sleep(10*1000);
        }

    }

    public static void main(String[] args) throws InterruptedException, IOException {
        ping();
    }

}
