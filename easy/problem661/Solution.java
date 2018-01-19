public class Solution {
    public int[][] imageSmoother(int[][] M) {
        if (M == null) return null;
        int rows = M.length;
        if (rows == 0) return new int[0][];
        int cols = M[0].length;

        int ans[][] = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int count = 0;
                int aroundSum = 0;
                for (int incR : new int[]{-1, 0, 1}) {
                    for (int incC : new int[]{-1, 0, 1}) {
                        if(isValid(i + incR, j + incC, rows, cols)){
                            count++;
                            aroundSum += M[i + incR][j + incC];
                        }
                    }
                }
                ans[i][j] = aroundSum / count;
            }
        }
        return ans;
    }

    private boolean isValid(int x, int y, int rows, int cols){
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}
