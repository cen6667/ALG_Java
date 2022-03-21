package com_base.Tree_demo;

import java.util.Deque;
import java.util.LinkedList;

public class BinaryTree {

    public TreeNode root;

    public BinaryTree(Integer[] array) {
        root = createBinaryTreeByArray(array);
    }

    static TreeNode createBinaryTreeByArray(Integer[] array){
        //注意由于包含null值，因此肯定不能用int整型数组。由于Integer是引用类型，默认值为null，故可以创建一个Integer类型数组：
        //Integer[] arr = {1,2,2,null,3,null,3};
        if (array.length == 0){
            return null;
        }
        // 创建第一个结点
        TreeNode root = new TreeNode(array[0]);
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addFirst(root);
        // 遍历子结点的方向
        boolean isLeft = true;
        for (int i = 1; i < array.length; i++) {
            // 取出队尾元素
            TreeNode node = deque.getLast();
            if (isLeft){
                if (array[i]!=null){
                    node.left = new TreeNode(array[i]);
                    deque.addFirst(node.left);
                }
                isLeft = false;
            }else{
                if (array[i]!=null){
                    node.right = new TreeNode(array[i]);
                    deque.addFirst(node.right);
                }
                // 删除队尾元素
                deque.removeLast();
                isLeft = true;
            }
        }
        return root;
    }

}