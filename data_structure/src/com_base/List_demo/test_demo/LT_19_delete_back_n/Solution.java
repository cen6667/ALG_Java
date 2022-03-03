package com_base.List_demo.test_demo.LT_19_delete_back_n;
/*
    给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
*/
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(-1, head);

        ListNode fast = head;
        ListNode slow = dummyHead;
        while(n != 0){
            fast = fast.next;
            n--;
        }
        // slow到删除的节点前面
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummyHead.next;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        revert(head);

        int n = 2;
        System.out.println(n);
        Solution sl = new Solution();
        head = sl.removeNthFromEnd(head, n);
        revert(head);

    }

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
