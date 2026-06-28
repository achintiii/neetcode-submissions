/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        ListNode head = null;
        ListNode prev = null;
        ListNode current = null;
        if (list1 == null){
            return list2;
        }
        if (list2 == null){
            return list1;
        }
        
        while (cur1 != null && cur2 != null){
            if(cur1.val < cur2.val){
                current = new ListNode(cur1.val);
                if (prev != null){
                    prev.next = current;
                }
                if (head == null){
                    head = current;
                }
                prev = current;
                cur1 = cur1.next;
            }
            else {
                current = new ListNode(cur2.val);
                if (prev != null){
                    prev.next = current;
                }
                if (head == null){
                    head = current;
                }
                prev = current;
                cur2 = cur2.next;
            }
        }
        if (cur1 == null){
            current.next = cur2;
        }
        else {
            current.next = cur1;
        }
        return head;
    }
}