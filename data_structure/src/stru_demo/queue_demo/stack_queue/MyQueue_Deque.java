package stru_demo.queue_demo.stack_queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class MyQueue_Deque {
    Deque<Integer> stackIn;
    Deque<Integer> stackOut;

    /** Initialize your data structure here. */
    public MyQueue_Deque() {
        stackIn = new LinkedList<>(); // 负责进栈
        stackOut = new LinkedList<>(); // 负责出栈
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stackIn.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        dumpstackIn();
        return stackOut.pop();
    }

    /** Get the front element. */
    public int peek() {
        dumpstackIn();
        return stackOut.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }


    // 如果stackOut为空，那么将stackIn中的元素全部放到stackOut中
    private void dumpstackIn(){
        if (!stackOut.isEmpty()) return;
        while (!stackIn.isEmpty()){
            stackOut.push(stackIn.pop());
        }
    }

}

