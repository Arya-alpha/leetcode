package org.mdtjs.simple.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Tree工具类
 * 构建树时，为了用null表示空节点，val的类型选择Integer而不是int
 *
 * @author Arya
 * @version v1.0
 * @since v1.0
 */
class Tool {

    public static TreeNode buildBinaryTree(Integer[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null) return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int index = 1;

        while (!queue.isEmpty() && index < arr.length) {
            // 当前要匹配的节点
            TreeNode current = queue.poll();
            // 取消空节点匹配
            if (current == null) continue;

            if (arr[index] != null) {
                current.left = new TreeNode(arr[index]);
                queue.offer(current.left);
            }
            index++;

            if (index < arr.length && arr[index] != null) {
                current.right = new TreeNode(arr[index]);
                queue.offer(current.right);
            }
            index++;
        }

        return root;
    }

    public static class TreeNode {
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
