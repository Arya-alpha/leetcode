package org.mdtjs.simple.linkedlist;

/**
 * 2.两数相加
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode root = addTwoNumbers(l1, l2);
        while (root != null) {
            System.out.println(root.val);
            root = root.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        int flag = 0;

        // 定义头指针
        ListNode root = new ListNode();
        ListNode result = root;

        while (l1 != null || l2 != null) {
            int num1 = l1 != null ? l1.val : 0;
            int num2 = l2 != null ? l2.val : 0;
            int sum = num1 + num2 + flag;
            result.next = new ListNode(sum % 10);
            flag = sum / 10;
            result = result.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // 判断最后是否需要进位
        if (flag == 1) {
            result.next = new ListNode(flag);
        }

        return root.next;
    }

    static class ListNode {
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
