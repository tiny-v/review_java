package com.my.basic.enums;

/**
 * @author YMa69
 * @date 2019/12/31.
 */
public class SingleObject {

    private SingleObject(){}

    @Override
    public String toString() {
        return "SingleObject{ I'm singleObject }";
    }

    enum EnumSingleObject{

        INSTANCE;

        private SingleObject singleObject = new SingleObject();

        public SingleObject getInstance(){
            return singleObject;
        }
    }

    public static void main(String[] args){
        EnumSingleObject.INSTANCE.getInstance();
    }

}
