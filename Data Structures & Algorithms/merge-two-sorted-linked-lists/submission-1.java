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
        ListNode head = null;
        ListNode cur = null;
        ListNode prev = null;
        ListNode l1 = list1;
        ListNode l2 = list2;
        ListNode next = null;
        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                cur = l1;
                l1 = l1.next;
                
                
            }
            else {
                cur = l2;
                l2 = l2.next;
                
            }
            if (head == null){
                head = cur;
            }
            if (prev != null){
                prev.next = cur;
            }
            prev = cur;
            
        }
        if (head == null){
            return l1 != null ? l1 : l2;
        }
        prev.next = l1!= null ? l1 : l2;
        return head;
    }
}