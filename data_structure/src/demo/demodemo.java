package demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class demodemo {
    public static void main(String[] args) {
//        int[] nums1 = {10,20,50,15,30,10};
////        int[] nums2 = {40,20,10,100,10,10};
////        System.out.println(maximumsSplicedArray(nums1,nums2));
        int[][] nums = {{1, 3},{2, 6},{8, 10},{15, 18}};
        System.out.println(merge(nums));
    }

    public static int[][] merge(int[][] intervals) {
        if(intervals.length == 1) return intervals;

        Arrays.sort(intervals, (a,b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        List<int[]> res = new ArrayList<>();
        int[] tmp = {intervals[0][0], intervals[0][1]};
        for(int i=1; i<intervals.length; i++){
            int[] nums = intervals[i];
            int left = tmp[0];
            int right = tmp[1];
            if(nums[0] > right){
                res.add(new int[]{left,right});
                tmp = nums;
            }else{
                tmp[1] = nums[1];
            }
        }
        res.add(tmp);
        return res.toArray(new int[res.size()][]);
    }

    public static int maximumsSplicedArray(int[] nums1, int[] nums2) {
        int sum1 = 0;
        int sum2 = 0;
        for(int i : nums1){
            sum1 += i;
        }
        for(int i : nums2){
            sum2 += i;
        }
        int n = nums1.length;
        int res = Math.max(sum1,sum2);
        int tempSum1 = 0;
        int tempSum2 = 0;
        for(int i = 0;i<n;i++){
            tempSum1 += nums2[i] - nums1[i];
            if(tempSum1<0){
                tempSum1 = 0;
            }else {
                res = Math.max(res, sum1+tempSum1);
            }

            tempSum2 += nums1[i] - nums2[i];
            if(tempSum2<0){
                tempSum2 = 0;
            }else {
                res = Math.max(res, sum2+tempSum2);
            }
        }
        return res;
    }

}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right) return head;
        // 虚拟头节点
        ListNode virhead = new ListNode(-1, head);
        for(int i=0; i<left-1;i++){
            virhead = virhead.next;
        }
        ListNode pre = virhead;
        ListNode cur = virhead.next;
        ListNode tmp = null;
        for(int i=left;i<=right;i++){
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        virhead.next.next = cur;
        virhead.next = pre;

        return head;
    }
}
