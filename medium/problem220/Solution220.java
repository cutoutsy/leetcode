import java.util.TreeSet;

public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0)
            return false;
        final TreeSet<Long> values = new TreeSet<>();
        for (int ind = 0; ind < nums.length; ind++){
            final Long floor = values.floor((long)nums[ind] + t);
            final Long ceil = values.ceiling((long)nums[ind] - t);
            if ((floor != null && floor >= nums[ind]) || (ceil != null && ceil <= nums[ind])){
                return true;
            }
            values.add((long)nums[ind]);
            if (ind >= k){
                values.remove((long)nums[ind-k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-2147483648, -2147483647};
        int k = 3;
        int t = 3;

        System.out.println(solution.containsNearbyAlmostDuplicate(nums, k, t));
    }
}
