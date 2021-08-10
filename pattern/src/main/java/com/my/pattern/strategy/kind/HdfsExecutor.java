package com.my.pattern.strategy.kind;

/**
 * @author mayue
 * @date 2020/6/24.
 */
public class HdfsExecutor implements DataSourceExecutor {

    @Override
    public void execute() {
        System.out.println("this is hdfs executor");
    }
}
