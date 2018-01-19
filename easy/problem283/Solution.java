public class Solution {
    public void moveZeroes(int[] nums){
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if(nums[i] == 0){
                for (int j = i; j < len-1; j++) {
                    nums[j] = nums[j+1];
                }
                nums[len-1] = 0;
                i--;
                len--;
            }
        }
    }

    public static void main(String[] args){
        int[] nums = {0, 1, 0, 3, 12};
        Solution solution = new Solution();
        solution.moveZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
        System.out.println();
    }
}
