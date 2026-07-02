class Solution {
    int components = 0;
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }
        boolean[] visited = new boolean[n];
        for (int[] edge: edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        for (int node = 0; node < n; node ++){
            if (!visited[node]){
                dfs(node, adjList, visited);
                components ++;
            }
            
        }
        return components;

    }
    private void dfs(int node, List<List<Integer>> adjList, boolean[] visited){
        visited[node] = true;
        for (int neighbor: adjList.get(node)){
            if (!visited[neighbor]){
                dfs(neighbor, adjList, visited);
            }
        }
    }
}
