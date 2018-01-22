public class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int tR = m - 1;
        int tC = 0;
        int dR = m - 1;
        int dC = 0;
        while (tC != n) {
            if (!check(matrix, tR, tC, dR, dC)) {
                return false;
            }
            tC = tR == 0 ? tC + 1 : tC;
            tR = tR == 0 ? 0 : tR - 1;
            dR = dC == n -1 ? dR - 1 : dR;
            dC = dC == n - 1 ? dC : dC + 1;
        }
        return true;
    }

    private boolean check(int[][] matrix, int tR, int tC, int dR, int dC) {
        int num = matrix[tR][tC];
        while (tR != dR + 1) {
            if (matrix[tR++][tC++] != num){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}};
        Solution solution = new Solution();
        System.out.println(solution.isToeplitzMatrix(matrix));
    }
}
