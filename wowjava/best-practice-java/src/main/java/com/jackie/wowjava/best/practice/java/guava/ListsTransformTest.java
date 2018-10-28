package com.jackie.wowjava.best.practice.java.guava;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * @Author: Jackie
 *
 *  Lists的transform方法，现在Java8通过lambda表达式可以简单实现相同效果
 *  tranform使用过程会有明显的坑
 *  https://www.jianshu.com/p/3e3bf25d7878
 */
public class ListsTransformTest {

    public static void main(String[] args) {
        List<Result> listResults = Lists.newArrayList(new Result(1,"test1"),new Result(2,"test2"),new Result(3,"test3"));
        //转换为目标list
        List<String> strLists = Lists.transform(listResults,new Function<Result,String>(){
            @Override
            public String apply(Result result){
                return result.getNameStr();
            }
        });
        //转换后目标list打印
        System.out.println("strLists 1 values:");
        for(String str:strLists){
            System.out.println(str+";");
        }
        //修改源list的值
        for(Result result:listResults){
            result.setNameStr("reset");
        }
        //再次打印目标list
        System.out.println("strLists 2 values:");
        for(String str:strLists){
            System.out.println(str+";");
        }
    }
}
