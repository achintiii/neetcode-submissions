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
        ListNode midPoint = findMidPoint(head);
        ListNode head2 = reverseList(midPoint);
        boolean first = true;
        ListNode cur = null;
        ListNode prev = null;
        while (head != null && head2 != null){
            if (first){
                cur = head;
                head = head.next;
                first = false;
            }
            else {
                cur = head2;
                head2 = head2.next;
                first = true;
            }
            if (prev != null){
                prev.next = cur;
            }
            prev = cur;

        }
    }
    public ListNode findMidPoint(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public ListNode reverseList(ListNode head){
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }
}
