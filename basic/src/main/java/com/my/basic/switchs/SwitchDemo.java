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

    public static void main(String[] args){
        new SwitchDemo().demo1("A");
        new SwitchDemo().demo1("B");
        new SwitchDemo().demo1("C");
    }



}
