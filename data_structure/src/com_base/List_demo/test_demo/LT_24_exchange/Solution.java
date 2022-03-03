package com_base.List_demo.test_demo.LT_24_exchange;
/*
    给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
    你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
*/
// 四个指针
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        // 虚节点
        ListNode ppre = new ListNode();
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode tmp = null;
        head = head.next;
        while(cur != null){
            // 交换
            tmp = cur.next;
            cur.next = pre;
            pre.next = tmp;
            ppre.next = cur;

            // 向前走两步
            if (tmp == null) break;
            ppre = pre;
            pre = tmp;
            cur = tmp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        revert(head);


        Solution sl = new Solution();
        head = sl.swapPairs(head);
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
