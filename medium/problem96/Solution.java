class Solution {
    public int numTrees(int n) {
        if (n == 0)
            return 0;
        int[] nums = new int[n+1];
        nums[0] = 1;
        nums[1] = 1;
        for (int i = 2; i < nums.length; i++) {
            int temp = 0;
            for (int j = 1; j <= i; j++) {
                temp += (nums[j-1]*nums[i-j]);
            }
            nums[i] = temp;
        }
        return nums[n];
    }
}