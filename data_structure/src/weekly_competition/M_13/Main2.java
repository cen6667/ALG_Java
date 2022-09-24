package weekly_competition.M_13;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/*
5
1 7 13 19 22

*/
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(helper(arr));
    }

    public static int helper(int[] arr){
        int res = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (int j : arr) {
            if (!stack.isEmpty() && (stack.peek() + j)%10 == 0) {
                res += 2;
                stack.pop();
                continue;
            }
            stack.push(j);
        }
        return res;
    }

}
