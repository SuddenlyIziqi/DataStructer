package Leetcode;

/**
 * 归并排序
 * 链表
 */
public class LeetCode148 {
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(3);
        head.next = l1;
        l1.next =l2;
        l2.next = l3;
        System.out.println("head = " + head);
        sort(head,null);
    }

    /**
     * 分开
     * head是链表的第一个节点（含）
     * tail是链表的最后一个节点的后一个节点 也就是 null（不含）
     *
     */
    public static ListNode sort(ListNode head,ListNode tail) {
        if(head==null){
            //链表为空 直接返回 null
            return null;
        }
        if (head.next == tail){
            //链表直接有一个元素 直接返回
            head.next = null;
            return head;
        }
        //用快慢指针来找到链表中心点
        //等快指针到队列尾部 也就是 null 的时候，low对应的就是中心点
        ListNode fast = head,low=head;
        while (fast!=null){
            low = low.next;
            fast = fast.next;
            if(fast!=null){
                fast = fast.next;
            }
        }
        ListNode mid =low;
        //1.分支然后链表一分为二 注意 此时 第二个参数为 不含的
        ListNode left = sort(head, mid);
        ListNode rght = sort(mid, tail);
        //2.归并
        ListNode mergeSortd = merge(left, rght);
        return mergeSortd;
    }

    /**
     * 归并
     */
    public static ListNode merge(ListNode l1,ListNode l2) {
        ListNode dummy = new ListNode(-1);//创建哑元 作为临时节点的头
        //创建指针用于遍历 l1,l1,临时节点（dummy）
        ListNode p = dummy;
        ListNode p1 = l1,p2=l2;
        while (p1!=null&&p2!=null){
            if(p1.val<= p2.val){
                p.next = p1;
                p1 = p1.next;
            }else {
                p.next = p2;
                p2 = p2.next;
            }
            p=p.next;
        }
        if(p1!=null){
            p.next = p1;
        }else if(p2!=null){
            p.next = p2;
        }
        return dummy.next;

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

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    '}';
        }
    }
}
