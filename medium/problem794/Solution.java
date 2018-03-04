public class Solution {
    public boolean validTicTacToe(String[] board) {
        // 转化为二维字符数组
        char[][] boardChar = new char[3][3];
        for (int i = 0; i < board.length; i++) {
            boardChar[i] = board[i].toCharArray();
        }
        int countX = 0;
        int countO = 0;
        for (int i = 0; i < boardChar.length; i++) {
            for (int j = 0; j < boardChar[i].length; j++) {
                if (boardChar[i][j] == 'X') {
                    countX++;
                } else if (boardChar[i][j] == 'O') {
                    countO++;
                }
            }
        }
        if (countO > countX || countX - countO > 1) {
            return false;
        }
        if (countX - countO == 1) {
            if(!helper(boardChar, 'O')) {
                return false;
            }
        } else if (countX == countO) {
            if(!helper(boardChar, 'X')) {
                return false;
            }
        }

        return true;
    }

    private boolean helper(char[][] boardChar, char ch) {
        for (int i = 0; i < 3; i++) {
            if (boardChar[i][0] == ch && boardChar[i][0] == boardChar[i][1] && boardChar[i][1] == boardChar[i][2]) {
                return false;
            }
            if (boardChar[0][i] == ch && boardChar[0][i] == boardChar[1][i] && boardChar[1][i] == boardChar[2][i]) {
                return false;
            }
        }
        if (boardChar[0][0] == ch && boardChar[0][0] == boardChar[1][1] && boardChar[1][1] == boardChar[2][2]) {
            return false;
        }
        if (boardChar[0][2] == ch && boardChar[0][2] == boardChar[1][1] && boardChar[1][1] == boardChar[2][0]) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] board = {"OXX", "XOX", "OXO"};
        System.out.println(solution.validTicTacToe(board));
    }
}
