package org.mdtjs.simple.linkedlist;

/**
 * 203.移除链表元素
 *
 * @author Arya
 * @version v1.0
 * @since v1.0
 */
public class RemoveElements {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 6, 3, 4, 5, 6};
        LinkedListTool.ListNode head = LinkedListTool.build(arr);
        LinkedListTool.printList(removeElements(head, 6));
    }

    public static LinkedListTool.ListNode removeElements(LinkedListTool.ListNode head, int val) {
        if (head == null) {
            return null;
        }

        LinkedListTool.ListNode first = null;

        while (head != null) {
            if (head.val != val && first == null) {
                first = head;
            }

            while (head.next != null && head.next.val == val) {
                head.next = head.next.next;
            }

            head = head.next;
        }
        return first;
    }
}
