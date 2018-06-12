class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] numsCopy = nums.clone();
        Arrays.sort(numsCopy);
        int left = 0;
        int right = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != numsCopy[i]) {
                break;
            }
            left++;
        }
        for (int i = nums.length - 1; i > left; i--) {
            if (nums[i] != numsCopy[i]) {
                break;
            }
            right--;
        }
        return right - left + 1;
    }
}