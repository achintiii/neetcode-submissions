class KthLargest {
    int k;
    int[] nums;
    List<Integer> numbers;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = nums;
        this.numbers = new ArrayList<>();
        for (int num: nums){
            numbers.add(num);
        }
    }
    
    public int add(int val) {
        numbers.add(val);
        return findKthLargest(numbers);
    }
    public int findKthLargest(List<Integer> numbers){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < k; i++){
            minHeap.add(numbers.get(i));
        }
        for (int i = k; i < numbers.size(); i++){
            if (numbers.get(i) > minHeap.peek()){
                minHeap.remove();
                minHeap.add(numbers.get(i));
            }
        }
        return minHeap.peek();
    }
}
