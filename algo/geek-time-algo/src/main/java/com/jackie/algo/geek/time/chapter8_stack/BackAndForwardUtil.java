package com.jackie.algo.geek.time.chapter8_stack;

import javax.annotation.PostConstruct;

/**
 * @Author: Jackie
 */
public class BackAndForwardUtil {
    public static Stack backStack = new Stack();
    public static Stack forwardStack = new Stack();

    /**
     * 1 2 3 currentIndex 4 5 6
     */
    static {
        backStack.push(1);
        backStack.push(2);
        backStack.push(3);

        forwardStack.push(4);
        forwardStack.push(5);
        forwardStack.push(6);
    }

    public static void goBack() {
        int index = backStack.pop();
        forwardStack.push(index);
    }

    public static void goForward() {
        int index = forwardStack.pop();
        backStack.push(index);
    }
}
