class Solution {
    public int leastInterval(char[] tasks, int n) {
        // semi greedy, always execute the most optimal task
        // push to the heap everything first
        int[] freq = new int[26];
        for (char ch: tasks){
            freq[ch - 'A'] ++;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        for (int count: freq){
            if (count > 0){
                maxHeap.add(count);
            }
        }
        int time = 0;
        Queue<int[]> queue = new LinkedList<>();
        while (!maxHeap.isEmpty() || !queue.isEmpty()){
            time ++;
            if (maxHeap.isEmpty()){
               time = queue.peek()[1];
            }
            else {
                int count = maxHeap.remove();
                count --;
                if (count > 0){
                    queue.add(new int[] {count, time + n});
                }
            }
            while (!queue.isEmpty() && queue.peek()[1] == time) {
                maxHeap.add(queue.remove()[0]);
            }
            
            
        }
        return time;

    }
}
