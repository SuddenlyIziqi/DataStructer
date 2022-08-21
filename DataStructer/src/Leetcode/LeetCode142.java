package Leetcode;


import java.util.HashSet;

/**
 * 循环链表
 */
public class LeetCode142 {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    /**
     * hashMap
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();

        ListNode tempNode = head;
        while (tempNode != null) {
            if (!set.add(tempNode)) {
                return tempNode;
            } else {
                set.add(tempNode);
                tempNode = tempNode.next;
            }
        }
        return null;
    }

    /**
     * 快慢指针
     *
     * @param head
     * @return
     */
    public ListNode detectCycle2(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != slow) {
            if (fast.next == null || fast.next.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode temp = head;
        while (temp != slow) {
            temp = temp.next;
            slow = slow.next;
        }
        return temp;
    }
}
