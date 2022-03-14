package stru_demo.queue_demo.stack_queue;

public class MyQueueDemo {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
//        MyQueue_Deque myQueue = new MyQueue_Deque();
        myQueue.push(1); // queue is: [1]
        System.out.println("push 1");
        myQueue.push(2);

        System.out.println("push 2");// queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myQueue.peek()); // return 1
        System.out.println(myQueue.pop()); // return 1, queue is [2]
        System.out.println(myQueue.empty()); // return false

    }

}
