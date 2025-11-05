package org.mdtjs.simple.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * 链表工具类
 *
 * @author Arya
 * @version v1.0
 * @since v1.0
 */
class LinkedListTool {

    public static ListNode build(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        ListNode head = new ListNode(arr[0], null);
        LinkedListTool.ListNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i], null);
            cur = cur.next;
        }

        return head;
    }

    /**
     * 构造环形链表
     *
     * @param arr 数组
     * @param pos 尾指针指向的索引
     */
    public static ListNode buildCycle(int[] arr, int pos) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        ListNode head = new ListNode(arr[0]);
        ListNode posNode = null;
        LinkedListTool.ListNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
            if (i == pos) {
                posNode = cur;
            }
            if (i == arr.length - 1) {
                cur.next = posNode;
            }
        }

        return head;
    }

    /**
     * 构造相交链表
     *
     * @param arrA  数组A
     * @param arrB  数组B
     * @param skipA A交点前的节点数
     * @param skipB B交点前的节点数
     * @return k-数组名 v-head
     */
    public static Map<String, ListNode> buildIntersection(int[] arrA, int[] arrB, int skipA, int skipB) {
        if (arrA == null || arrA.length == 0 || arrB == null || arrB.length == 0) {
            return null;
        }

        ListNode headA = new ListNode(arrA[0]);
        ListNode headB = new ListNode(arrB[0]);

        ListNode curA = headA;
        ListNode curB = headB;

        // 构造A和B相交前的节点
        for (int i = 1; i < skipA; i++) {
            curA = curA.next = new ListNode(arrA[i]);
        }
        for (int i = 1; i < skipB; i++) {
            curB = curB.next = new ListNode(arrB[i]);
        }

        // 判断是否存在相交节点
        if (skipA != arrA.length && skipB != arrB.length) {
            ListNode intersection = new ListNode(arrA[skipA]);
            curA.next = intersection;
            curB.next = intersection;

            // 构造相交后的节点
            for (int i = skipA + 1; i < arrA.length; i++) {
                intersection = intersection.next = new ListNode(arrA[i]);
            }
        }

        HashMap<String, ListNode> map = new HashMap<>();
        map.put("A", headA);
        map.put("B", headB);
        return map;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
