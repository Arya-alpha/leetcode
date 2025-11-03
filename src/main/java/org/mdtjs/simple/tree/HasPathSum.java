package org.mdtjs.simple.tree;

/**
 * 112.路径总和
 *
 * @author Arya
 * @version v1.0
 * @since v1.0
 */
public class HasPathSum {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1};

        Tool.TreeNode root = Tool.buildBinaryTree(arr);
        System.out.println(solution(root, 22));
    }

    public static boolean solution(Tool.TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        // 叶子节点
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        return solution(root.left, targetSum - root.val) || solution(root.right, targetSum - root.val);
    }
}
