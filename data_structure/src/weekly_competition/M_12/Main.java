package weekly_competition.M_12;

import java.util.*;

/*
小米：数组转链表
5
1
2
3
4
5
2
3

*/

class ListNode<T> {
    public T data;
    public ListNode next;
}

class Solution {

    /* Write Code Here */
    public ListNode<Integer> reverseBetween(ListNode<Integer> head, int left, int right) {
        ListNode<Integer> dum = new ListNode();
        dum.data = -1;
        dum.next = head;
        for (int i = 0; i < left - 1; i++) {
            dum = dum.next;
        }
        ListNode<Integer> pre = dum;
        ListNode<Integer> cur = dum.next;
        ListNode<Integer> tmp;
        for (int i = left; i <= right; i++) {
            tmp= cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        dum.next.next = cur;
        dum.next = pre;

        if(left==1) return dum.next;
        return head;
    }
}

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        ListNode<Integer> res = null;

        int head_size = 0;
        head_size = in.nextInt();
        ListNode<Integer> head = null, head_curr = null;
        for(int head_i = 0; head_i < head_size; head_i++) {
            int head_item = in.nextInt();
            ListNode<Integer> head_temp = new ListNode<Integer>();
            head_temp.data = head_item;
            head_temp.next = null;

            if (head == null) {
                head = head_curr = head_temp;
            } else {
                head_curr.next = head_temp;
                head_curr = head_temp;
            }
        }

        if(in.hasNextLine()) {
            in.nextLine();
        }

        int left;
        left = Integer.parseInt(in.nextLine().trim());

        int right;
        right = Integer.parseInt(in.nextLine().trim());

        Solution sl = new Solution();
        res = sl.reverseBetween(head, left, right);
        while (res != null) {
            System.out.print(String.valueOf(res.data) + " ");
            res = res.next;
        }
        System.out.println();

    }
}

