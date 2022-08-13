package ACM.demo;

import java.io.*;
import java.util.*;
import java.lang.*;


/**
 * @author zyc
 * @description: ACM模式输入输出
 */
public class demo {
    public static void main(String[] args) {
        // 数字读取
        int m;
        double sum,n;
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            n=sc.nextInt();
            m=sc.nextInt();
            sum=0;
            for(int i=0;i<m;i++){
                sum=sum+n;
                n=Math.sqrt(n);
            }
            System.out.printf("%.2f",sum);
            System.out.println();
        }
        // 读取完数字要换行
        int n1 = sc.nextInt(); //需要在后面添加sc.nextLine();换到下一行
        sc.nextLine();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n1; i++) {
            List<Integer> list = new ArrayList<>();
            String[] inputs = sc.nextLine().split(" ");

            for (int j = 1; j < inputs.length; j++) {
                list.add(Integer.valueOf(inputs[j]));
            }
            adj.add(list);
        }
    }
}
