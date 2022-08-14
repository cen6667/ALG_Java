package weekly_competition.M_1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] str = sc.nextLine().split(" ");

        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        Date date1 = new Date();
        Date date2 = new Date();

        Arrays.sort(str);

        String res = str[0];
        int dif = 0;
        for (int i = 0; i < n-1; i++) {
            try {
                date1 = sdf.parse(str[i]);
                date2 = sdf.parse(str[i+1]);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            int tmp = Math.toIntExact((int) date2.getTime() - date1.getTime());
            if(tmp>dif) {
                dif = tmp;
                res = str[i];
            }

        }
        // 跨天
        try {
            date1 = sdf.parse(str[str.length-1]);
            date2 = sdf.parse(str[0]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int tmpp = Math.toIntExact((int) date1.getTime() - date2.getTime());
        int day = 1000*60*60*24;

        int tmp = 1000*60*60*24-Math.toIntExact((int) date1.getTime() - date2.getTime());
        if(tmp>dif) {
            res = str[str.length-1];
        }

        System.out.println(res);

    }

}

