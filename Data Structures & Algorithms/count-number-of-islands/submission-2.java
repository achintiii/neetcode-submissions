class Solution {
    int numIslands = 0;
    public int numIslands(char[][] grid) {
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == '1'){
                    numIslands ++;
                    bfs(grid, i, j);
                }
            }
        }
        return numIslands;
    }
    private void bfs(char[][] grid, int i, int j){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {i, j});
        int[] rowDirections = new int[] {1, -1, 0, 0};
        int[] colDirections = new int[] {0, 0, 1, -1};
        while (!queue.isEmpty()){
            int[] cell = queue.remove();
            int row = cell[0];
            int col = cell[1];
            grid[cell[0]][cell[1]] = '.';
            for (int k = 0; k < rowDirections.length; k++){
                int newRow = row + rowDirections[k];
                int newCol = col + colDirections[k];
                if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && grid[newRow][newCol] == '1'){
                    queue.add(new int[] {row + rowDirections[k], col + colDirections[k]});
                }
            }

        }
    }
}
