package com_base.List_demo.demo;

public class ArrayList {

    public static void main(String[] args) {
        //定义数组
        int[] arr = {12, 45, 98, 73, 60};

        //数组变链表
        ListNode head = Arr_List.arrayToListNode(arr);
        System.out.println("数组变链表");
        Arr_List.printListNode(head);
        //链表变数组
        int[] arr_2= List_Arr.listNodeToArray(head);
        System.out.println("\n链表变数组");
        List_Arr.printArrays(arr_2);

    }
}

