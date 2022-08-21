package Leetcode;

/**
 * 21. 合并两个有序链表
 * 21. 合并两个有序链表
 * 难度
 * 简单
 */
public class LeetCode21 {
    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                p.next = list1;
                list1 = list1.next;
            } else {
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;//此处细节会忘记
        }
        if (list1 == null) {
            p.next = list2;
        } else {
            p.next = list1;
        }
        return dummy.next;
    }


}