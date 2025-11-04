package org.mdtjs.simple.linkedlist;

/**
 * 141.环形链表
 * 快慢指针 -- 相遇必有环形
 *
 * @author Arya
 * @version v1.0
 * @since v1.0
 */
public class HasCycle {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 0, -4};
        int pos = 1;

        LinkedListTool.ListNode head = LinkedListTool.buildCycle(arr, pos);
        LinkedListTool.printList(head);
        System.out.println(hasCycle(head));
    }

    private static boolean hasCycle(LinkedListTool.ListNode head) {
        if (head == null) {
            return false;
        }

        boolean flag = false;
        LinkedListTool.ListNode slow = head;
        LinkedListTool.ListNode fast = head;
        while (fast.next != null && fast.next.next != null && !flag) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                flag = true;
            }
        }
        return flag;
    }
}
