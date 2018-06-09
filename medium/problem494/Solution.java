class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        return process(nums, S, 0, 0);
    }
    
    public int process(int[] nums, int S, int total, int index) {
        if (index == nums.length) {
            if (total == S) {
                return 1;
            } 
            return 0;
        }
        int ans = 0;
        ans += process(nums, S, total + nums[index], index + 1);
        ans += process(nums, S, total - nums[index], index + 1);
        return ans;
    }
}