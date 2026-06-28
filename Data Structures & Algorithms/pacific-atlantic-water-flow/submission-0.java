class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        
        Queue<int[]> pacificQ = new LinkedList<>();
        Queue<int[]> atlanticQ = new LinkedList<>();
        
        // Initialize border cells
        for (int i = 0; i < m; i++) {
            pacificQ.add(new int[]{i, 0});
            atlanticQ.add(new int[]{i, n-1});
            pacific[i][0] = true;
            atlantic[i][n-1] = true;
        }
        for (int j = 0; j < n; j++) {
            pacificQ.add(new int[]{0, j});
            atlanticQ.add(new int[]{m-1, j});
            pacific[0][j] = true;
            atlantic[m-1][j] = true;
        }
        
        // Run BFS for each ocean
        bfs(heights, pacificQ, pacific);
        bfs(heights, atlanticQ, atlantic);
        
        // Collect results
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }
    
    private void bfs(int[][] heights, Queue<int[]> q, boolean[][] visited) {
        int m = heights.length, n = heights[0].length;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        
        while (!q.isEmpty()) {
            int[] cell = q.remove();
            int r = cell[0], c = cell[1];
            
            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                if (visited[nr][nc]) continue;
                // Reverse flow: only go to neighbor if its height >= current
                if (heights[nr][nc] >= heights[r][c]) {
                    visited[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                }
            }
        }
    }
}