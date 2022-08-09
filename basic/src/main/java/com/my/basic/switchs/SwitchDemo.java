package com.my.basic.switchs;

/**
 * @author tiny_v
 * @date 2021/7/28.
 */
public class SwitchDemo {

    public void demo1(String str){
        switch(str){
            case "A":
            case "B":
                System.out.println("Hello World");
                break;
            case "C":
                System.out.println("Be Stronger");
                break;
            default:
                break;
        }
    }

    public int finallyTest(){
        try{
            return 1;
        }finally {
            System.out.println("66666");
            return 2;
        }
    }

    public void finallyTest01(int param){
        try{
            if(param == 1){
                System.out.println("111111");
                return;
            }else{
                System.out.println("222222");
            }
        }finally {
            System.out.println("333333");
        }
    }

    public static void main(String[] args){
        new SwitchDemo().finallyTest01(2);
    }






}
