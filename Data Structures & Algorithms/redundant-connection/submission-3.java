class Solution {
    public int find(int[] par, int n){
            
            if (par[n] != n){
                par[n] = find(par, par[n]);
            }
            return par[n];   
    }
    private boolean union(int[] par, int n1, int n2, int[] rank){
        int p1 = find(par, n1);
        int p2 = find(par, n2);
        if (p1 == p2){
            return false;
        }
        if (rank[p1] > rank[p2]){
            par[p2] = p1;
            rank[p1] += rank[p2];
        }
        else {
            par[p1] = p2;
            rank[p2] += rank[p1];
        }
        return true;

    }
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1];
        int[] rank = new int[edges.length + 1];
        for (int i = 0; i < parent.length; i++){
            parent[i] = i;
            rank[i] = 1;
        }
        for (int[] edge: edges){
            if (!union(parent, edge[0], edge[1], rank)){
                return new int[] {edge[0], edge[1]};
            }
        }
        return new int[0];
        
    }
}
