class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int ele : nums) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(key);
        }
        
        List<Integer> ans = new ArrayList<>();
        for (int i = buckets.length - 1; i > -1 && ans.size() < k; i--) {
            if (buckets[i] != null) {
                ans.addAll(buckets[i]);
            }
        }
        return ans;
    }
}