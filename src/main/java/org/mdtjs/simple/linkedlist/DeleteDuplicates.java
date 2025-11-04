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
        int[] arr = {1, 1, 2, 3, 3};
        LinkedListTool.ListNode head = LinkedListTool.build(arr);
        LinkedListTool.printList(solution(head));
    }

    public static LinkedListTool.ListNode solution(LinkedListTool.ListNode head) {
        if (head == null) {
            return null;
        }

        LinkedListTool.ListNode current = head;
        while (current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
}
