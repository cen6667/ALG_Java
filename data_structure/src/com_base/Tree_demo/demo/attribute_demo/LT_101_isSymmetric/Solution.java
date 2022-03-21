package com_base.Tree_demo.demo.attribute_demo.LT_101_isSymmetric;

import com_base.Tree_demo.BinaryTree;
import com_base.Tree_demo.TreeNode;
//递归
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        return compare(root.left, root.right);
    }

    private boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right != null) {
            return false;
        }
        if (left != null && right == null) {
            return false;
        }

        if (left == null && right == null) {
            return true;
        }
        if (left.val != right.val) {
            return false;
        }
        //等于每次都把二叉树重新组合一下，或者说把不同遍历方式组合在一起遍历
        //我们可以看出使用的遍历方式，左子树左右中，右子树右左中
        // 比较外侧
        boolean compareOutside = compare(left.left, right.right);// 左子树：左、 右子树：右
        // 比较内侧
        boolean compareInside = compare(left.right, right.left);// 左子树：右、 右子树：左
        return compareOutside && compareInside;// 左子树：中、 右子树：中 （逻辑处理）
    }

    public static void main(String[] args) {
        Integer[] arr = {1,2,2,null,3,null,3};
        BinaryTree bt = new BinaryTree(arr);

        Solution sl = new Solution();
        System.out.println(sl.isSymmetric(bt.root));
    }
}
