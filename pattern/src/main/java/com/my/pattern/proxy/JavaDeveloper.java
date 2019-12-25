package com.my.pattern.proxy;

/**
 * @author YMa69
 * @date 2019/12/25.
 */
public class JavaDeveloper implements Developer {

    private final String name;

    public JavaDeveloper(String name){
        this.name = name;
    }
    /**
     * 开发人员在debug
     */
    @Override
    public void debug() {
        System.out.println(" Java开发人员"+name+", 正在debug");
    }

    /**
     * 开发人员在编码
     */
    @Override
    public void code() {
        System.out.println(" Java开发人员"+name+", 正在coding");
    }

    /**
     * 开发人员在写文档
     */
    @Override
    public void document() {
        System.out.println(" Java开发人员"+name+", 正在写文档");
    }
}
