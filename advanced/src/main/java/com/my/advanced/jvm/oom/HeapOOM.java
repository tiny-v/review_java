package com.my.advanced.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 *VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 *
 * @author YMa69
 * @date 2019/12/3
 */
public class HeapOOM {

    static class OOMObject{}

    public static void main(String[] args){
        List<OOMObject> list = new ArrayList();
        while(true){
            list.add(new OOMObject());
        }
    }

}
