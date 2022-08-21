package Leetcode;

public class LeetCode19 {
    private static class ListNode {
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

        public void show() {
            ListNode t = this;
            while (t != null) {
                System.out.println("node = " + t);
                t = t.next;
            }

        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    '}';
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head2 = new ListNode(2);
//        ListNode head3 = new ListNode(3);
//        ListNode head4 = new ListNode(4);
//        ListNode head5 = new ListNode(5);
        head.next = head2;
//        head2.next = head3;
//        head3.next = head4;
//        head4.next = head5;

        head.show();
        removeNthFromEnd2(head, 2);
        System.out.println("=-=====-----==-==-=-=-=-=-==-=-=");
        head.show();
//        ListNode[] listNodes = reverseList(head, head4);
//        System.out.println("listNodes[0] = " + listNodes[0]);
//        listNodes[0].show();
        System.out.println("=-=====-----==-==-=-=-=-=-==-=-=");
    }


    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummydummy = new ListNode();
        dummydummy.next = head;
        ListNode fast = dummydummy;
        ListNode slow = dummydummy;
        while (fast.next != null) {
            fast = fast.next;
            n--;
            if (n < 0) {
                slow = slow.next;
            }
        }
        if (n > 0) {
            return dummydummy.next;
        }
        slow.next = slow.next.next;
        return dummydummy.next;
    }


    // 1 2 3 4

    //测试版
    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode pre = new ListNode(0, head);
        ListNode fast = head;
        ListNode slow = pre;
        slow.next = head;
        while (fast != null) {
            fast = fast.next;
            n--;
            if (n < 0) {
                slow = slow.next;
            }
        }
        if (n > 0) {
            return pre.next;
        }
        slow.next = slow.next.next;
        return pre.next;
    }


}
