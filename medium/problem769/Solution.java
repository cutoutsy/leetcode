public class Solution {
    public int maxChunksToSorted(int[] arr) {
        int ans = 0;
        int maxRight = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == i && maxRight == -1) {
                ans++;
            } else {
                maxRight = maxRight == -1 ? arr[i] : Math.max(maxRight, arr[i]);
                if (maxRight == i) {
                    ans++;
                    maxRight = -1;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1, 0};
        int[] arr1 = {1, 0, 2, 3, 4};
        int[] arr2 = {2, 3, 1, 0, 4};
        Solution solution = new Solution();
        System.out.println(solution.maxChunksToSorted(arr));
        System.out.println(solution.maxChunksToSorted(arr1));
        System.out.println(solution.maxChunksToSorted(arr2));
    }
}
