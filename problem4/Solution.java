import java.util.Arrays;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        return ((m+n)%2==1) ? findK2(nums1, nums2, (m+n+1) >> 1) : (findK2(nums1, nums2, (m+n) >> 1) + findK2(nums1, nums2,((m+n) >> 1) +1))*0.5;
    }

    private double findK(int[] nums1, int[] nums2, int k) {
        int i = 0, j = 0;
        for (; (i < nums1.length && j < nums2.length) ;){
            --k;
            if(nums1[i] < nums2[j]){
                if(k == 0){
                    return nums1[i];
                }
                ++i;
            }else if (k == 0 ){
                return nums2[j];
            }else{
                ++j;
            }
        }
        return (i >= nums1.length) ? nums2[j+k-1]:nums1[i+k-1];
    }

    private double findK2(int[] nums1, int[] nums2, int k){
        int m = nums1.length, n = nums2.length;
        if(m > n){
            return findK2(nums2, nums1, k);
        }
        if (m == 0){
            return nums2[k-1];
        }
        if (k == 1){
            return Math.min(nums1[0], nums2[0]);
        }
        int pa = Math.min(k >> 1, m), pb = k -pa;
        return (nums1[pa-1] < nums2[pb-1]) ? findK2(Arrays.copyOfRange(nums1, pa, nums1.length), nums2, k -pa) : findK2(nums1, Arrays.copyOfRange(nums2, pb, nums2.length), k-pb);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMedianSortedArrays(new int[]{1,3}, new int[]{2}));
        System.out.println(solution.findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));
    }
}
