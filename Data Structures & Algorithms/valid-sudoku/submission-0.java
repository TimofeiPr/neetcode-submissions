class Solution {
    public boolean isValidSudoku(char[][] board) {
      HashSet<Character> row = new HashSet<Character>();

      for (int i = 0; i < 9; i++) {
        row.clear();
        for (int j = 0; j < 9; j++) {
            if (board[i][j] == '.') {
                continue;
            } else {
                if (row.contains(board[i][j])) {
                    return false;
                } else {
                    row.add(board[i][j]);
                }
            }
        } 
      }
      for (int i = 0; i < 9; i++) {
        row.clear();
        for (int j = 0; j < 9; j++) {
            if (board[j][i] == '.') {
                continue;
            } else {
                if (row.contains(board[j][i])) {
                    return false;
                } else {
                    row.add(board[j][i]);
                }
            }
        } 
      }
      for (int line = 0; line < 3; line++) {
        for (int square = 0; square < 3; square++) {
            row.clear();
            for (int i = (3*line); i < ((3*line) + 3); i++) {
                for (int j = (3*square); j < ((3*square) + 3); j++) {
                    if (board[i][j] == '.') {
                        continue;
                    } else {
                        if (row.contains(board[i][j])) {
                            return false;
                        } else {
                            row.add(board[i][j]);
                        }
                    }
                } 
            }
        }
      }
      return true;
    }
}
