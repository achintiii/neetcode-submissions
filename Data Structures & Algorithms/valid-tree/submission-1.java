class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        if (edges.length != n-1){
            return false;
        }
        for (int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }
        for (int[] edge: edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        Set<Integer> visited = new HashSet<>();
        return dfs(adjList, visited, 0, -1);
    }
    public boolean dfs(List<List<Integer>> adjList, Set<Integer> visited, Integer node, Integer parent){
        if (visited.contains(node)){
            // graph has a cycle so not a valid tree, return false
            return false;
        }
        visited.add(node);
        for (int i = 0; i < adjList.get(node).size(); i++){
            if (adjList.get(node).get(i) == parent){
                continue;
            }
            if (!dfs(adjList, visited, adjList.get(node).get(i), node)){
                return false;
            }
        }
        return true;
    }
}
