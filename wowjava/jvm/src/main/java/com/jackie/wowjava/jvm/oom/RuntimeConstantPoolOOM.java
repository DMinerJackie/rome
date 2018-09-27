package com.jackie.wowjava.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * 方法区和运行时常量池溢出
 * VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 *
 * 执行结果：
 * 1.7后可以一直正常运行
 *
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();

        int i = 0;
        while (true) {
            System.out.println(i);
            list.add(String.valueOf(i++).intern());
        }

//        String str1 = new StringBuilder("计算机").append("技术").toString();
//        System.out.println(str1.intern() == str1);
//
//        String str2 = new StringBuilder("ja").append("va").toString();
//        System.out.println(str2.intern() == str2);
    }
}
