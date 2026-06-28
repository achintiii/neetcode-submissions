class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b, a));
        for (int stone: stones){
            maxHeap.add(stone);
        }
        while (maxHeap.size() >= 2){
            int val1 = maxHeap.remove();
            int val2 = maxHeap.remove();
            if (val1 == val2){
                continue;
            }
            else {
                maxHeap.add(val1 - val2);
            }
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}
