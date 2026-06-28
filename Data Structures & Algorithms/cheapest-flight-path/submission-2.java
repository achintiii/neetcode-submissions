class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // this is a custom BFS, in order to keep track of the path length(stops), bfs is essential
        // form an edge list and use a queue
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < flights.length; i++){
            if (!map.containsKey(flights[i][0])){
                map.put(flights[i][0], new ArrayList<>());
                map.get(flights[i][0]).add(new int[] {flights[i][1], flights[i][2]});
            }
            else {
                map.get(flights[i][0]).add(new int[] {flights[i][1], flights[i][2]});
            }
        }
        // adjacency list is now populated, use custom bfs
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));
        // each object in the queue contains the current destination, total cost, and total stops so far
        minHeap.add(new int[] {src, 0, 0});
        int[] prices = new int[n];
        for (int i = 0; i < prices.length; i++){
            if (i == src){
                prices[i] = 0;
            }
            else {
                prices[i] = Integer.MAX_VALUE;
            }
        }
        int answer = -1;
        while (!minHeap.isEmpty()){
            int[] flightPath = minHeap.remove();
            int currentAirport = flightPath[0];
            int currentCost = flightPath[1];
            int currentStops = flightPath[2];
            if (currentAirport == dst) {
               return currentCost;
            }
            for (int[] path: map.getOrDefault(currentAirport, new ArrayList<>())){
                int nextAirport = path[0];
                int price = path[1];
                int newCost = currentCost + price;
                if (currentStops <= k){
                    
                        if (newCost < prices[nextAirport]) {
                            prices[nextAirport] = newCost;
                        }
                        minHeap.add(new int[] {nextAirport, newCost, currentStops + 1});
                    
                }

            }

        }
        return answer;
    }
}
