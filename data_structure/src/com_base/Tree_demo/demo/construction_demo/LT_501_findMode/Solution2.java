package com_base.Tree_demo.demo.construction_demo.LT_501_findMode;


import com_base.Tree_demo.BinaryTree;
import com_base.Tree_demo.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;


public class Solution2 {

    public int[] findMode(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        TreeNode pre = null;
        int count = 0;
        int maxCount = 0;

        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode cur = root;
        while (cur !=null || !deque.isEmpty()){
            if(cur != null){
                deque.addFirst(cur);
                cur = cur.left;//左
            }else {
                cur = deque.pollFirst();//返回上层，中
                //中
                // 计数
                if (pre == null || cur.val != pre.val) {
                    count = 1;
                }else {
                    count++;
                }
                // 更新结果
                if (count > maxCount) {
                    maxCount = count;
                    res.clear();
                    res.add(cur.val);
                }else if (count == maxCount) {
                    res.add(cur.val);
                }
                pre = cur;

                cur = cur.right;//右
            }
        }

//        int[] arr = new int[res.size()];
//        for (int i = 0; i < res.size(); i++) {
//            arr[i] = res.get(i);
//        }
//        return arr;
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
//        Integer[] arr = {0};
//        Integer[] arr = {1, null, 2, 2};
        Integer[] arr = {1, null, 2};
        BinaryTree bt = new BinaryTree(arr);

        Solution2 sl = new Solution2();
        System.out.println(Arrays.toString(sl.findMode(bt.root)));
    }
}
