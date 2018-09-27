package com.jackie.wowjava.jvm.oom;

/**
 * 虚拟机栈和本地方法栈溢出
 * VM Args: -Xss256k
 *
 * 执行结果：
 * stack length:2123
 * Exception in thread "main" java.lang.StackOverflowError
 * 	at com.jackie.wowjava.jvm.oom.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:9)
 * 	at com.jackie.wowjava.jvm.oom.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:9)
 * 	at com.jackie.wowjava.jvm.oom.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:9)
 */
public class JavaVMStackSOF {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        JavaVMStackSOF javaVMStackSOF = new JavaVMStackSOF();
        try {
            javaVMStackSOF.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + javaVMStackSOF.stackLength);
            throw e;
        }
    }
}
