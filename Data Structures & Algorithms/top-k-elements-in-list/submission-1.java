class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b[1], a[1]));
        for (Integer val: map.keySet()){
            maxHeap.add(new int[] {val, map.get(val)});
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++){
            result[i] = maxHeap.remove()[0];
        }
        return result;
    }

}
