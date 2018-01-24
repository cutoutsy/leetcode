import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int maxChunksToSorted(int[] arr) {
        int[] arrCopy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arr);
        Map<Integer, Integer> numIndex = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (!numIndex.containsKey(arr[i])) {
                numIndex.put(arr[i], i);
            }
        }
        int ans = 0;
        int maxRight = -1;
        for (int i = 0; i < arrCopy.length; i++) {
            if (numIndex.get(arrCopy[i]) == i && maxRight == -1) {
                ans++;
            } else {
                int tempIndex = numIndex.get(arrCopy[i]);
                maxRight = maxRight == -1 ? tempIndex : Math.max(maxRight, tempIndex);
                if (maxRight == i) {
                    ans++;
                    maxRight = -1;
                }
            }
            numIndex.computeIfPresent(arrCopy[i], (k, v) -> v + 1);
        }
        return ans;
    }

    public int maxChunksToSorted1(int[] arr) {
        int n = arr.length;
        int[] maxOfLeft = new int[n];
        int[] minOfRight = new int[n];

        maxOfLeft[0] = arr[0];
        for (int i = 1; i < n; i++) {
            maxOfLeft[i] = Math.max(maxOfLeft[i-1], arr[i]);
        }

        minOfRight[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            minOfRight[i] = Math.min(minOfRight[i + 1], arr[i]);
        }

        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            if (maxOfLeft[i] <= minOfRight[i + 1]) res++;
        }

        return res + 1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 4, 4};
        int[] arr1 = {5, 4, 3, 2, 1};
        int[] arr2 = {5};
        int[] arr3 = {5, 5, 5};
        Solution solution = new Solution();
        System.out.println(solution.maxChunksToSorted(arr));
        System.out.println(solution.maxChunksToSorted(arr1));
        System.out.println(solution.maxChunksToSorted(arr2));
        System.out.println(solution.maxChunksToSorted(arr3));
    }
}
