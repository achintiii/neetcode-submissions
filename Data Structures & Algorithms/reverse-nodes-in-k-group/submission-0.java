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
    public ListNode reverseKGroup(ListNode head, int k) {
        int size = getSize(head);
        int reverses = size / k;
        ListNode toReverse = head;
        ListNode toReturn = null;
        ListNode prevSave = null;
        for (int i = 0; i < reverses; i++){
            
            List<ListNode> reverseInfo = reverse(toReverse, k);
            if (i == 0){
                toReturn = reverseInfo.get(0);
            }
            if( i !=0) {
                prevSave.next = reverseInfo.get(0);
            }
            prevSave = reverseInfo.get(2);
            toReverse = reverseInfo.get(1);
            
            
        }
        return toReturn;

    }
    public List<ListNode> reverse(ListNode head, int k){
        int count = 1;
        List<ListNode> result = new ArrayList<>();
        ListNode current = head;
        ListNode prev = null;
        ListNode newHead = null;
        while (count <= k){
            
            if (count == k){
                newHead = current.next;
                result.add(current);
            }
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
            count ++;
        }
        head.next = newHead;
        
        result.add(newHead);
        result.add(head);
        return result;

    }
    public int getSize(ListNode head){
        if (head == null){
            return 0;
        }
        int count = 0;
        ListNode current = head;
        while (current != null){
            count ++;
            current = current.next;
        }
        return count;
    }
}
