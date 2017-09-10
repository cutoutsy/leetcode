public class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0 || nums == null) return 0;
        int ans = 0;
        int count = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                count++;
            } else {
                if (count > ans) {
                    ans = count;
                }
                count = 1;
            }
        }
        return Math.max(ans, count);
    }

    public static void main(String[] args) {
        int[] input1 = {1, 3, 5, 7};
        int[] input2 = {2, 2, 2, 2};
        Solution solution = new Solution();
        System.out.println(solution.findLengthOfLCIS(input1));
        System.out.println(solution.findLengthOfLCIS(input2));
    }
}
