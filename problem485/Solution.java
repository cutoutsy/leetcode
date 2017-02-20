public class Solution {
    public int findMaxConsecutiveOnes(int[] nums){
        int result = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                result++;
            }else if(nums[i] == 0){
                if(result > max) {
                    max = result;
                }
                result = 0;
            }
        }
        return max > result ? max:result;
    }

    public static void main(String[] args){
        int[] input = {1, 1, 0, 1, 1, 1};
//        int[] input = {1, 0, 1, 1, 0, 1};
        Solution solution = new Solution();
        int result = solution.findMaxConsecutiveOnes(input);
        System.out.println(result);
    }
}
