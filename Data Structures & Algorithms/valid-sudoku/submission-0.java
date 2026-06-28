    class Solution {
        public boolean isValidSudoku(char[][] board) {
            Map<Integer, Set<Integer>> rowMap = new HashMap<>();
            Map<Integer, Set<Integer>> colMap = new HashMap<>();
            Map<Integer, Set<Integer>> squareMap = new HashMap<>();
            for (int i = 0; i < board.length; i++){
                for (int j = 0; j < board.length; j++){
                    if (board[i][j] == '.'){
                        continue;
                    }
                    int num = board[i][j] - '0';
                    if (!rowMap.containsKey(i)){
                        rowMap.put(i, new HashSet<>());
                    }
                    if (rowMap.get(i).contains(num)){
                        return false;
                    }
                    rowMap.get(i).add(num);
                    if (!colMap.containsKey(j)){
                        colMap.put(j, new HashSet<>());
                    }
                    if (colMap.get(j).contains(num)){
                        return false;
                    }
                    colMap.get(j).add(num);
                    int square = (i / 3) * 3 + j / 3;
                    if (!squareMap.containsKey(square)){
                        squareMap.put(square, new HashSet<>());
                    }
                    if (squareMap.get(square).contains(num)){
                        return false;
                    }
                    squareMap.get(square).add(num);
                }
            }
            return true;
        }
    }

