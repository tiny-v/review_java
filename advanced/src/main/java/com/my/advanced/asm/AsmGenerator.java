package com.my.advanced.asm;


import com.sun.xml.internal.ws.org.objectweb.asm.ClassAdapter;
import com.sun.xml.internal.ws.org.objectweb.asm.ClassReader;
import com.sun.xml.internal.ws.org.objectweb.asm.ClassWriter;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @author tiny_v
 * @date 2022/8/3.
 */

public class AsmGenerator {

    public static void main(String[] args) throws Exception {
        //读取
        ClassReader classReader = new ClassReader(AsmBase.class.getName());
        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        //处理
        ClassAdapter classAdapter = new AsmClassAdapter(classWriter);
        classReader.accept(classAdapter, ClassReader.SKIP_DEBUG);
        byte[] data = classWriter.toByteArray();
        //输出
        File f = new File("D:/studyspace/***/bytecode/Base.class");
        FileOutputStream fout = new FileOutputStream(f);
        fout.write(data);
        fout.close();
        System.out.println("now generator cc success!!!!!");
    }



}

