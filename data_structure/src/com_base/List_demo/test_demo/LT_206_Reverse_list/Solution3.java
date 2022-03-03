package com_base.List_demo.test_demo.LT_206_Reverse_list;
/*
    题意：反转一个单链表。
    示例: 输入: 1->2->3->4->5->NULL 输出: 5->4->3->2->1->NULL
*/
// 递归
class Solution3 {
    public ListNode reverseList(ListNode head) {
        return reverse(null, head);
    }

    private ListNode reverse(ListNode pre, ListNode cur){
        if (cur == null) return pre;

        ListNode tmp = cur.next;
        cur.next = pre;

        // 更新prev、cur位置
        // prev = cur;
        // cur = temp;
        return reverse(cur, tmp);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        revert(head);


        Solution3 sl = new Solution3();
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
