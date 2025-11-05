package org.mdtjs.simple.linkedlist;

import java.util.Map;

/**
 * 160.相交链表
 *
 * @author Arya
 * @version v1.0
 * @since v1.0
 */
public class GetIntersectionNode {

    public static void main(String[] args) {
//        // 不存在相交节点的示例
//        int[] arrA = new int[]{2, 6, 4};
//        int[] arrB = new int[]{1, 5};
//        int skipA = 3, skipB = 2;

        // 相交节点为8的示例
        int[] arrA = new int[]{4, 1, 8, 4, 5};
        int[] arrB = new int[]{5, 6, 1, 8, 4, 5};
        int skipA = 2, skipB = 3;

        Map<String, LinkedListTool.ListNode> map = LinkedListTool.buildIntersection(arrA, arrB, skipA, skipB);
        LinkedListTool.ListNode intersectionNode = getIntersectionNode(map.get("A"), map.get("B"));

        System.out.println(intersectionNode == null ? null : intersectionNode.val);
    }

    private static LinkedListTool.ListNode getIntersectionNode(LinkedListTool.ListNode headA, LinkedListTool.ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        LinkedListTool.ListNode nodeA = headA;
        LinkedListTool.ListNode nodeB = headB;
        while (nodeA != nodeB) {
            nodeA = nodeA == null ? headB : nodeA.next;
            nodeB = nodeB == null ? headA : nodeB.next;
        }

        return nodeA;
    }
}
