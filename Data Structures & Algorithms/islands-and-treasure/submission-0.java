class Solution {
    public void islandsAndTreasure(int[][] grid) {
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == Integer.MAX_VALUE){
                    bfs(grid, i, j);
                }
            }
        }
    }
    public void bfs(int[][] grid, int row, int col){
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int level = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {row, col});
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                int[] point = queue.remove();
                int newRow = point[0];
                int newCol = point[1];
                if (grid[newRow][newCol] == 0){
                    grid[row][col] = level;
                    return;
                }
                if (newRow + 1 < grid.length && !visited[newRow + 1][newCol] && grid[newRow + 1][newCol] != -1){
                    queue.add(new int[] {newRow + 1, newCol});
                    visited[newRow + 1][newCol] = true;
                }
                if (newRow - 1 >= 0 && !visited[newRow - 1][newCol] && grid[newRow - 1][newCol] != -1){
                    queue.add(new int[] {newRow - 1, newCol});
                    visited[newRow - 1][newCol] = true;
                }
                if (newCol + 1 < grid[0].length && !visited[newRow][newCol + 1] && grid[newRow][newCol + 1] != -1){
                    queue.add(new int[] {newRow, newCol + 1});
                    visited[newRow][newCol + 1] = true;
                }
                if (newCol - 1 >= 0 && !visited[newRow][newCol - 1] && grid[newRow][newCol - 1] != -1){
                    queue.add(new int[] {newRow, newCol - 1});
                    visited[newRow][newCol - 1] = true;
                }

            }
            level ++;
        }
        
    }
}
