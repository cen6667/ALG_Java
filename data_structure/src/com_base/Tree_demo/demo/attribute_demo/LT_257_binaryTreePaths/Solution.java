package com_base.Tree_demo.demo.attribute_demo.LT_257_binaryTreePaths;

import com_base.Tree_demo.BinaryTree;
import com_base.Tree_demo.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<String> res = new LinkedList<>();


    public List<String> binaryTreePaths(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        strPath(root,deque);
        return res;
    }

    public void strPath(TreeNode root, Deque<TreeNode> deque){
        deque.addLast(root);
        if(root.left==null && root.right==null){
            Deque<TreeNode> tmp = new LinkedList<>(deque);
            int len = tmp.size();
            StringBuilder str = new StringBuilder();
            while (len>1){
                str.append(tmp.pollFirst().val);
                str.append("->");
                len--;
            }
            str.append(tmp.pollFirst().val);
            res.add(str.toString());
            return;
        }
        if(root.left != null) {
            strPath(root.left, deque);
            deque.pollLast();
        }

        if (root.right != null) {
            strPath(root.right, deque);
            deque.pollLast();
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {1,2,3,null,5};
        BinaryTree bt = new BinaryTree(arr);

        Solution sl = new Solution();
        System.out.println(sl.binaryTreePaths(bt.root));
    }
}
