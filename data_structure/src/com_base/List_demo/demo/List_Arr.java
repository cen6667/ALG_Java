package com_base.List_demo.demo;

//将链表转换成数组
public class List_Arr {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(2);
        l1.next.next.next = new ListNode(3);
        l1.next.next.next.next = new ListNode(4);

        printArrays(listNodeToArray(l1));
    }

    //输出数组
    public static void printArrays(int[] ints) {
        for (int x : ints) {
            System.out.print(x + " ");
        }
    }

    //将链表转换成数组
    public static int[] listNodeToArray(ListNode l) {
        int size = listNodeSize(l);
        int[] ints = new int[size];
        int index = 0;
        while (l != null) {
            ints[index] = l.val;
            l = l.next;
            index++;
        }
        return ints;
    }

    //求链表的长度
    public static int listNodeSize(ListNode l) {
        int size = 0;
        while (l != null) {
            size++;
            l = l.next;
        }
        return size;
    }

    //遍历一个链表
    public static void printListNode(ListNode l) {
        while (l != null) {
            System.out.print(l.val + " ");
            l = l.next;
        }
    }
}
