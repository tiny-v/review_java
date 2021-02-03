package com.my.basic.enums;

/**
 * @author mayue
 * @date 2021/2/3.
 */
public enum Operation {

    PLUS("+"){
        public double apply(double x, double y){
            return x+y;
        }
    },
    MINUS("-"){
        public double apply(double x, double y){
            return x-y;
        }
    },
    TIMES("*"){
        public double apply(double x, double y){
            return x*y;
        }
    },
    DIVIDE("/"){
        public double apply(double x, double y){
            return x/y;
        }
    }
    ;

    private final String symbol;

    Operation(String symbol){
        this.symbol = symbol;
    }

    //定义一个抽象方法， 则枚举里的每个值都要实现该方法
    public abstract double apply(double x, double y);

    @Override
    public String toString() {
        return this.symbol;
    }

    public static void main(String[] args){
       double minusTest = Operation.MINUS.apply(5, 4);
       System.out.println(minusTest);
    }
}
