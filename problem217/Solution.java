import java.util.*;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        int flag = 0;
        Set<Integer> result = new HashSet<Integer>();
        for (int num : nums) {
        	result.add(num);
        }
        return nums.length != result.size();
    }

	public static void main(String[] args){
		int[] nums = {1, 2, 2, 3, 4};
		Solution solution = new Solution();
		System.out.println(solution.containsDuplicate(nums));
	}
}
