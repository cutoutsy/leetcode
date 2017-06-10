public class Solution {
    public int maxCount(int m, int n, int[][] ops){
        if (ops.length == 0) return m*n;
        int minX = n;
        int minY = m;
        for (int i = 0; i < ops.length; i++) {
            if (ops[i][0] < minY) minY = ops[i][0];
            if (ops[i][1] < minX) minX = ops[i][1];
        }
        return minX*minY;
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        int[][] ops = {{2, 2}, {3, 3}};
        Solution solution = new Solution();
        System.out.println(solution.maxCount(m, n, ops));
    }
}
