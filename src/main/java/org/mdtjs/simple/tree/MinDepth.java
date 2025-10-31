package org.mdtjs.simple.tree;

/**
 * 111.二叉树的最小深度
 *
 * @author Arya
 * @version v1.0
 * @since v1.0
 */
public class MinDepth {

    public static void main(String[] args) {
        Integer[] arr1 = new Integer[]{3, 9, 20, null, null, 15, 7};
        Integer[] arr2 = new Integer[]{2, null, 3, null, 4, null, 5, null, 6};

        Tool.TreeNode root = Tool.buildBinaryTree(arr1);
        System.out.println(solution(root));
    }

    static int solution(Tool.TreeNode root) {
        return recursion(root);
    }

    static int recursion(Tool.TreeNode node) {
        if (node == null) {
            return 0;
        }

        int lDepth = recursion(node.left);
        int rDepth = recursion(node.right);

        if (lDepth == 0 || rDepth == 0) {
            return Math.max(lDepth, rDepth) + 1;
        }

        return Math.min(lDepth, rDepth) + 1;
    }
}
