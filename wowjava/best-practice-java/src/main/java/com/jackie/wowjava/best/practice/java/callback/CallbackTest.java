package com.jackie.wowjava.best.practice.java.callback;

public class CallbackTest {

    public static void main(String[] args) {
        Student student = new Jackie();

        Teacher teacher = new Teacher(student);

        teacher.askQuestion();
    }
}
