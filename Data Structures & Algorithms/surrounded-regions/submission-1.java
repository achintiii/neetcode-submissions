class Solution {
    public void solve(char[][] board) {
        // dfs for borders
        for (int i = 0; i < board[0].length; i++){
            dfs(board, 0, i);
            dfs(board, board.length - 1, i);
        }
        for (int i = 0; i < board.length; i++){
            dfs(board, i, 0);
            dfs(board, i, board[0].length - 1);
        }
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == 'T'){
                    board[i][j] = 'O';
                }
            }
        }

    }
    private void dfs(char[][] board, int row, int col){
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != 'O'){
            return;
        }
        board[row][col] = 'T';
        int[] rowDirections = new int[] {-1, 1, 0, 0};
        int[] colDirections = new int[] {0,0,1,-1};
        for (int i = 0; i < rowDirections.length; i++){
            int newRow = row + rowDirections[i];
            int newCol = col + colDirections[i];
            dfs(board, newRow, newCol);
            
        }
    }
}
