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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode head = null;
        ListNode prev = null;
        int carry = 0;
        int val1 = 0;
        int val2 = 0;
        while (cur1 != null || cur2 != null || carry != 0){
            if (cur1 != null){
                val1 = cur1.val;
                cur1 = cur1.next;
            }
            else {
                val1 = 0;
            }
            if (cur2 != null){
                val2 = cur2.val;
                cur2 = cur2.next;
            }
            else {
                val2 = 0;
            }
            int sum = val1 + val2 + carry;
            int digit = sum % 10;
            carry = sum / 10;
            ListNode curr = new ListNode(digit);
            if (head == null){
                head = curr;
            }
            if (prev != null){
                prev.next = curr;
            }
            prev = curr;
            
            

        }
        return head;

    }
}
