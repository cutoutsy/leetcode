class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<int[]> res = new ArrayList<>();
        int[] perm = new int[nums.length];
        Set<Integer> visited = new HashSet<>();
        process(nums, 0, perm, res, visited);
        List<List<Integer>> ans = new ArrayList<>();
        for(int[] ele : res) {
            List<Integer> temp = new ArrayList<>();
            for (int k : ele) {
                temp.add(k);
            }
            ans.add(temp);
        }
        return ans;
    }
    
    private void process(int[] nums, int index, int[] perm, List<int[]> res, Set<Integer> visited) {
        if (index == nums.length) {
            res.add(perm.clone());
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(!visited.contains(nums[i])) {
                visited.add(nums[i]);
                perm[index] = nums[i];
                process(nums, index+1, perm, res, visited);
                visited.remove(nums[i]);
            }
        }
    }
}