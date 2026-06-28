class Solution {
    int numIslands = 0;
    boolean[][] visited;
    public int numIslands(char[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == '1'){
                    numIslands ++;
                    bfs(grid, i, j, visited);
                }
            }
        }
        return numIslands;

        
    }
    public void bfs(char[][] grid, int row, int col, boolean[][] visited){
        visited[row][col] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {row, col});
        while (!queue.isEmpty()){
            int[] cell = queue.remove();
            visited[cell[0]][cell[1]] = true;
            grid[cell[0]][cell[1]] = '*';
            List<int[]> neighbors = getNeighbors(grid, cell[0], cell[1]);
            for (int[] neighbor: neighbors){
                queue.add(neighbor);
            }
        }

    }
    public List<int[]> getNeighbors(char[][] grid, int row, int col){
        List<int[]> result = new ArrayList<>();
        if (row - 1 >= 0 && !visited[row - 1][col] && grid[row - 1][col] == '1'){
            result.add(new int[] {row - 1, col});
        }
        if (row + 1 < grid.length && !visited[row + 1][col] && grid[row + 1][col] == '1'){
            result.add(new int[] {row + 1, col});
        }
        if (col - 1 >= 0 && !visited[row][col - 1] && grid[row][col - 1] == '1'){
            result.add(new int[] {row, col- 1});
        }
        if (col + 1 < grid[0].length && !visited[row][col + 1] && grid[row][col + 1]== '1'){
            result.add(new int[] {row, col + 1});
        }
        return result;
    }
    
}
