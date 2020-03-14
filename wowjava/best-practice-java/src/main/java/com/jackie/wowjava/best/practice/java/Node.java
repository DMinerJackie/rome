package com.jackie.wowjava.best.practice.java;

/**
 *
 */

import com.google.common.collect.Lists;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lei
 * 代码来源：https://blog.csdn.net/leixingbang1989/article/details/40587405/
 *
 */
public class Node {
    private String text;
    private List<Node>childList;
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public List<Node> getChildList() {
        return childList;
    }
    public void setChildList(List<Node> childList) {
        this.childList = childList;
    }
    public static Node getInitNode()
    {
        Node rootNode = new Node();
        rootNode.setText("1111\t1111");

        List<String> lines = loadFile("/Users/jackie/downloads/线上渠道信息.csv");

        List<Node> firstLevelLines = new LinkedList<>();
        List<String> firstLevelStrLines = new LinkedList<>();
        for (String line : lines) {
            String[] lineArr = line.split("\t");
            if (lineArr[2].equals("0")) {
                Node node = new Node();
                node.setText(lineArr[0] + "\t" + lineArr[1]);
                firstLevelLines.add(node);
                firstLevelStrLines.add(line);
            }
        }

        rootNode.setChildList(firstLevelLines);

        lines.removeAll(firstLevelStrLines);

        List<Node> secondLevelLines = new LinkedList<>();
        List<String> secondLevelStrLines = new LinkedList<>();
        List<Node> subList = new LinkedList<>();
        for (int i = 0; i < firstLevelLines.size(); i++) {
            String id = firstLevelLines.get(i).getText().split("\t")[0];

            subList = new LinkedList<>();
            for (String line : lines) {
                String[] lineArr = line.split("\t");
                if (lineArr[2].equals(id)) {
                    Node node = new Node();
                    node.setText(lineArr[0] + "\t" + lineArr[1]);
                    subList.add(node);

                    secondLevelLines.add(node);
                    secondLevelStrLines.add(line);
                }

                firstLevelLines.get(i).setChildList(subList);
            }
        }

        lines.removeAll(secondLevelStrLines);


        List<Node> thirdLevelLines = new LinkedList<>();
        List<String> thirdLevelStrLines = new LinkedList<>();

        for (int i = 0; i < secondLevelLines.size(); i++) {
            String id = secondLevelLines.get(i).getText().split("\t")[0];

            subList = new LinkedList<>();
            for (String line : lines) {
                String[] lineArr = line.split("\t");
                if (lineArr[2].equals(id)) {
                    Node node = new Node();
                    node.setText(lineArr[0] + "\t" + lineArr[1]);
                    subList.add(node);
                    thirdLevelStrLines.add(line);
                    thirdLevelLines.add(node);
                }

                secondLevelLines.get(i).setChildList(subList);
            }
        }

        lines.removeAll(thirdLevelStrLines);

        List<Node> fourthLevelLines = new LinkedList<>();
        for (int i = 0; i < thirdLevelLines.size(); i++) {
            String id = thirdLevelLines.get(i).getText().split("\t")[0];

            subList = new LinkedList<>();
            for (String line : lines) {
                String[] lineArr = line.split("\t");
                if (lineArr[2].equals(id)) {
                    Node node = new Node();
                    node.setText(lineArr[0] + "\t" + lineArr[1]);
                    subList.add(node);

                    fourthLevelLines.add(node);
                }

                thirdLevelLines.get(i).setChildList(subList);
            }
        }



//        Node nodeA=new Node();
//        nodeA.setText("Auygihlhklhklhk");
//        Node nodeB=new Node();
//        nodeB.setText("Bjklfjlsjsfljsdl");
//        Node nodeC=new Node();
//        nodeC.setText("Casnnflnsdlfa");
//        Node nodeD=new Node();
//        nodeD.setText("Dansdnvlkasndv");
//        Node nodeE=new Node();
//        nodeE.setText("Eanslkdojsdf");
//
//        List<Node>lstB=new ArrayList();
//        lstB.add(nodeC);
//        lstB.add(nodeD);
//        nodeB.setChildList(lstB);
//
//        List<Node>lstA=new ArrayList();
//        lstA.add(nodeB);
//        lstA.add(nodeE);
//        nodeA.setChildList(lstA);
        return rootNode;

    }


    public static List<String> loadFile(String fileLocation) {
        File csvFile = new File(fileLocation);
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(csvFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        List<String> mobiles = Lists.newArrayList();
        String line = "";
        try {
            while ((line = bufferedReader.readLine()) != null) {
//                System.out.println("第" + i + "行数据：" + line);
                mobiles.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return mobiles;
    }
}
