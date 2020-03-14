package com.jackie.wowjava.best.practice.java.callback;

public class Teacher implements Callback {
    private Student student;

    public Teacher(Student student) {
        this.student = student;
    }

    public void askQuestion() {
        student.resolveQuesion(this);
    }

    @Override
    public void tellAnswer(int answer) {
        System.out.println("知道了，你的答案是" + answer);
    }
}
