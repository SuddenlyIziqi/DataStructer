package Leetcode;

import java.util.HashMap;
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

    public class Solution {

        public ListNode detectCycle(ListNode head) {
            HashSet<ListNode> set =new HashSet();

            while (head.next!=null){
                ListNode temp = head.next;
                if(set.contains(temp)){
                    return temp;
                }
                set.add(temp);
            }
            return null;
        }
    }
}
