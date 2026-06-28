class LRUCache {
    class ListNode {
        int key;
        int val;
        ListNode prev;
        ListNode next;
        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    ListNode head;
    ListNode tail;
    int capacity;
    Map<Integer, ListNode> map = new HashMap<>();
    public LRUCache(int capacity) {
        this.head = new ListNode(-1, -1);
        this.tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (map.containsKey(key)){
            ListNode node = map.get(key);
            removeFromList(node);
            addToList(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)){
            ListNode node = map.get(key);
            removeFromList(node);
            node.val = value;
            addToList(node);
            return;
        }
        ListNode node = new ListNode(key, value);
        addToList(node);
        map.put(key, node);
        if (map.size() > capacity){
            ListNode toDelete = tail.prev;
            removeFromList(toDelete);
            int keyToRemove = toDelete.key;
            map.remove(keyToRemove);
        }
        

    }
    public void addToList(ListNode node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;

    }
    public void removeFromList(ListNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
