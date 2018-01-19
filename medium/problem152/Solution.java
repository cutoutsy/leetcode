public class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0 || nums == null) return 0;
        int ans = nums[0];
        int[] maxCache = new int[nums.length];
        int[] minCache = new int[nums.length];
        maxCache[0] = minCache[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxCache[i] = minCache[i] = nums[i];
            if (nums[i] > 0) {
                maxCache[i] = Math.max(maxCache[i], maxCache[i - 1] * nums[i]);
                minCache[i] = Math.min(minCache[i], minCache[i - 1] * nums[i]);
            } else if(nums[i] < 0) {
                maxCache[i] = Math.max(maxCache[i], minCache[i - 1] * nums[i]);
                minCache[i] = Math.min(minCache[i], maxCache[i - 1] * nums[i]);
            }
            ans = Math.max(ans, maxCache[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        Solution solution = new Solution();
        System.out.println(solution.maxProduct(nums));
    }
}
