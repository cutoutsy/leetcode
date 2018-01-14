import java.util.Arrays;

public class Solution {
    public int dominantIndex(int[] nums) {
        int max = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        Arrays.sort(nums);
        for (int i = nums.length - 2; i > -1; i--) {
            if (2 * nums[i] >= nums[nums.length - 1]) {
                return -1;
            } else {
                break;
            }
        }
        return index;
    }

    public int dominantIndex1(int[] nums) {
        int max = 0;
        int secondMax = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                secondMax = max;
                max = nums[i];
                index = i;
            } else if (nums[i] > secondMax) {
                secondMax = nums[i];
            }
        }
        return max >= 2*secondMax ? index : -1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 6, 1, 0};
        int[] nums1 = {1, 2, 3, 4};
        Solution solution = new Solution();
        System.out.println(solution.dominantIndex1(nums));
        System.out.println(solution.dominantIndex1(nums1));
    }
}
