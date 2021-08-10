package com.my.pattern.strategy;

import com.my.pattern.strategy.kind.DataSourceExecutor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


/**
 * @author mayue
 * @date 2020/6/24.
 */
public class OriginalCase {

    /**
     * 使用if-else来查找指定策略
     * @param dataSourceKind
     */
    private void ifElse(String dataSourceKind){
        if(dataSourceKind.equals(DataSourceKind.MYSQL.name())){
            //
        }else if(dataSourceKind.equals(DataSourceKind.REDIS.name())){
            //
        }else if(dataSourceKind.equals(DataSourceKind.HDFS.name())){
            //
        }else if(dataSourceKind.equals(DataSourceKind.S3.name())){
            //
        }
    }

    /**
     * 使用类加载的方式来查找指定策略
     * @param dataSourceKind
     */
    private void clazzFor(String dataSourceKind){
        Arrays.asList(DataSourceKind.values()).forEach(System.out::println);
        HashMap<String, String> hashmap = DataSourceKind.getClazzMap();
        if(hashmap.keySet().contains(dataSourceKind)){
            try{
                Class clazz = Class.forName(hashmap.get(dataSourceKind));
                StrategyExecutor strategyExecutor = new StrategyExecutor((DataSourceExecutor) clazz.newInstance());
                strategyExecutor.execute();
            }catch (InstantiationException e) {
                e.printStackTrace();
            }catch (IllegalAccessException e) {
                e.printStackTrace();
            }catch (ClassNotFoundException e){
                e.printStackTrace();
            }
        }
    }

    ///todo: 使用注解的方式，应该更优雅一些吧

    public static void main(String[] args){
        Set<String> set1 = new HashSet();
        set1.add("bb");
        set1.add("aa");
        set1.add("cc");

        Set<String> set2 = new HashSet();
        set2.add("ae");
        set2.add("bb");
        set2.add("ea");

        set1.addAll(set2);
        for(String s: set1){
            System.out.println(s);
        }

        //OriginalCase originalCase = new OriginalCase();
        //originalCase.clazzFor("MYSQL");
        //Charset cs = Charset.forName("utf-8");
        //String body = new String(new byte[0], cs);
        //System.out.println(body);
    }

}
