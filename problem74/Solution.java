public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int up = 0;
        int down = m - 1;
        int left = 0;
        int right = n; //存在只有一列的情况，所以这块不能为n-1

        //二分查找所在行
        while (up < down){
            int mid = (down + up)/2;
            if(matrix[mid][n-1] > target) down = mid;
            else if(matrix[mid][n-1] < target) up = mid+1;
            else return true;
        }

        //二分查找所在列
        while (left < right){
            int mid = (left + right) / 2;
            if (matrix[up][mid] > target) right = mid;
            else if(matrix[up][mid] < target) left = mid + 1;
            else return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,3,5,7}, {10,11,16,20}, {23,30,34,50}};
        Solution solution = new Solution();
        System.out.println(solution.searchMatrix(matrix, 3));
    }
}
