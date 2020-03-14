package com.jackie.wowjava.best.practice.java;

/**
 *
 */

import java.util.*;

/**
 * @author lei
 *
 */
public class IteratorNodeToolCopy {
    Map<String,List> pathMap=new HashMap();//记录所有从根节点到叶子结点的路径
    private void print(List lst)//打印出路径
    {
        Iterator it=lst.iterator();
        while(it.hasNext())
        {
            Node n=(Node)it.next();
            System.out.print(n.getText()+"-");
        }
        System.out.println();
    }
    public void iteratorNode(Node n,Stack<Node> pathstack)
    {
        pathstack.push(n);//入栈
        List childlist=n.getChildList();
        if(childlist==null)//没有孩子 说明是叶子结点
        {
            List lst=new ArrayList();
            Iterator stackIt=pathstack.iterator();
            while(stackIt.hasNext())
            {
                lst.add(stackIt.next());

            }
            print(lst);//打印路径
            pathMap.put(n.getText(), lst);//保存路径信息
            return;
        }else
        {
            Iterator it=childlist.iterator();
            while(it.hasNext())
            {
                Node child=(Node)it.next();
                iteratorNode(child,pathstack);//深度优先 进入递归
                pathstack.pop();//回溯时候出栈
            }

        }

    }
    public static void main(String[] args) {
        Stack <Node>pathstack=new Stack();
        Node n=Node.getInitNode();
        IteratorNodeToolCopy tool=new IteratorNodeToolCopy();
        tool.iteratorNode(n, pathstack);
    }

}
