public class Solution {
    public int singleNumber(int[] nums){
        int result = 0;
        for (int i = 0; i < nums.length; i++){
            result ^= nums[i];
        }
        return result;
    }

    public static void main(String[] args){
        int[] input = {7, 3, 7, 9, 2, 9, 2};
        Solution solution = new Solution();
        System.out.println(solution.singleNumber(input));
    }
}