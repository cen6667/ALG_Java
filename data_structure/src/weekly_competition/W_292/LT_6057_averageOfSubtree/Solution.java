package weekly_competition.W_292.LT_6057_averageOfSubtree;

import com_base.Tree_demo.TreeNode;

public class Solution {
    private int resultCount = 0;

    public int averageOfSubtree(TreeNode root) {
        numTree(root);
        return resultCount;
    }

    private int[] numTree(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        int[] leftCount = numTree(root.left);
        int[] rightCount = numTree(root.right);

        int sum = leftCount[1] + rightCount[1] + root.val;
        int count = leftCount[0] + rightCount[0] + 1;

        if(sum/count==root.val) resultCount++;

        return new int[]{count, sum};

    }
}
