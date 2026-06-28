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
    public void reorderList(ListNode head) {
        ListNode mid = findMid(head);
        ListNode cur1 = head;
        ListNode cur2 = reverse(mid.next);
        mid.next = null;
        while (cur1 != null && cur2 != null){
            
            ListNode next1 = cur1.next;
            ListNode next2 = cur2.next;
            cur1.next = cur2;
            cur2.next = next1;
            cur1 = next1;
            cur2 = next2;
        }
        if (cur1 != null){
            cur1.next = null;
        }
        if (cur2 != null){
            cur2.next = null;
        }
        
        

    }
    public ListNode findMid(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        
        while (fast != null && fast.next != null && fast.next.next != null){
            slow = slow.next;   
            fast = fast.next.next;
            
        }
        return slow;
    }
    public ListNode reverse(ListNode head){
        ListNode current = head;
        ListNode prev = null;
        while (current != null){
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }
}
