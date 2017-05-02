public class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c){
        if(nums.length*nums[0].length != c*r) return nums;
        int[][] result = new int[r][c];
        int[] oneDimensionalArray = new int[r*c];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                oneDimensionalArray[index++] = nums[i][j];
            }
        }
        int row = 0;
        int column = 0;
        for (int i = 0; i < oneDimensionalArray.length; i++) {
            if((i+1)%c == 0){
                result[row][column++] = oneDimensionalArray[i];
                row++;
                column = 0;
            }else{
                result[row][column++] = oneDimensionalArray[i];
            }
        }
        return result;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[][] nums = {{1,2}, {3, 4}};
        int[][] result = solution.matrixReshape(nums, 4, 1);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }
}
