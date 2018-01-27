import java.util.Arrays;

public class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] ans = new int[2];
        int[] exist = new int[nums.length];
        for (int n : nums) {
            exist[n - 1]++;
        }
        for (int i = 0; i < exist.length; i++) {
            if (exist[i] == 2) {
                ans[0] = i + 1;
            } else if (exist[i] == 0) {
                ans[1] = i + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 2};
        System.out.println(Arrays.toString(solution.findErrorNums(nums)));
    }
}
