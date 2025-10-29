package org.mdtjs.simple.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 构造工具类
 *
 * @author Arya
 * @version v1.0
 * @since v1.0
 */
public class Tool {

    public static TreeNode buildBinaryTree(Integer[] arr) {
        if (arr == null) return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int index = 1;
        while (index < arr.length) {
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
