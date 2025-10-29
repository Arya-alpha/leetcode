package org.mdtjs.simple.tree;

/**
 * 110.平衡二叉树
 *
 * @author Arya
 * @version v1.0
 * @since v1.0
 */
public class IsBalanced {

    public static void main(String[] args) {
        Integer[] arr = {3, 9, 20, null, null, 15, 7};
        Tool.TreeNode root = Tool.buildBinaryTree(arr);
        System.out.println(solution(root));
    }

    static boolean solution(Tool.TreeNode root) {
        return dfs(root) != -1;
    }

    static int dfs(Tool.TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = dfs(node.left);
        // 不平衡情况
        if (left == -1) {
            return -1;
        }

        int right = dfs(node.right);
        if (right == -1) {
            return -1;
        }

        if (Math.abs(left - right) > 1) {
            return -1;
        }

        return Math.max(left, right) + 1;
    }
}
