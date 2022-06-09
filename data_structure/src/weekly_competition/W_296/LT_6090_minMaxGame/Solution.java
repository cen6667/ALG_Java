package weekly_competition.W_296.LT_6090_minMaxGame;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int minMaxGame(int[] nums) {
        if(nums.length == 1) return nums[0];
        Deque<Integer> deque = new LinkedList<>();
        for (int i : nums) {
            deque.addLast(i);
        }
        int dif = 2;

        while (dif != nums.length*2) {
            boolean flag = true;
            int len = deque.size();
            for (int i = 0; i < len; i = i + 2) {
                int l1 = deque.pop();
                int l2 = deque.pop();
                if (flag) {
                    deque.addLast(Math.min(l1,l2));
                } else {
                    deque.addLast(Math.max(l1,l2));
                }
                flag = !flag;
            }
            dif = dif * 2;
        }
        return deque.pop();
    }

    public static void main(String[] args) {
//        int[] nums = {1,3,5,2,4,8,2,2};
        int[] nums =  {93,40};
        Solution solution = new Solution();
        System.out.println(solution.minMaxGame(nums));
    }

}
