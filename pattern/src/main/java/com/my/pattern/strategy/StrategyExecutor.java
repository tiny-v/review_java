package com.my.pattern.strategy;

import com.my.pattern.strategy.kind.DataSourceExecutor;

/**
 * @author mayue
 * @date 2020/6/24.
 */
public class StrategyExecutor {

    private DataSourceExecutor dataSourceExecutor;

    public StrategyExecutor(DataSourceExecutor dataSourceExecutor){
        this.dataSourceExecutor = dataSourceExecutor;
    }

    public void execute(){
        dataSourceExecutor.execute();
    }

}
