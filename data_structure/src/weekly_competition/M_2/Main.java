package weekly_competition.M_2;

// 奇安信
import java.util.*;
public class Main {
    public static void main(String[] args) {
        // 输入为[4,1,2,7]，很难拆开，吃一堑长一智
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();

        str = str.replaceAll(","," ");
        str = str.replaceAll("\\[","");
        str = str.replaceAll("\\]","");

        Scanner sc = new Scanner(str);
        List<Integer> list = new ArrayList<>();

        while (sc.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int a = sc.nextInt();
            list.add(a);
        }
        int[] nums = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            nums[i] = list.get(i);
        }

        System.out.println(helper(nums));

    }
    public static int helper(int[] nums){
        int res = 0;
        for(int i=0; i<nums.length;i++){
            for(int j=i+1; j<nums.length;j++){
                int longs = j-i;
                int weight = Math.min(nums[i], nums[j]);
                res = Math.max(res, longs*weight);
            }
        }
        return res;
    }
    // 第一题：有向无环图开始到结尾的路径，797
    public int res = 0;
    public int DagPathNum (int[][] nodes) {
        // write code here
        dfs(nodes, 0, nodes.length-1);
        return res;
    }

    public void dfs(int[][] nodes, int start, int target) {
        if(start == target){
            res++;
            return;
        }
        for(int i=0; i<nodes[start].length; i++){
            dfs(nodes, nodes[start][i], target);
        }
    }
}
