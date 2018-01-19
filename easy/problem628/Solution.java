import java.util.Arrays;

public class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int ans1 = nums[0]*nums[1]*nums[nums.length - 1];
        int ans2 = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
        return Math.max(ans1, ans2);
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 1, 2};
        Solution solution = new Solution();
        System.out.println(solution.maximumProduct(nums));
    }
}
