import java.util.*;

public class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    Map<Integer, Integer> map = new HashMap<>();
    int min_move = Integer.MAX_VALUE;

    public int slidingPuzzle(int[][] board) {
        if (!isValid(board)) {
            return -1;
        }
        map.put(123450, 0);
        int[] zero = new int[2];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) {
                    zero[0] = i;
                    zero[1] = j;
                    break;
                }
            }
        }
        helper(board, zero[0], zero[1], 0);
        return min_move;
    }

    private void helper(int[][] board, int x, int y, int move) {
        if (move > min_move) {
            return;
        }
        int code = encode(board);
        if (code == 123450) {
            min_move = move;
            return;
        }
        if (map.containsKey(code)) {
            if (move > map.get(code)) {
                return;
            }
        }
        map.put(code, move);
        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx >= 0 && nx < 2 && ny >= 0 && ny < 3) {
                swap(board, x, y, nx, ny);
                helper(board, nx, ny, move + 1);
                swap(board, nx, ny, x, y);
            }
        }
    }

    private void swap(int[][] board, int x, int y, int nx, int ny) {
        int temp = board[x][y];
        board[x][y] = board[nx][ny];
        board[nx][ny] = temp;
    }

    public int encode(int[][] nums) {
        int code = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                code *= 10;
                code += nums[i][j];
            }
        }
        return code;
    }

    public boolean isValid(int[][] nums) {
        int[] pre = new int[5];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                if (nums[i][j] != 0) {
                    pre[index++] = nums[i][j];
                }
            }
        }
        int a = 0;
        for (int i = 0; i < pre.length - 1; i++) {
            for (int j = i+1; j < pre.length; j++) {
                if (pre[i] > pre[j]) {
                    a++;
                }
            }
        }
        return (a & 1) != 1;
    }
}
