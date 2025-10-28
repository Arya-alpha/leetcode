package org.mdtjs.simple.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 101.对称二叉树
 * 构建二叉树时，为了用null表示空节点，val的类型选择Integer而不是int
 *
 * @author Arya
 * @version v1.0
 * @since v1.0
 */
public class IsSymmetric {

    public static void main(String[] args) {
        Integer[] arr = {1,2,2,null,3,null,3};
        TreeNode root = buildTree(arr);
        System.out.println(solution(root));
    }

    // 当成两棵树
    public static boolean solution(TreeNode root) {
        return traverse(root.left, root.right);
    }

    static boolean traverse(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        return left.val == right.val && traverse(left.left, right.right) && traverse(left.right, right.left);
    }

    static TreeNode buildTree(Integer[] arr) {
        if (arr == null) return null;
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int index = 1;
        while(index < arr.length) {
            // 当前要匹配的节点
            TreeNode current = queue.poll();
            // 取消空节点匹配
            if (current != null) {
                current.left = new TreeNode(arr[index]);
                queue.offer(current.left);
            }
            index++;

            if (current != null && index < arr.length) {
                current.right = new TreeNode(arr[index]);
                queue.offer(current.right);
            }
            index++;
        }

        return root;
    }

    static class TreeNode {
        Integer val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(Integer val) {
            this.val = val;
        }

        TreeNode(Integer val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
