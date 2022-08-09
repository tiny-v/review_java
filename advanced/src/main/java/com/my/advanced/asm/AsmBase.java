package com.my.advanced.asm;

/**
 * @author tiny_v
 * @date 2022/8/3.
 */
public class AsmBase {

    public void run() {
        System.out.println(" run ");
    }

    public static void main(String[] args) {
        AsmBase asmBase = new AsmBase();
        asmBase.run();
    }
}

