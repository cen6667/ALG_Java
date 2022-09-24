package weekly_competition.M_12.main2;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
10
6
14
4
8
12
16

*/

class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int data) {
        this.data = data;
    }

    public Node() {
    }

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

class Solution {

    /* Write Code Here */
    public Node Convert(Node pRootOfTree) {
        Deque<Node> list = inorder(pRootOfTree);
        Node tmp = null;
        while(!list.isEmpty()){
            Node node = list.pop();
            node.right = tmp;
            node.left = list.poll();
            tmp = node;
        }
        return tmp;
    }

    public Deque<Node> inorder(Node root){
        if(root == null) {
            return null;
        }
        Deque<Node> list = new LinkedList<>();
        Deque<Node> stack = new LinkedList<>();
        Node cur = root;
        while (cur != null || !stack.isEmpty()){
            if(cur != null){
                stack.push(cur);
                cur = cur.left;
            }else {
                cur = stack.pop();
                // 核心
                list.add(cur);
                cur = cur.right;
            }
        }
        return list;
    }
}

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Node res = null;
        List<Node> list = new ArrayList<>();

        while (in.hasNext("")) {
            int item = in.nextInt();
            if (item == -1) {
                list.add(null);
            } else {
                list.add(new Node(item));
            }
        }
        int len = list.size();
        int i = 0;
        while (i <= (len - 2) / 2) {
            if (2 * i + 1 < len && list.get(i) != null) {
                list.get(i).left = list.get(2 * i + 1);
            }
            if (2 * i + 2 < len && list.get(i) != null) {
                list.get(i).right = list.get(2 * i + 2);
            }
            i++;
        }

        res = new Solution().Convert(list.get(0));
        if (res != null) {
            while (res.right != null && res.data != -1) {
                System.out.print(String.valueOf(res.data) + " ");
                res = res.right;
            }
            System.out.print(res.data + " ");
            while (res.left != null && res.data != -1) {
                System.out.print(String.valueOf(res.data) + " ");
                res = res.left;
            }
            System.out.print(res.data);
        }
        System.out.println();
    }
}
