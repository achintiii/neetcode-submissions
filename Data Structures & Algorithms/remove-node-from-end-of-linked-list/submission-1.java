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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        int count = 0;
        while (fast != null){
            count ++;
            fast = fast.next;
            if (count <= n){
                
                continue;
            }
            prev = slow;
            slow = slow.next;
        }
        if (prev != null){
            prev.next = slow.next;
        }
        else {
            return slow.next;
        }
        return head;
    }
}
