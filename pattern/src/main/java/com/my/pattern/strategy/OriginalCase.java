package com.my.pattern.strategy;

import com.my.pattern.strategy.kind.DataSourceExecutor;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author mayue
 * @date 2020/6/24.
 */
public class OriginalCase {

    private void uglyCode(String dataSourceKind){
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

    private void beautifuleCode(String dataSourceKind){
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

    public static void main(String[] args){
        OriginalCase originalCase = new OriginalCase();
        originalCase.beautifuleCode("MYSQL");
    }

}
