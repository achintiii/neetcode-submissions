class Solution {
    public void solve(char[][] board) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < board.length; i++){
            if (board[i][0] == 'O'){
                queue.add(new int[] {i, 0});
            }
            if (board[i][board[0].length - 1] == 'O'){
                queue.add(new int[] {i, board[0].length - 1});
            }
        }
        for (int i = 0; i < board[0].length; i++){
            if (board[0][i] == 'O'){
                queue.add(new int[] {0, i});
            }
            if (board[board.length - 1][i] == 'O'){
                queue.add(new int[] {board.length - 1, i});
            }
        }
        int[] rowDirections = new int[] {-1,1,0,0};
        int[] colDirections = new int[] {0,0,1,-1};

        while (!queue.isEmpty()){
            int[] cell = queue.remove();
            int row = cell[0];
            int col = cell[1];
            board[row][col] = 'T';
            for (int i = 0; i < rowDirections.length; i++){
                int newRow = row + rowDirections[i];
                int newCol = col + colDirections[i];
                if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length && board[newRow][newCol] == 'O'){
                    queue.add(new int[] {newRow, newCol});
                }
            }
        }

        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'T'){
                    board[i][j] = 'O';
                }
            }
        }
        
    }
}
