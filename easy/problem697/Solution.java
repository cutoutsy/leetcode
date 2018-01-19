public class Solution {
    public int findShortestSubArray(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int minLength = 50000;
        int currLength;
        int maxFrequency = 0;
        int[] frequency =new int[50001];
        int[] pos = new int[50001];

        for (int i = 1; i < nums.length + 1; i++) {
            if (pos[nums[i - 1]] != 0) {
                frequency[nums[i - 1]]++;
                currLength = i - pos[nums[i - 1]] + 1;
                if (frequency[nums[i - 1]] > maxFrequency) {
                    maxFrequency = frequency[nums[i - 1]];
                    minLength = currLength;
                } else if (frequency[nums[i - 1]] == maxFrequency) {
                    minLength = Math.min(minLength, currLength);
                }
            } else {
                pos[nums[i - 1]] = i;
            }
        }
        if (maxFrequency == 0) {
            return 1;
        }
        return minLength;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 3, 1};
        int[] nums2 = {1, 2, 2, 3, 1, 4, 2};
        int[] nums3 = {49999, 1, 1, 1, 2, 1};
        Solution solution = new Solution();
        System.out.println(solution.findShortestSubArray(nums1));
        System.out.println(solution.findShortestSubArray(nums2));
        System.out.println(solution.findShortestSubArray(nums3));

    }
}
