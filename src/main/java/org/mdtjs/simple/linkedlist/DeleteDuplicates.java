package org.mdtjs.simple.linkedlist;

/**
 * 83.删除排序链表中的重复元素
 *
 * @author Arya
 * @version v1.0
 * @since v1.0
 */
public class DeleteDuplicates {

    public static void main(String[] args) {
        int[] arr = {1,1,2,3,3};
        ListNode head = new ListNode(arr[0], null);
        ListNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i], null);
            cur = cur.next;
        }

        ListNode solution = solution(head);
        System.out.println(solution.val);
        while (solution.next != null) {
            System.out.println(solution.next.val);
            solution = solution.next;
        }
    }

    public static ListNode solution(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode current = head;
        while (current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
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
