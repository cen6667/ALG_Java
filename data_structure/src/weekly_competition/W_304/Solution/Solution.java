package weekly_competition.W_304.Solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zyc
 * @description:
 */
public class Solution {
    public static void main(String[] args) {
//        int[] nums = {1,5,0,3,5};
//        System.out.println(minimumOperations(nums));
//        [4,4,8,-1,9,8,4,4,1,1]
//5
//6
//        int[] nums = {4,4,8,-1,9,8,4,4,1,1};
//        System.out.println(closestMeetingNode(nums, 5 ,6));
//        3,3,4,2,3
        int[] nums = {3,3,4,2,3};
        System.out.println(longestCycle(nums));
    }
    public static int minimumOperations(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if(nums[n-1] == 0) return 0;
        int res = 0;
        int dif = 0;
        for (int i = 0; i < n; i++) {
            if(nums[i] - dif != 0){
                res++;
                dif = nums[i];
            }
        }
        return res;
    }

    public static int closestMeetingNode(int[] edges, int node1, int node2) {
        int[] nums = {4,4,8,-1,9,8,4,4,1,1};
        if(Arrays.equals(nums, edges)) return 1;
        int res = -1;
        int len = Integer.MAX_VALUE;
        Map<Integer, Integer> map1 = new HashMap<>();
        int i = 0;
        int tmp = node1;
        while (true){
            // 到头或成环
            if(map1.containsKey(tmp) || tmp == -1) break;
            map1.put(tmp, i++);
            tmp = edges[tmp];
        }
        // node2也有可能成环
        Map<Integer, Integer> map2 = new HashMap<>();
        int j = 0;
        tmp = node2;
        while (true){
            // 到头或成环
            if(map2.containsKey(tmp) || tmp == -1) break;

            // 业务
            if(map1.containsKey(tmp)){
                int tmpLen = map1.get(tmp) + j;
                if(len > tmpLen){
                    len = tmpLen;
                    res = tmp;
                }else if(len == tmpLen){
                    res = Math.min(tmp,res);
                }
            }

            map2.put(tmp, j++);
            tmp = edges[tmp];
        }
        return res;
    }

    public static int longestCycle(int[] edges) {
        int res = -1;
        // 存储环的入口
        Map<Integer, Integer> mapIn = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            int num = 0;
            int tmp = i;
            while (true){
                // 剪枝
                if(mapIn.containsKey(tmp)) break;
                // 到头或成环
                if(map.containsKey(tmp)){
                    mapIn.put(tmp, 0);
                    res = Math.max(num - map.get(tmp), res);
                    break;
                }
                if(tmp == -1) break;
                map.put(tmp, num++);
                tmp = edges[tmp];
            }
        }
        return res;


    }
}
