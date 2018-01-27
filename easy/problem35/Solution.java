public class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;    // 防止溢出
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        Solution solution = new Solution();
        System.out.println(solution.searchInsert(nums, 5));
        System.out.println(solution.searchInsert(nums, 2));
        System.out.println(solution.searchInsert(nums, 7));
        System.out.println(solution.searchInsert(nums, 0));
    }
}
