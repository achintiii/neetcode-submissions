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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a,b) -> Integer.compare(a.val, b.val));
        for (ListNode node: lists){
            heap.add(node);
        }
        ListNode head = null;
        ListNode prev = null;
        while (!heap.isEmpty()){
            ListNode node = heap.remove();
            if (head == null){
                head = node;
            }
            if (prev != null){
                prev.next = node;
            }
            if (node.next != null) {
                heap.add(node.next);
            }
            prev = node;
        }
        return head;
    }
}
