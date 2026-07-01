class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int numFresh = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 1){
                    numFresh ++;
                }
                if (grid[i][j] == 2){
                    queue.add(new int[] {i, j});
                }
            }
        }
        int minutes = 0;
        int[] rowDirections = new int[] {-1,1,0,0};
        int[] colDirections = new int[] {0, 0, -1, 1};
        while (!queue.isEmpty() && numFresh > 0){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                int[] cell = queue.remove();
                int row = cell[0];
                int col = cell[1];
                for (int j = 0; j < rowDirections.length; j++){
                    int newRow = row + rowDirections[j];
                    int newCol = col + colDirections[j];
                    if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && grid[newRow][newCol] == 1){
                        numFresh --;
                        grid[newRow][newCol] = 2;
                        queue.add(new int[] {newRow, newCol});
                    }
                }

            }
            minutes ++;
            
            
        }
        if (numFresh != 0){
            return -1;
        }
        return minutes;
    }
}
