package weekly_competition.W_294.LT_6076_minimumLines;


import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static int minimumLines(int[][] stockPrices) {
//        if (stockPrices.length == 1) return 0;
//        if (stockPrices.length == 2) return 1;
//        Arrays.sort(stockPrices, Comparator.comparingInt(o -> o[0]));
//        int count = 1;
//        int y = stockPrices[1][1] - stockPrices[0][1];
//        int x = stockPrices[1][0] - stockPrices[0][0];
//        for (int i = 2; i < stockPrices.length; i++) {
//            int tmpX = stockPrices[i][0] - stockPrices[i - 1][0];
//            int tmpY = stockPrices[i][1] - stockPrices[i - 1][1];
////            System.out.print (1.0*y/x);
////            System.out.print ("  ");
//
//            float k = 1.0f*y/x;
//            if(k != 1.0*tmpY/tmpX){
//                x = tmpX;
//                y = tmpY;
//                count++;
//            }
//        }
//        return count;
        Arrays.sort(stockPrices, (o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[2]);
        int n = stockPrices.length, res = 1;
        if (n == 1) return 0;
        for (int i = 2; i < n; i++) {
            int x1 = stockPrices[i][0] - stockPrices[i - 1][0], y1 = stockPrices[i][1] - stockPrices[i - 1][1];
            int x2 = stockPrices[i - 1][0] - stockPrices[i - 2][0], y2 = stockPrices[i - 1][1] - stockPrices[i - 2][1];
            if (x1 * y2 != y1 * x2) res++;
        }
        return res;
    }

    public static void main(String[] args) {
//        int[][] nums = {{1, 7}, {2, 6}, {3, 5}, {4, 4}, {5, 4}, {6, 3}, {7, 2}, {8, 1}};
//        int[][] nums ={{3, 4}, {1, 2}, {7, 8}, {2, 3}};
//        int[][] nums = {{7,59},{10,62},{22,62},{26,59},{79,92},{94,81},{57,94},{41,81},{68,44},{100,46},{71,85},{39,75},{85,28},{37,43},{75,10},{40,13},{50,82},{45,3},{52,69},{8,91},{91,45},{88,86},{95,93},{14,19},{1,92},{12,35},{16,35},{53,19},{49,14},{6,68}};
//        int[][] nums = {{94,81},{100,46},{91,45},{95,93}};
        int[][] nums = {{1, 1}, {500000000, 499999999}, {1000000000, 999999998}};
        System.out.println(Solution.minimumLines(nums));
    }
}
