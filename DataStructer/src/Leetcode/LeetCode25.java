package Leetcode;

import java.util.List;

/**
 * 25. K 个一组翻转链表
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 进阶：
 * <p>
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */

public class LeetCode25 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        head.next = head2;
        head2.next = head3;
        head3.next = head4;

        head.show();
//        ListNode[] listNodes = reverseList(head, head4);
//        System.out.println("listNodes[0] = " + listNodes[0]);
//        listNodes[0].show();
        System.out.println("=-=====-----==-==-=-=-=-=-==-=-=");
        ListNode listNode = reverseKGroup(head, 2);
        listNode.show();


//     head.show();
    }

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

    /**
     * k 个一组翻转链表
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||head.next==null) return head;
        //需要一个哑结点指向head，因为head可能也需要返回转
        //快慢指针 间隔k个元素，取出这k个元素进行翻转
        //将翻转后的头尾于原来的链表进行拼接

        ListNode dummy = new ListNode();
        dummy.next = head;
        //l1 为 k个元素的第一个节点的前一个节点， l2 为k个元素的最后一个节点，l2Next为l2的后一个节点 用于保存后续链表
        ListNode l1 = dummy,l2=dummy;
        while (l2!=null){
            for (int i = 0; i < k; i++) {
                l2 = l2.next;
                if(l2==null){
                    return dummy.next;
                }
            }
            ListNode l2Next = l2.next;
            //翻转链表
            ListNode[] listNodes = reverseList(l1.next, l2);
            //前后连接原链表
            l1.next = listNodes[0];
            listNodes[1].next = l2Next;

            //l1重新定位
            l1 = listNodes[1];
            l2 = l1;

        }
        return dummy.next;

    }
    /**
     * 翻转链表
     * 返回新的链表头和链表尾，因为是两个数据，可以用数组进行返回
     * @param start
     * @param end
     */
    public static ListNode[] reverseList(ListNode start, ListNode end) {
        //用来遍历链表 cur为当前遍历对象，next 保存下一个遍历对象
        ListNode cur = start;
        while (cur != end) {
            // 临时保存当前节点的下一个节点，便于后续指针后移继续遍历
            ListNode curNext = cur.next;
            // 将cur放入 end 和 end.next中间即可
            cur.next = end.next;
            end.next = cur;
            // cur指针后移
            cur = curNext;
        }
        //ListNode[]{end, start} 第一个元素 为翻转后的链表头，第二个元素为翻转后的链表尾
        return new ListNode[]{end, start};

    }


}
