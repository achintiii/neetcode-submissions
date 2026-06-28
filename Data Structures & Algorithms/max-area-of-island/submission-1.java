class Solution {
    int maxArea = 0;
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 1){
                    int curArea = bfs(grid, i, j, visited);
                    if (curArea > maxArea){
                        maxArea = curArea;
                    }
                }
            }
        }
        return maxArea;
    }
    private int bfs(int[][] grid, int row, int col, boolean[][] visited){
        int area = 0;
        visited[row][col] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {row, col});
        while (!queue.isEmpty()){
            int[] cell = queue.remove();
            visited[cell[0]][cell[1]] = true;
            area ++;
            List<int[]> neighbors = getNeighbors(grid, cell[0], cell[1], visited);
            for (int[] neighbor: neighbors){
                visited[neighbor[0]][neighbor[1]] = true;
                grid[neighbor[0]][neighbor[1]] = -1;
                queue.add(neighbor);
            }
        }
        return area;
    }
    List<int[]> getNeighbors(int[][] grid, int row, int col, boolean[][] visited){
        List<int[]> result = new ArrayList<>();
        if (row + 1 < grid.length && !visited[row + 1][col] && grid[row + 1][col] == 1){
            result.add(new int[] {row + 1, col});
        }
        if (row - 1  >= 0 && !visited[row - 1][col] && grid[row - 1][col] == 1){
            result.add(new int[] {row - 1, col});
        }
        if (col + 1 < grid[0].length && !visited[row][col + 1] && grid[row][col + 1] == 1){
            result.add(new int[] {row, col + 1});
        }
        if (col - 1 >= 0 && !visited[row][col - 1] && grid[row][col - 1] == 1){
            result.add(new int[] {row, col - 1});
        }
        return result;
    }
}
