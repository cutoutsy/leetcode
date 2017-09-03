class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length < 1)
        	return 1;
        int i = 0;
        while (i < nums.length) {
        	if (nums[i] == i+1 || nums[i] <= 0 || nums[i] > nums.length)
        		i++;
        	else if (nums[nums[i]-1] != nums[i])
        		swap(nums, i, nums[i] - 1);
        	else
        		i++;
        }
        i = 0;
        while (i < nums.length && nums[i] == i + 1) {
        	i++;
        }
        return i + 1;
    }

    private void swap(int[] nums, int i, int j){
    	int temp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = temp;
    }

    public static void main(String[] args){
    	int[] nums1 = {1, 2, 0};
    	int[] nums2 = {3, 4, -1, 1};

    	Solution solution = new Solution();
    	System.out.println(solution.firstMissingPositive(nums1));
    	System.out.println(solution.firstMissingPositive(nums2));
    }
}