package stru_demo.stack_demo;

/*
 * 用数组来实现栈，规定新添加的元素总是在原有数组的后面
 * 栈低为下标为0的值
 */

public class MyStack<E> {

    private Object[] obj = new Object[10];

    private int size;

    //规定栈顶和栈底的划分     入栈
    public void push(E data) {
        if (size == obj.length) {
            throw new RuntimeException("栈满......");
        }
        obj[size++] = data;
    }

    //每一次从栈顶出   出栈
    public E pop() {
        if (size == 0) {
            throw new RuntimeException("栈空.....");
        }
        return (E) obj[--size];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
