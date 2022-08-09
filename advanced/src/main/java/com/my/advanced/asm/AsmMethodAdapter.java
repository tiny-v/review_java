package com.my.advanced.asm;

import com.sun.xml.internal.ws.org.objectweb.asm.MethodAdapter;
import com.sun.xml.internal.ws.org.objectweb.asm.MethodVisitor;
import com.sun.xml.internal.ws.org.objectweb.asm.Opcodes;

/**
 * @author tiny_v
 * @date 2022/8/3.
 */

class AsmMethodAdapter extends MethodAdapter {


    public AsmMethodAdapter(MethodVisitor mv) {
        super(mv);
    }

    /**
     * 它会在ASM开始访问某一个方法的Code区时被调用，重写visitCode方法，将AOP中的前置逻辑就放在这里
     */
    @Override
    public void visitCode() {
        //织入自定义的log静态方法
        mv.visitCode();
        visitMethodInsn(Opcodes.INVOKESTATIC, "com/lx/soil/bytecode/LogUtil", "before", "()V");
    }

    /**
     * 每当ASM访问到无参数指令时，都会调用visitInsn方法。我们判断了当前指令是否为无参数的“return”指令
     * 如果是就在它的前面添加一些指令，也就是将AOP的后置逻辑放在该方法中。
     * 方法在返回之前，记录log
     *
     * @param opcode
     */
    @Override
    public void visitInsn(int opcode) {
        if ((opcode >= Opcodes.IRETURN && opcode <= Opcodes.RETURN) || opcode == Opcodes.ATHROW) {
            visitMethodInsn(Opcodes.INVOKESTATIC, "com/lx/soil/bytecode/LogUtil", "after", "()V");
        }
        mv.visitInsn(opcode);
    }
}
