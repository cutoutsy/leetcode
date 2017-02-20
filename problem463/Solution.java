public class Solution {
    public int islandPerimeter(int[][] grid){
        int result = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1){
                    if(i==0){
                        result++;
                    }
                    if(i == grid.length-1){
                        result++;
                    }
                    if(j==0){
                        result ++;
                    }
                    if(j==grid[i].length-1){
                        result++;
                    }
                    if (i != 0 && grid[i - 1][j] == 0){
                        result++;
                    }
                    if(j != 0 && grid[i][j - 1] == 0){
                        result++;
                    }
                    if(j !=grid[i].length-1 && grid[i][j + 1] == 0){
                        result++;
                    }
                    if(i !=grid.length-1 && grid[i + 1][j] == 0){
                        result++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        int[][] input = {{0,1,0,0}, {1,1,1,0}, {0,1,0,0}, {1,1,0,0}};
//        int[][] input = {{1}};
        Solution solution = new Solution();
        int result = solution.islandPerimeter(input);
        System.out.println(result);
    }
}
