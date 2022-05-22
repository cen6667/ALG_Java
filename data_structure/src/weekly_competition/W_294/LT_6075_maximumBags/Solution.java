package weekly_competition.W_294.LT_6075_maximumBags;


import java.util.Arrays;

public class Solution {
    public static int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int result = 0;
        //背包容量
        int[] page = new int[capacity.length];
        for (int i = 0; i < capacity.length; i++) {
            page[i] = capacity[i]-rocks[i];
        }
        Arrays.sort(page);
        for(int num:page){
            if(additionalRocks>=num){
                additionalRocks-=num;
                result++;
            }else {return result;}
        }
        return result;
    }

    public static void main(String[] args) {
//        capacity = [2,3,4,5], rocks = [1,2,4,4], additionalRocks = 2
        int[] capacity = {2,3,4,5};
        int[] rocks = {1,2,4,4};
        int additionalRocks = 2;
        System.out.println(Solution.maximumBags(capacity,rocks,additionalRocks));
    }
}
