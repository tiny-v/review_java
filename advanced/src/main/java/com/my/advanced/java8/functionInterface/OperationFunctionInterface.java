package com.my.advanced.java8.functionInterface;

import java.util.function.DoubleBinaryOperator;

/**
 * 本例展示如何在枚举中巧妙的使用函数式编程
 * @author mayue
 * @date 2021/2/3.
 */
public enum OperationFunctionInterface {

    PLUS("+", (x,y) -> x+y),
    MINUS("-", (x,y) -> x-y),
    TIMES("*", (x,y) -> x*y),
    DIVIDE("/", (x,y) -> x/y),
    ;

    /**操作符号标志*/
    private final String symbol;
    /**声明一个返回Double类型，参数为2个double类型的操作*/
    private final DoubleBinaryOperator op;

    /**
     * 构造函数
     * @param symbol
     * @param op
     */
    OperationFunctionInterface(String symbol, DoubleBinaryOperator op){
        this.symbol = symbol;
        this.op = op;
    }

    /**
     * 声明一个apply方法， 方法内部是该op操作的apply方法， 所以需要每个枚举实例内部实现 apply方法细节
     * @param x
     * @param y
     * @return
     */
    public double apply(double x, double y){
        return op.applyAsDouble(x, y);
    }

    public static void main(String[] args){
        double minusTest = OperationFunctionInterface.MINUS.apply(5, 4);
        System.out.println(minusTest);
    }
}