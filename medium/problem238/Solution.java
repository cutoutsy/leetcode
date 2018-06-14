class Solution {
    public int[] productExceptSelf(int[] nums) {
        int m = nums.length;
        int[] left = new int[m];
        int[] right = new int[m];
        
        for (int i = 0; i < m; i++) {
            left[i] = nums[i] * (i == 0 ? 1 : left[i-1]);
        }
        for (int i = m -1; i > -1; i--) {
            right[i] = nums[i] * (i == (m -1) ? 1 : right[i+1]);
        }
        nums[0] = right[1];
        nums[m-1] = left[m-2];
        for (int i = 1; i < m-1; i++) {
            nums[i] = left[i-1] * right[i+1];
        }
        return nums;
    }
}