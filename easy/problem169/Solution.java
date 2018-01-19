public class Solution {
    public int majorityElement(int[] nums) {
        int current = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0){
                current = nums[i];
                count++;
            }else if (nums[i] != current) {
                count--;
            }else if (nums[i] == current){
                count++;
            }
        }
        return current;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,3,3,4,5,3};
        Solution solution = new Solution();
        System.out.println(solution.majorityElement(nums));
    }
}
