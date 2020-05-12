package com.my.advanced.jvm.oom;

/**
 * Warning:
 * 由于在windows平台的虚拟机中， Java的线程是映射到操作系统的内核线程上的，
 * 因此这段代码执行由较大风险， 可能会导致操作系统假死。建议运行前先保存当前的工作
 * VM Args: -Xss2M
 * @author YMa69
 * @date 2019/12/3
 */
public class JavaVMStackOOM {

    private void dontStop(){
        while(true){
        }
    }

    public void stackLeakByThread(){
        while(true){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args){
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }

}
