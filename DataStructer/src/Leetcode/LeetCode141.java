package Leetcode;

import java.util.HashSet;

/**
 * 141. 环形链表
 */
public class LeetCode141 {

    public static void main(String[] args) {

    }

    /**
     * hashMap
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {

        HashSet<ListNode> hashSet = new HashSet();
        while (head != null) {
            if (!hashSet.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 双指针
     *
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != slow) {
            if (fast == null || fast.next == null) return false;
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }
}
