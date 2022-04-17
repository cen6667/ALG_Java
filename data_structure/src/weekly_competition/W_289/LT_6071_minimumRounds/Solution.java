package weekly_competition.W_289.LT_6071_minimumRounds;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int minimumRounds(int[] tasks) {
        int result = 0;
        Map<Integer, Integer> maps = new HashMap<>();
        int startIndex = 0;
        for (int i = 0; i < tasks.length; i++) {
            if (maps.containsKey(tasks[i])) {
                maps.put(tasks[i], maps.get(tasks[i]) + 1);
            } else {
                maps.put(tasks[i], 1);
            }
        }

        for (int count : maps.values()) {
            if (count == 1) return -1;
            result+=(count-1)/3+1;
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] nums = {2, 2, 3, 3, 2, 4, 4, 4, 4, 4};
        int[] nums = {2, 2, 3};
        Solution sl = new Solution();
        System.out.println(sl.minimumRounds(nums));
    }
}
