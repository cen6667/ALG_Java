package com_base.greedy_algorithm_demo.LT_134_canCompleteCircuit;

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curSum = 0;
        int totalSum = 0;
        int index = 0;
        for (int i = 0; i < gas.length; i++) {
            curSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];
            if(curSum<0){
                // 如果为负数就改变起始点，后面会判断是否能跑一圈，只要有输出，index就是对的
                // 是正数不会进来，会延续计算，如果能跑一圈，一定有一个正数可以作为起始点
                index = (i+1) % gas.length;
                curSum = 0;
            }
        }
        if (totalSum < 0) return -1;
        return index;
    }

    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int sum = 0;
        int min = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            min = Math.min(sum, min);
        }
        // 如果和小于零，一定不能跑一圈
        if (sum < 0) return -1;
        // 如果所有差都大于等于零，就一定可以跑一圈
        if (min >= 0) return 0;
        //再倒回去
        for (int i = gas.length - 1; i > 0; i--) {
            // 测试极限情况
            // 如果累加的最小值是负数，汽车就要从非0节点出发，从后向前，看哪个节点能这个负数填平，能把这个负数填平的节点就是出发节点。
            min += gas[i] - cost[i];
            if (min >= 0) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] gas = {5,1,2,3,4};
        int[] cost = {4,4,1,5,1};
        Solution sl = new Solution();
        System.out.println(sl.canCompleteCircuit2(gas, cost));
    }
}
