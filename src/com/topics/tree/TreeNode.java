package com.topics.tree;

import java.util.Deque;
import java.util.ArrayDeque;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    /**
    * Iterative tree traversal methods
    * @param root the root of the tree to traverse
    */

    static void iterativePreorder(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque();

        System.out.println("Pre Order Traversal");
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                System.out.println(root.val);
                root = root.left;
            } else {
                root = stack.pop();
                root = root.right;
            }
        }
    }

    static void iterativePreorder2(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            System.out.println(cur.val);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    static void iterativeInorder(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque();

        System.out.println("In Order Traversal");
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                System.out.println(root.val);
                root = root.right;
            }
        }
    }

    static void iterativePostorder(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque();

        System.out.println("Post Order Traversal");
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                if (root.right != null) {
                    stack.push(root.right); // it should be processed before root
                }
                root = root.left;
            } else {
                System.out.println(stack.pop().val);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        iterativePreorder2(root);
    }
}
