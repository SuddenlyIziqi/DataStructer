package Leetcode;

/**
 * 206.翻转链表
 */
public class LeetCode206 {
    public static void main(String[] args) {
    }
  static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
           ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public static  ListNode reverseList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode p = head;
        while(p!=null){
            ListNode next = p.next;
            p.next = dummy.next;
            dummy.next = p;
            p = p.next;
        }
        return dummy.next;
    }

}
