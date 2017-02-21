import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums){
        List<Integer> reList = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i){
            int idx = Math.abs(nums[i]) - 1;
            nums[idx] = nums[idx] > 0 ? -nums[idx] : nums[idx];
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0){
                reList.add(i+1);
            }
        }
        return reList;
    }

    public static void main(String[] args){
        int[] input = {4,3,2,7,8,2,3,1};
        Solution solution = new Solution();
        List<Integer> result = solution.findDisappearedNumbers(input);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
