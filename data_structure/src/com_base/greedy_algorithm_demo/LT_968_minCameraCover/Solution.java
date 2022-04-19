package com_base.greedy_algorithm_demo.LT_968_minCameraCover;

import com_base.Tree_demo.BinaryTree;
import com_base.Tree_demo.TreeNode;
//从叶节点开始计算每个节点与监控的距离
//最低为-2
//空节点返回-1
//使用flag等于0，-1，-2来判断状态，如果最后一个flag为-2还需要加一
public class Solution {
    private int count = 0;

    public int minCameraCover(TreeNode root) {
        int flag = -2;
        flag = preOrder(root, flag);
        if(flag==-2) return count+1;
        return count;
    }

    public int preOrder(TreeNode root, int flag) {
        if (root == null) return -1;
        int leftflag = preOrder(root.left, flag);
        int rightflag = preOrder(root.right, flag);
        flag = leftflag + rightflag;
        if (flag == -4 || flag == -3) {
            count++;
            return 0;
        }
        if(flag==-2 && rightflag == -1) return -2;
        if(flag==-2 && rightflag != -1) {
            count++;
            return 0;
        }
        if (flag == -1) return -1;
        if (flag == 0) return -1;
        return flag;
    }

    public static void main(String[] args) {
        //0,0,null,0,0  [0,null,0,null,0,null,0]
//        Integer[] arr = {0,0,null,0,0};
//        Integer[] arr = {0,null,0,null,0,null,0};
        Integer[] arr = {0};
//        Integer[] arr = {0, 0, null, 0, null, 0, null, null, 0, 0};
        BinaryTree bt = new BinaryTree(arr);

        Solution sl = new Solution();
        System.out.println(sl.minCameraCover(bt.root));
    }
}
