class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] buckets = new int[10001];
        for (int num : nums) {
            buckets[num] += num;
        }
        int pre = 0;
        int cur = buckets[1];
        for (int i = 2; i < buckets.length; i++) {
            int temp = cur;
            cur = Math.max(pre + buckets[i], cur);
            pre = temp;
        }
        return cur;
    }
}