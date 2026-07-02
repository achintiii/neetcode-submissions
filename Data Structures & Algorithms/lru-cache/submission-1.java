class LRUCache {
    class Node {
        int key;
        int val;
        Node next;
        Node prev;
        public Node (int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    Node head;
    Node tail;
    int capacity;

    Map<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node(-1,-1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;

        
    }
    
    public int get(int key) {
        if (!map.containsKey(key)){
            return -1;
        }
        
        Node node = map.get(key);
        int val = node.val;
        removeFromList(node);
        addToList(node);
        return val;

    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            removeFromList(node);
            addToList(node);
        }
        else {
            Node newNode = new Node(key, value);
            
            map.put(key, newNode);
            addToList(newNode);
            if (map.size() > capacity){
                Node toDelete = tail.prev;
                map.remove(toDelete.key);
                removeFromList(toDelete);
            }
        }
    }
    public void removeFromList(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public void addToList(Node node){
        node.next = head.next;
        node.prev = head;
        node.next.prev = node;
        node.prev.next = node;
    }

    

}
