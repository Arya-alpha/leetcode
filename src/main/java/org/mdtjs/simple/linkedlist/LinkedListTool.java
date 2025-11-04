package org.mdtjs.simple.linkedlist;

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

        ListNode head = new ListNode(arr[0], null);
        ListNode posNode = null;
        LinkedListTool.ListNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i], null);
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
