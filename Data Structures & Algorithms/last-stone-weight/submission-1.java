class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        for (int stone: stones){
            heap.add(stone);
        }
        while (heap.size() >= 2){
            int stone1 = heap.remove();
            int stone2 = heap.remove();
            if (stone1 == stone2){
                continue;
            }
            else {
                heap.add(stone1 - stone2);
            }
        }
        return heap.isEmpty() ? 0 : heap.remove();
    }
}
