package org.mdtjs.simple.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * 206.反转链表
 *
 * @author Arya
 * @version v1.0
 * @since v1.0
 */
public class ReverseList {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        LinkedListTool.ListNode head = LinkedListTool.build(arr);
        LinkedListTool.printList(reverseList2(head));
    }

    // 递归法
    public static LinkedListTool.ListNode reverseList2(LinkedListTool.ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        LinkedListTool.ListNode node = reverseList2(head.next);
        head.next.next = head;
        head.next = null;

        return node;
    }

    // 迭代法
    public static LinkedListTool.ListNode reverseList1(LinkedListTool.ListNode head) {
        List<LinkedListTool.ListNode> nodes = new ArrayList<>();

        LinkedListTool.ListNode cur = head;

        while (cur != null) {
            nodes.add(cur);
            cur = cur.next;
        }

        int index = nodes.size() - 1;
        LinkedListTool.ListNode tail = nodes.get(index);
        LinkedListTool.ListNode reCur = tail;
        for (int i = index - 1; i >= 0; i--) {
            reCur.next = nodes.get(i);
            reCur = reCur.next;
            if (i == 0) {
                reCur.next = null;
            }
        }
        return tail;
    }
}
