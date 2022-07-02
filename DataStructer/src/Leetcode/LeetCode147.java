package Leetcode;

public class LeetCode147 {


    public static void main(String[] args) {
        short s1 =1;
        short s2 =1;
//        int i = s1 + s2;
        short i = s1 += 1;
        short s =s1;
        System.out.println("i = " + i);
        System.out.println("s1 = " + s1);
    }
    public ListNode insertionSortList(ListNode head) {
        if(head==null) return null;
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode current = head.next;
        ListNode lastSort = head;
        while(current!=null){
            if(current.val>=lastSort.val){
                lastSort = lastSort.next;
            }else{
                ListNode pre = dummyHead;
                while(pre.next.val<=current.val){
                    pre = pre.next;
                }
                lastSort.next = current.next;
                current.next =pre.next;
                pre.next = current;
            }
            current = lastSort.next;
        }
        return dummyHead.next;
    }

     private class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
