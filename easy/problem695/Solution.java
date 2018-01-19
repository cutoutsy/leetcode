import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int ans = 0;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    int res = calc(grid, i, j, visited);
                    ans = Math.max(ans, res);
                }
            }
        }
        return ans;
    }

    private int calc(int[][] grid, int i, int j, boolean[][] visited) {
        int ans = 0;
        Queue<Integer> rQ = new LinkedList<Integer>();
        Queue<Integer> cQ = new LinkedList<Integer>();
        rQ.add(i);
        cQ.add(j);
        int r = 0;
        int c = 0;
        while (!rQ.isEmpty()) {
            r = rQ.poll();
            c = cQ.poll();
            ans++;
            walkTo(grid, r - 1, c, visited, ans, rQ, cQ);
            walkTo(grid, r + 1, c, visited, ans, rQ, cQ);
            walkTo(grid, r, c - 1, visited, ans, rQ, cQ);
            walkTo(grid, r, c + 1, visited, ans, rQ, cQ);
        }
        return ans;
    }

    private void walkTo(int[][] grid, int toR, int toC, boolean[][] visited, int ans, Queue<Integer> rQ, Queue<Integer> cQ) {
        if (toR < 0 || toC < 0 || toR == grid.length || toC == grid[0].length || grid[toR][toC] == 0 || visited[toR][toC]) {
            return;
        }
        visited[toR][toC] = true;
        rQ.add(toR);
        cQ.add(toC);
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 0, 0}, {1, 1, 0, 0}, {0, 0, 1, 1}, {0, 0, 1, 1}};
        Solution solution = new Solution();
        System.out.println(solution.maxAreaOfIsland1(grid));
    }
}
