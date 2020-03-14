package com.jackie.wowjava.best.practice.java.concurrent;

/**
 * @Author: Jackie
 * @date 2019/1/10
 */
public class SynchronizedDemo2 {
    public synchronized void method() {
        System.out.println("synchronied 代码块");
    }
}

/**
 * javap -c -s -v -l SynchronizedDemo2.class
 * Classfile /Users/jackie/workspace/rome/wowjava/best-practice-java/src/main/java/com/jackie/wowjava/best/practice/java/concurrent/SynchronizedDemo2.class
 *   Last modified Jan 10, 2019; size 475 bytes
 *   MD5 checksum f79c4f51cf0f72070444c70f34054f9c
 *   Compiled from "SynchronizedDemo2.java"
 * public class com.jackie.wowjava.best.practice.java.concurrent.SynchronizedDemo2
 *   minor version: 0
 *   major version: 52
 *   flags: ACC_PUBLIC, ACC_SUPER
 * Constant pool:
 *    #1 = Methodref          #6.#14         // java/lang/Object."<init>":()V
 *    #2 = Fieldref           #15.#16        // java/lang/System.out:Ljava/io/PrintStream;
 *    #3 = String             #17            // synchronied 代码块
 *    #4 = Methodref          #18.#19        // java/io/PrintStream.println:(Ljava/lang/String;)V
 *    #5 = Class              #20            // com/jackie/wowjava/best/practice/java/concurrent/SynchronizedDemo2
 *    #6 = Class              #21            // java/lang/Object
 *    #7 = Utf8               <init>
 *    #8 = Utf8               ()V
 *    #9 = Utf8               Code
 *   #10 = Utf8               LineNumberTable
 *   #11 = Utf8               method
 *   #12 = Utf8               SourceFile
 *   #13 = Utf8               SynchronizedDemo2.java
 *   #14 = NameAndType        #7:#8          // "<init>":()V
 *   #15 = Class              #22            // java/lang/System
 *   #16 = NameAndType        #23:#24        // out:Ljava/io/PrintStream;
 *   #17 = Utf8               synchronied 代码块
 *   #18 = Class              #25            // java/io/PrintStream
 *   #19 = NameAndType        #26:#27        // println:(Ljava/lang/String;)V
 *   #20 = Utf8               com/jackie/wowjava/best/practice/java/concurrent/SynchronizedDemo2
 *   #21 = Utf8               java/lang/Object
 *   #22 = Utf8               java/lang/System
 *   #23 = Utf8               out
 *   #24 = Utf8               Ljava/io/PrintStream;
 *   #25 = Utf8               java/io/PrintStream
 *   #26 = Utf8               println
 *   #27 = Utf8               (Ljava/lang/String;)V
 * {
 *   public com.jackie.wowjava.best.practice.java.concurrent.SynchronizedDemo2();
 *     descriptor: ()V
 *     flags: ACC_PUBLIC
 *     Code:
 *       stack=1, locals=1, args_size=1
 *          0: aload_0
 *          1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 *          4: return
 *       LineNumberTable:
 *         line 7: 0
 *
 *   public synchronized void method();
 *     descriptor: ()V
 *     flags: ACC_PUBLIC, ACC_SYNCHRONIZED
 *     Code:
 *       stack=2, locals=1, args_size=1
 *          0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *          3: ldc           #3                  // String synchronied 代码块
 *          5: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 *          8: return
 *       LineNumberTable:
 *         line 9: 0
 *         line 10: 8
 * }
 * SourceFile: "SynchronizedDemo2.java"
 */

/**
 * synchronized修饰方法的没有monitorexit和monitorenter，替代的是ACC_SYNCHRONIZED
 */