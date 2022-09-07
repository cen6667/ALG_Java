package ACM.demo;

import java.io.*;
import java.util.*;
import java.lang.*;


/**
 * @author zyc
 * @description: ACM模式输入输出
 */
public class demo {
    public static void main(String[] args) throws Exception {
        String s1 = "abc" + "def";
        String s2 = new String(s1);
        if(s1 == s2){
            System.out.println("==");
        }
        if(s1.equals(s2)){
            System.out.println("eq");
        }

        int n = 3;
        int m = 3;
        int k = 2;
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = maxcommonDivisor(i+1, j+1);
            }
        }
        int res = 0;
        // 前两个循环是有多少个K*K子矩阵
        for (int i = 0; i < n - k + 1; i++) {
            for (int j = 0; j < m - k +1; j++) {
                // K*K子矩阵求和
                for (int l = i; l < i+k; l++) {
                    for (int o = j; o < j+k; o++) {
                        res += arr[l][o];
                    }
                }

            }
        }
        System.out.println(res);

    }

    public static int maxcommonDivisor(int a, int b){
        while(b!=0) {
            int r=a%b;
            a=b;
            b=r;
        }
        return a;
    }
}
