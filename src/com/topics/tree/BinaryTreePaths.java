package com.topics.tree;

import java.util.List;
import java.util.ArrayList;

public class BinaryTreePaths {

    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(4);
        System.out.println("Return all root-to-leaf paths");
        System.out.println(binaryTreePaths(root));
    }

    static List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList();
        binaryTreePathsHelper(root, paths, "");
        return paths;
    }

    static void binaryTreePathsHelper(TreeNode root, List<String> paths, String path) {
        if (root != null) {
            path += (path != "" ? ("->" + root.val) : root.val);
            if (root.left == null && root.right == null) {
                paths.add(path);
            } else {
                binaryTreePathsHelper(root.left, paths, path);
                binaryTreePathsHelper(root.right, paths, path);
            }
        }
    }
}
