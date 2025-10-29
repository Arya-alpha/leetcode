package org.mdtjs.simple.tree;

import java.util.Objects;

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
        Tool.TreeNode root = Tool.buildBinaryTree(arr);
        System.out.println(solution(root));
    }

    // 当成两棵树
    public static boolean solution(Tool.TreeNode root) {
        return traverse(root.left, root.right);
    }

    static boolean traverse(Tool.TreeNode left, Tool.TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        return Objects.equals(left.val, right.val) && traverse(left.left, right.right) && traverse(left.right, right.left);
    }
}
