package com_base.List_demo.test_demo.LT_707;

class MyLinkedList_single {
    int size;
    ListNode head;

    public MyLinkedList_single() {
        size = 0;
        head = new ListNode(0);
    }

    // 要按运行顺序写
    public int get(int index) {
        //如果index非法，返回-1
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode cur = head;
        //包含一个虚拟头节点，所以查找第 index+1 个节点
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    // 第一个写
    public void addAtIndex(int index, int val) {
        if(index > size) return;
        if(index < 0) index=0;

        ListNode pre = head;
        // 虽说多一个虚节点，但需要前驱节点进行插入
        for(int i = 0; i < index; i++){
            pre = pre.next;
        }
        ListNode toAdd = new ListNode(val, pre.next);
        pre.next = toAdd;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        size--;
        ListNode pre = head;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        pre.next = pre.next.next;
    }

    public static void main(String[] args) {
        MyLinkedList_single linkedList = new MyLinkedList_single();
        linkedList.addAtHead(1);
        revert(linkedList.head);

        linkedList.addAtTail(3);
        revert(linkedList.head);

        linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
        revert(linkedList.head);

        linkedList.get(1);            //返回2
        revert(linkedList.head);

        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        revert(linkedList.head);

        linkedList.get(1);            //返回3
        revert(linkedList.head);
    }

//    private static void revert(ListNode node) {
//
//        if (node != null) {
//            revert(node.next);
//            System.out.print(node.val + ",");
//        }
//    }

    private static void revert(ListNode node) {

        while(node != null) {
            System.out.print(node.val + ",");
            node = node.next;
        }
        System.out.println();
    }

    private static class ListNode {
        int val;
        ListNode next;
        public ListNode() {}
        public ListNode(int val) {this.val = val;}
        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}

