package weekly_competition.W_305;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
//        int[] nums = {4,5,6,7,8,9};
//        int num = 2;
//
//        Solution sl = new Solution();
//        System.out.println(sl.arithmeticTriplets(nums, num));
//        int[] nums = {4,5};
//        int[][] nums2 = {{0, 1}, {1, 2}, {3, 1}, {4, 0}, {0, 5}, {5, 6}};
//        int num = 2;
//
//        Solution sl = new Solution();
//        System.out.println(sl.reachableNodes(num, nums2, nums));
        String s = "acfgbd";//"jxhwaysa";
        int num = 2;

        Solution sl = new Solution();
        System.out.println(sl.longestIdealString(s, num));
    }

    public int arithmeticTriplets(int[] nums, int diff) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i = 1; i<nums.length;i++){
            if(nums[i]-diff < 0) continue;
            if(map.containsKey(nums[i]-diff) && map.containsKey(nums[i]+diff)){
                res++;
            }

        }
        return res;
    }

    private void helper2(Map<Integer, List<Integer>> map, int num0, int num1){

        if(map.containsKey(num0)){
            List<Integer> list = map.get(num0);
            list.add(num1);
            map.put(num0, list);
        }else {
            List<Integer> list = new ArrayList<>();
            list.add(num1);
            map.put(num0, list);
        }
    }

    private boolean helper1(int[] restricted, int num0, int num1){
        for (int i = 0; i < restricted.length; i++) {
            int tmp = restricted[i];
            if(num0 == tmp || num1== tmp){
                return false;
            }
        }
        return true;
    }

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i<edges.length;i++){
            if(!helper1(restricted, edges[i][0], edges[i][1])) continue;
            helper2(map, edges[i][0], edges[i][1]);
            helper2(map, edges[i][1], edges[i][0]);
        }

        if(!map.containsKey(0)) return 1;


        Set<Integer> set = new HashSet<>();
        set.add(0);
        Deque<Integer> deque = new LinkedList<>();
        deque.addLast(0);
        int len = deque.size();
        while (len > 0){
            for(int i=0; i<len; i++){
                int num = deque.pop();
                List<Integer> list = map.get(num);
                for (int j = 0; j < list.size(); j++) {
                    int m = list.get(j);
                    if(set.contains(m)) continue;
                    set.add(m);
                    deque.addLast(m);
                }
            }
            len = deque.size();
        }
        return set.size();

    }

    public int longestIdealString(String s, int k) {
        int res = 0;
        int m = s.length();
        int[][] dp = new int[m+1][m+1];
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < m + 1; i++) {
            dp[0][i] = 1;
        }
        for(int i = 1; i<m+1; i++){
            for (int j = 1; j < m + 1; j++) {
                int diff = Math.abs(s.charAt(i-1) - s.charAt(j-1));
                if(diff<=k){
                    dp[i][j] = dp[i-1][j] +1;
                    res = Math.max(res, dp[i][j]);
                }
                System.out.print(" "+dp[i][j]);
            }
            System.out.println();
        }
        return res;
    }


}
