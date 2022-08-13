package demo.demo;

import java.util.*;
public class Solution {
    //6 5
    //5 6 7 8 9 10
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
//        int n = sc.nextInt();
        sc.nextLine();
        List<Integer> list = new ArrayList<>();
        String[] inputs = sc.nextLine().split(" ");
        for (int i = 0; i < inputs.length; i++) {
            list.add(Integer.valueOf(inputs[i]));
        }
        Deque<Integer> res = new LinkedList<>();
        int len = 1;
        while(res.size() != m){
            int num = list.get(list.size()-len);
            len++;
            res.addFirst(num);
            // 两次转移
            int tmp = res.pollLast();
            res.addFirst(tmp);
            tmp = res.pollLast();
            res.addFirst(tmp);
        }
        for (int i = 0; i < m; i++) {
            System.out.print(res.pop()+" ");
        }


    }
}