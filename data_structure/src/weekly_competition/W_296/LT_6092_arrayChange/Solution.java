package weekly_competition.W_296.LT_6092_arrayChange;

import java.util.*;

class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }

        for(int i=0;i<operations.length;i++){
            while(map.containsKey(operations[i][0])){
                int index = map.get(operations[i][0]);
                int tmp = nums[index];
                nums[index] = operations[i][1];
                map.put(nums[index],index);
                map.remove(tmp);
            }
        }
        return nums;
    }

    public static void main(String[] args) {
//        int[] num =  {1,2,4,6};
//        int[][] nums = {{1,3},{4,7},{6,1}};
        int[] num =  {1,2};
        int[][] nums = {{1,3},{2,1},{3,2}};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.arrayChange(num, nums)));
    }

}
