class Solution {
    Set<Integer> visited = new HashSet<>();
    public int countComponents(int n, int[][] edges) {
        
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }
        for (int[] edge: edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        int connectedComponents = 0;
        for (int i = 0; i < n; i++){
            if (!visited.contains(i)){
                dfs(i, visited, adjList);
                connectedComponents ++;
            }
            
        }
        return connectedComponents;
        
    }
    private void dfs(int node, Set<Integer> visited, List<List<Integer>> adjList){
        visited.add(node);
        for (int i = 0; i < adjList.get(node).size(); i++){
            if (!visited.contains(adjList.get(node).get(i))){
                visited.add(adjList.get(node).get(i));
                dfs(adjList.get(node).get(i), visited, adjList);
            }
        }
    }
}
