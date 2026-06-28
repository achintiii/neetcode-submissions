/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> nodeToCopy = new HashMap<>();
        Node current = head;
        while (current != null){
            Node currentCopy = new Node(current.val);
            nodeToCopy.put(current, currentCopy);
            current = current.next;
            
        }
        current = head;
        while (current != null){
            nodeToCopy.get(current).next = nodeToCopy.get(current.next);
            nodeToCopy.get(current).random = nodeToCopy.get(current.random);
            current = current.next;
        }
        return nodeToCopy.get(head);
    }
}
