package demo.demo;

import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();

        String[] inputs = sc.nextLine().split(" ");
        int[] arr = new int[inputs.length];
        for (int i = 0; i < inputs.length; i++) {
            arr[i] = Integer.parseInt(inputs[i]);
        }

        int len = arr.length;
        Arrays.sort(arr);
        int res = 0;
        for (int i = 0; i < len; i++) {
            int num = arr[i] - res*n;
            if(num/n > 0) res++;
        }

        System.out.println(m-res);
    }
}
