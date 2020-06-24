package com.my.pattern.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mayue
 * @date 2020/6/24.
 */
public enum DataSourceKind {

    MYSQL("MYSQL", "com.my.pattern.strategy.kind.MysqlExecutor"),

    REDIS("REDIS", "com.my.pattern.strategy.kind.RedisExecutor"),

    HDFS("HDFS", "com.my.pattern.strategy.kind.HdfsExecutor"),

    S3("S3", "com.my.pattern.strategy.kind.S3Executor");

    /* 状态码 */
    private String sourceName;
    private String clazzPath;

    DataSourceKind(String sourceName, String clazzPath){
        this.sourceName = sourceName;
        this.clazzPath = clazzPath;
    }

    public static HashMap getClazzMap(){
        HashMap map = new HashMap();
        for (DataSourceKind kind : DataSourceKind.values()) {
            map.put(kind.sourceName, kind.clazzPath);
        }
        return map;
    }

}
