package com.my.basic.singleton;

import java.io.Serializable;

public class SingleTon1 implements Serializable {

    private SingleTon1(){}

    public static SingleTon1 getInstance(){
        return SingleTonHandle.INSTANCE.singleTon1;
    }

    enum SingleTonHandle{

        INSTANCE;

        private SingleTon1 singleTon1;

        SingleTonHandle(){
            singleTon1 = new SingleTon1();
        }
    }

}
