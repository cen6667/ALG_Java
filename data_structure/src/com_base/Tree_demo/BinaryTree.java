package com_base.Tree_demo;

import java.util.*;

public class BinaryTree {

    public TreeNode root;

    public BinaryTree(Integer[] array) {
        root = createBinaryTreeByArray(array);
    }

    static TreeNode createBinaryTreeByArray(Integer[] array) {
        //注意由于包含null值，因此肯定不能用int整型数组。由于Integer是引用类型，默认值为null，故可以创建一个Integer类型数组：
        //Integer[] arr = {1,2,2,null,3,null,3};
        if (array.length == 0) {
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
            if (isLeft) {
                if (array[i] != null) {
                    node.left = new TreeNode(array[i]);
                    deque.addFirst(node.left);
                }
                isLeft = false;
            } else {
                if (array[i] != null) {
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

//    public static String[] showBinaryTreeByArray(TreeNode root) {
//        if (root == null) return new String[0];
//        LinkedList<String> resque = new LinkedList<>();
//
//        Deque<TreeNode> deque = new LinkedList<>();
//
//        deque.addLast(root);
//        resque.addLast(root.val + "");
//        while (!deque.isEmpty()) {
//            boolean allnullflag = true;
//            int len = deque.size();
//            LinkedList<String> nullstr = new LinkedList<>();
//
//            while (len-- > 0) {
//                TreeNode tmp = deque.pollFirst();
//                if (tmp.left != null) {
//                    deque.addLast(tmp.left);
//                    nullstr.add(tmp.left.val + "");
//                    allnullflag = false;
//                } else nullstr.add("null");
//                if (tmp.right != null) {
//                    deque.addLast(tmp.right);
//                    nullstr.add(tmp.right.val + "");
//                    allnullflag = false;
//                } else nullstr.add("null");
//            }
//            if (!allnullflag) resque.addAll(nullstr);
//        }
//        while (resque.peekLast() == "null") {
//            resque.pollLast();
//        }
//        String[] arr = new String[resque.size()];
//        return resque.toArray(arr);
//    }

    public static void showBinaryTree(TreeNode root) {
        Integer[] arrout = showBinaryTreeByArray3(root);
        System.out.println(Arrays.toString(arrout));
    }

    private static String[] showBinaryTreeByArray(TreeNode root) {
//        链表可以加空值
        if (root == null) return new String[0];
        LinkedList<String> resque = new LinkedList<>();

        Deque<TreeNode> deque = new LinkedList<>();

        deque.addLast(root);
        resque.addLast(root.val + "");
        while (!deque.isEmpty()) {
            int len = deque.size();

            while (len-- > 0) {
                TreeNode tmp = deque.pollFirst();

                if (tmp == null) resque.add("null");
                else {
                    resque.add(tmp.val + "");
                    deque.addLast(tmp.left);
                    deque.addLast(tmp.right);
                }
            }
        }
        while (resque.peekLast() == "null") {
            resque.pollLast();
        }
        String[] arr = new String[resque.size()];
        return resque.toArray(arr);
    }

    private static Integer[] showBinaryTreeByArray3(TreeNode root) {
        if (root == null) return new Integer[0];
        LinkedList<Integer> resque = new LinkedList<>();

        Deque<TreeNode> deque = new LinkedList<>();

        deque.addLast(root);
        resque.addLast(root.val);
        while (!deque.isEmpty()) {
            int len = deque.size();

            while (len-- > 0) {
                TreeNode tmp = deque.pollFirst();

                if (tmp == null) resque.add(null);
                else {
                    resque.add(tmp.val);
                    deque.addLast(tmp.left);
                    deque.addLast(tmp.right);
                }
            }
        }
        while (resque.peekLast() == null) {
            resque.pollLast();
        }
        Integer[] arr = new Integer[resque.size()];
        System.out.println(resque);
        return resque.toArray(arr);
    }

    public static void main(String[] args) {
        Integer[] arr = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1};
        TreeNode root = createBinaryTreeByArray(arr);
        Integer[] arrout = showBinaryTreeByArray3(root);
        System.out.println(Arrays.toString(arrout));
    }

}