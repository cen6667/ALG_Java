package weekly_competition.W_291.LT_6049_countDistinct;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
//枚举所有子数组，判断是否符合要求，再用一个 set 去重即可。复杂度O(n^3)

public class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        int n = nums.length;
        Set<String> st = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String t = "";
            int cnt = 0;
            for (int j = i; j < n; j++) {
                if (nums[j] % p == 0) cnt++;
                if (cnt > k) break;
                t = t + nums[j] + "|";
                st.add(t);
            }
        }
        return st.size();
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 3, 2, 2};
        int k = 2;
        int p = 2;
        Solution sl = new Solution();
        System.out.println(sl.countDistinct(nums, k, p));
    }
}
