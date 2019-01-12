package com.jackie.wowjava.best.practice.java.concurrent;

/**
 * @Author: Jackie
 * @date 2019/1/10
 * synchronized同步语句块
 */
public class SynchronizedDemo {
    public void method() {
        synchronized (this) {
            System.out.println("synchronized 代码块");
        }
    }
}

/**
javap -c -s -v -l SynchronizedDemo.class
Classfile /Users/jackie/workspace/rome/wowjava/best-practice-java/src/main/java/com/jackie/wowjava/best/practice/java/concurrent/SynchronizedDemo.class
  Last modified Jan 10, 2019; size 586 bytes
  MD5 checksum b1e9dae17a5af05c76c4a10acf07d0f1
  Compiled from "SynchronizedDemo.java"
public class com.jackie.wowjava.best.practice.java.concurrent.SynchronizedDemo
  minor version: 0
  major version: 52
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
   #1 = Methodref          #6.#18         // java/lang/Object."<init>":()V
   #2 = Fieldref           #19.#20        // java/lang/System.out:Ljava/io/PrintStream;
   #3 = String             #21            // synchronized 代码块
   #4 = Methodref          #22.#23        // java/io/PrintStream.println:(Ljava/lang/String;)V
   #5 = Class              #24            // com/jackie/wowjava/best/practice/java/concurrent/SynchronizedDemo
   #6 = Class              #25            // java/lang/Object
   #7 = Utf8               <init>
   #8 = Utf8               ()V
   #9 = Utf8               Code
  #10 = Utf8               LineNumberTable
  #11 = Utf8               method
  #12 = Utf8               StackMapTable
  #13 = Class              #24            // com/jackie/wowjava/best/practice/java/concurrent/SynchronizedDemo
  #14 = Class              #25            // java/lang/Object
  #15 = Class              #26            // java/lang/Throwable
  #16 = Utf8               SourceFile
  #17 = Utf8               SynchronizedDemo.java
  #18 = NameAndType        #7:#8          // "<init>":()V
  #19 = Class              #27            // java/lang/System
  #20 = NameAndType        #28:#29        // out:Ljava/io/PrintStream;
  #21 = Utf8               synchronized 代码块
  #22 = Class              #30            // java/io/PrintStream
  #23 = NameAndType        #31:#32        // println:(Ljava/lang/String;)V
  #24 = Utf8               com/jackie/wowjava/best/practice/java/concurrent/SynchronizedDemo
  #25 = Utf8               java/lang/Object
  #26 = Utf8               java/lang/Throwable
  #27 = Utf8               java/lang/System
  #28 = Utf8               out
  #29 = Utf8               Ljava/io/PrintStream;
  #30 = Utf8               java/io/PrintStream
  #31 = Utf8               println
  #32 = Utf8               (Ljava/lang/String;)V
{
  public com.jackie.wowjava.best.practice.java.concurrent.SynchronizedDemo();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: return
      LineNumberTable:
        line 7: 0

  public void method();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=2, locals=3, args_size=1
         0: aload_0
         1: dup
         2: astore_1
         3: monitorenter
         4: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
         7: ldc           #3                  // String synchronized 代码块
         9: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
        12: aload_1
        13: monitorexit
        14: goto          22
        17: astore_2
        18: aload_1
        19: monitorexit
        20: aload_2
        21: athrow
        22: return
      Exception table:
         from    to  target type
             4    14    17   any
            17    20    17   any
      LineNumberTable:
        line 9: 0
        line 10: 4
        line 11: 12
        line 12: 22
      StackMapTable: number_of_entries = 2
        frame_type = 255
          offset_delta = 17
                  locals = [ class com/jackie/wowjava/best/practice/java/concurrent/SynchronizedDemo, class java/lang/Object ]
        stack = [ class java/lang/Throwable ]
        frame_type = 250
        offset_delta = 4
        }
        SourceFile: "SynchronizedDemo.java"
 */

/**
 Synchronized同步语句块的实现使用的是monitorenter和moniterexit，分别表示同步代码块的开始位置和结束位置
 当执行monitorenter语句是，线程试图获取锁，也就是获取对象的monitor，monitor存在于对象的对象头中，所以java中任意对象都可以作为锁
 当计数器为0则可以获取成功，获取后将锁计数器设为1，退出时，设为0
 如果获取失败，则会阻塞等待，直到另一个线程释放锁
 *
 */
