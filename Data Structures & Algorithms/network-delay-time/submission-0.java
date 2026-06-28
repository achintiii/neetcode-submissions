class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // implement dijkstra and take the max shortest path
        Map<Integer, List<int[]>> edges = new HashMap<>();
        for (int i = 0; i < n; i++){
            edges.put(i + 1, new ArrayList<>());

        }
        for (int[] time: times){
            int source = time[0];
            int destination = time[1];
            int travelTime = time[2];
            edges.get(source).add(new int[] {destination, travelTime});
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        minHeap.add(new int[] {0, k});
        Set<Integer> visited = new HashSet<>();
        int result = 0;
        while (!minHeap.isEmpty()){
            int[] cur = minHeap.remove();
            int curNode = cur[1];
            int distance = cur[0];
            
            if (visited.contains(curNode)){
                continue;
            }
            if (distance > result){
                result = distance;
            }
            visited.add(curNode);
            if (edges.containsKey(curNode)){
                for (int[] neighbor: edges.get(curNode)){
                    int nextDistance = neighbor[1] + distance;
                    minHeap.add(new int[] {nextDistance, neighbor[0]});
                }
            }
        }
        return visited.size() == n ? result : -1;

    }

}
