package demo;

import java.util.*;

public class demodemo {
    public static void main(String[] args) {
//        int[] nums1 = {10,20,50,15,30,10};
////        int[] nums2 = {40,20,10,100,10,10};
////        System.out.println(maximumsSplicedArray(nums1,nums2));
//        int[][] nums = {{1, 3},{2, 6},{8, 10},{15, 18}};
//        System.out.println(merge(nums));
//        Deque<Character> deque = new LinkedList();
//        deque.removeAll(deque);
////        String s ="1123";
//        String key = "the quick brown fox jumps over the lazy dog", message = "vkbs bs t suepuv";
//        System.out.println(decodeMessage(key, message));
        int n = 6, delay = 2, forget = 4;
        System.out.println(peopleAwareOfSecret(n, delay, forget));

    }



    public static int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] res = new int[m][n];
        for(int[] nums: res){
            Arrays.fill(nums, -1);
        }
        int top = 0, bottom = m-1;
        int left = 0, right = n-1;

        while(head != null){
            for(int i = left; i<=right;i++){
                if(head == null) break;
                res[top][i] = head.val;
                head = head.next;
            }
            top++;
            for(int i = top; i<=bottom;i++){
                if(head == null) break;
                res[i][right] = head.val;
                head = head.next;
            }
            right--;
            for(int i = right; i>=left;i--){
                if(head == null) break;
                res[bottom][i] = head.val;
                head = head.next;
            }
            bottom--;
            for(int i = bottom; i>=top;i--){
                if(head == null) break;
                res[i][left] = head.val;
                head = head.next;
            }
            left++;
        }
        return res;
    }

    static final int MOD = (int) 1e9 + 7;
    public static int peopleAwareOfSecret(int n, int delay, int forget) {
        if(n == 1) return 1;
        // dp[i]:第i天新增知道密码的人数
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        // 初始化
        for(int i = 2; i<=n; i++){
            for(int j = Math.max(0, i-forget+1); j<= i - delay;j++){
                dp[i] = (dp[i]+dp[j]) % MOD;
            }
        }
        int res= 0;
        for (int i = n;i>n-forget;i--){
            res = (res+dp[i]) %MOD;
        }

        return res;
    }

    public static String decodeMessage(String key, String message) {
        int index = 0;
        int[] book = new int[26];
        Arrays.fill(book, -1);
        for(int i = 0; i<key.length();i++){
            char c = key.charAt(i);
            int tmp = c-'a';
            if(c != ' ' && book[tmp] == -1){
                book[tmp] = index;
                index++;
            }
        }
        String res = "";
        for(int i = 0; i<message.length();i++){
            char c = message.charAt(i);
            if(c == ' '){
                res = res + ' ';
                continue;
            }
            char tmp = (char) (book[c-'a']+'a');
            res = res + tmp;
        }
        return res;
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
