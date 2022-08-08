package com.my.basic.enums;

import java.io.Serializable;

/**
 * @author YMa69
 * @date 2019/12/31.
 */
public class SingleObject implements Serializable {

    private SingleObject(){}

    public static SingleObject getInstance(){
        return EnumSingleObject.INSTANCE.singleObject;
    }

    enum EnumSingleObject{

        INSTANCE;

        private SingleObject singleObject;

        public void EnumSingleObject(){
            singleObject = new SingleObject();
        }
    }

    public static void main(String[] args){
        SingleObject.getInstance();
    }

}
