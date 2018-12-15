package com.jackie.algo.geek.time.chapter8_stack;

/**
 * @Author: Jackie
 */
public class BackAndForwardDemo {

    public static void main(String[] args) {
        BackAndForwardUtil.goBack();
        Stack backStack = BackAndForwardUtil.backStack;
        backStack.printAll();
        Stack forwardStack = BackAndForwardUtil.forwardStack;
        forwardStack.printAll();

        BackAndForwardUtil.goForward();
        backStack = BackAndForwardUtil.backStack;
        backStack.printAll();
        forwardStack = BackAndForwardUtil.forwardStack;
        forwardStack.printAll();
    }


}
