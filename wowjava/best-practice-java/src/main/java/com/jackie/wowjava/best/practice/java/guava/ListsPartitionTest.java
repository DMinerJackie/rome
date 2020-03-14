package com.jackie.wowjava.best.practice.java.guava;

import com.google.common.collect.Lists;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @Author: Jackie
 * https://blog.csdn.net/huangwenyi1010/article/details/78409489
 * 其实partition底层用的还是用的subList实现
 */
public class ListsPartitionTest {

    public static void main(String[] args) {
        List<Integer> numList = Lists.newArrayList(1,2,3,4,5,6,7,8,9,10);

        //step.1 集合切割正常逻辑
        System.out.println("===case1===");
        List<List<Integer>> parList = Lists.partition(numList, 3);
        if (!CollectionUtils.isEmpty(parList)) {
            for (List<Integer> list : parList) {
                System.out.println(list.toString());
            }
        }

        //step.2 切割数量大于集合数量
        System.out.println("===case2===");
        List<Integer> numList2 = Lists.newArrayList(1);
        List<List<Integer>> partList2 = Lists.partition(numList2, 3);
        if (!CollectionUtils.isEmpty(partList2)) {
            for (List<Integer> list : partList2) {
                System.out.println(list.toString());
            }
        }


        //step.3 修改切割后的集合，检查原集合是否被修改
        System.out.println("===case3===");
        List<Integer> numList3 = Lists.newArrayList(1,2,3,4,5,6,7,89,9);

        List<List<Integer>> partList3 = Lists.partition(numList3, 3);
        if (!CollectionUtils.isEmpty(partList3)) {
            for (List<Integer> list : partList3) {
                for(int i=0,len = list.size();i<len;i++){
                    list.set(i,8);
                }
            }
            //打印原集合
            System.out.println(numList3.toString());

        }
        //注意：partition返回的是原list的subview.视图,即原list改变后,partition之后的结果也会随着改变

        //step.4 List.partition（）在真实项目中的运用
        System.out.println("===case4===");
        List<Integer> numList4 = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        List<List<Integer>> partList4 = Lists.partition(numList4, 100);
        if (!CollectionUtils.isEmpty(partList4)) {
            for (List<Integer> list : partList4) {
                //将切割的集合按照固定数量查询数据库
                //xxxx.findById(list)
                //select * from user u where u.id in (1,2,3 ....) 这里的id数量不要超过100个
            }

        }
    }
}
