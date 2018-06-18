class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        process(nums, 0, tempList, ans);
        return ans;
    }
    
    private void process(int[] nums, int index, List<Integer> tempList, List<List<Integer>> ans) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(tempList));
            return;
        }
        process(nums, index + 1, tempList, ans);
        tempList.add(nums[index]);
        process(nums, index + 1, tempList, ans);
        tempList.remove(tempList.size() - 1);
    }
}