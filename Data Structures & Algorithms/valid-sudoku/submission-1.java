class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Integer>> rowMap = new HashMap<>();
        Map<Integer, Set<Integer>> colMap = new HashMap<>();
        Map<Integer, Set<Integer>> sqMap = new HashMap<>();
        


        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] != '.'){
                    int cur = Character.getNumericValue(board[i][j]);
                    int row = i;
                    int col = j;
                    int sq = 3 * (row / 3) + (col / 3);
                    rowMap.putIfAbsent(row, new HashSet<>());
                    colMap.putIfAbsent(col, new HashSet<>());
                    sqMap.putIfAbsent(sq, new HashSet<>());
                    
                    if (rowMap.get(row).contains(cur) || colMap.get(col).contains(cur) || sqMap.get(sq).contains(cur)){
                        return false;
                    }
                    rowMap.get(row).add(cur);
                    colMap.get(col).add(cur);
                    sqMap.get(sq).add(cur);

                }
            }
        }
        return true;
    }
}
