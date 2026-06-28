class Solution {
    public int orangesRotting(int[][] grid) {
        int numFresh = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 1){
                    numFresh ++;
                }
            }
        }
        if (numFresh == 0){
            return 0;
        }
        int time = 0;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 2){
                    queue.add(new int[] {i, j});
                }
            }
        }
        while (!queue.isEmpty()){
            boolean hasRotted = false;
            int size = queue.size();
            for (int i = 0; i < size; i++){
                int[] cell = queue.remove();
                int row = cell[0];
                int col = cell[1];
                visited[row][col] = true;
                if (row + 1 < grid.length && !visited[row + 1][col] && grid[row + 1][col] == 1){
                    grid[row + 1][col] = 2;
                    visited[row + 1][col] = true;
                    numFresh --;
                    hasRotted = true;
                    queue.add(new int[] {row + 1, col});
                }
                if (row - 1 >= 0 && !visited[row - 1][col] && grid[row - 1][col] == 1){
                    grid[row - 1][col] = 2;
                    visited[row - 1][col] = true;
                    numFresh --;
                    hasRotted = true;
                    queue.add(new int[] {row - 1, col});
                }
                if (col + 1 < grid[0].length && !visited[row][col + 1] && grid[row][col + 1] == 1){
                    grid[row][col + 1] = 2;
                    visited[row][col + 1] = true;
                    numFresh --;
                    hasRotted = true;
                    queue.add(new int[] {row, col + 1});
                }
                if (col - 1 >= 0 && !visited[row][col - 1] && grid[row][col - 1] == 1){
                    grid[row][col - 1] = 2;
                    visited[row][col - 1] = true;
                    numFresh --;
                    hasRotted = true;
                    queue.add(new int[] {row, col - 1});
                }
                
            }
            
            if (hasRotted){
                time ++;
            }
        }
       return numFresh == 0 ? time : -1;
    }
}
