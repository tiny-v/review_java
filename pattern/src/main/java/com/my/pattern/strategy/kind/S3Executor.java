package com.my.pattern.strategy.kind;

/**
 * @author mayue
 * @date 2020/6/24.
 */
public class S3Executor implements DataSourceExecutor {

    @Override
    public void execute() {
        System.out.println("this is s3 executor");
    }
}
