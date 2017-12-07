import java.util.Arrays;

public class Solution {
    public int findLHS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int ans = 0;
        Arrays.sort(nums);
        int pre = 1;
        int cur = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1] && cur == 0) {
                pre++;
            } else if (nums[i] == nums[i + 1] && cur != 0){
                cur++;
            } else if (nums[i] + 1 == nums[i + 1] && cur == 0){
                cur = 1;
            } else if (nums[i] + 1 == nums[i + 1] && cur != 0){
                ans = Math.max(ans, cur + pre);
                pre = cur;
                cur = 1;
            } else {
                if (cur != 0) {
                    ans = Math.max(ans, cur + pre);
                }
                pre = 1;
                cur = 0;
            }
        }
        if (cur != 0) {
            ans = Math.max(ans, cur + pre);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 2, 5, 2, 3, 7};
        Solution solution = new Solution();
        System.out.println(solution.findLHS(nums));
    }
}
