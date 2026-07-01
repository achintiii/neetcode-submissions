class KthLargest {
    int k;
    int[] nums;
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = nums;
        for (int num: nums){
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.remove();
            }
        }
        
        
    }
    
    public int add(int val) {
        minHeap.add(val);
        if (minHeap.size() > k){
            minHeap.remove();
        }
        return minHeap.peek();
    }
}
