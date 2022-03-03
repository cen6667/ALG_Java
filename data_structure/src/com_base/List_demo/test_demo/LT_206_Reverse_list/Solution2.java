package com_base.List_demo.test_demo.LT_206_Reverse_list;
/*
    题意：反转一个单链表。
    示例: 输入: 1->2->3->4->5->NULL 输出: 5->4->3->2->1->NULL
*/
// 从后往前递归
class Solution2 {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next ==null) return head;

        // 递归调用，翻转第二个节点开始往后的链表
        // 最重要是这里last输出最后一个节点，中间没有对他进行任何操作，所以可以保留到最后
        ListNode last = reverseList(head.next);
        // 翻转头节点与第二个节点的指向
        head.next.next = head;
        // 此时的 head 节点为尾节点，next 需要指向 NULL
        head.next = null;
        return last;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        revert(head);


        Solution2 sl = new Solution2();
        head = sl.reverseList(head);
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
