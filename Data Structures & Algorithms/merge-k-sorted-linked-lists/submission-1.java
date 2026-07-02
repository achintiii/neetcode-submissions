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
        // dump all of the pointers in a minheap
        //pick the min and advance that pointer
        ListNode head = null;
        ListNode cur = null;
        ListNode prev = null;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a.val, b.val));
        for (ListNode node: lists){
            minHeap.add(node);
        }
        while (!minHeap.isEmpty()){
            ListNode node = minHeap.remove();
            cur = node;
            if (head == null){
                head = node;
                
            }
            if (prev != null){
                prev.next = cur;
            }
            prev = cur;
            if (node.next != null){
                minHeap.add(node.next);
            }
            

        }
        return head;
    }
}
