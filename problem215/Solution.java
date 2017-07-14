public class Solution {
    private int heapsize = 0;

    public int findKthLargest(int[] nums, int k) {
        return HeapSort(nums, k);
    }

    public int HeapSort(int[] nums, int k){
        heapsize = nums.length;
        BuildMaxHeap(nums);
        for (int i = 0; i < k; i++){
            swap(nums, 0, heapsize-1);
            heapsize--;
            Maxify(nums, 0);
        }
        return nums[heapsize];
    }

    private void Maxify(int[] nums, int i) {
        int l = left(i);
        int r = right(i);
        int largest;
        if(l < heapsize && nums[l] > nums[i]){
            largest = l;
        }else{
            largest = i;
        }
        if(r < heapsize && nums[r] > nums[largest]){
            largest = r;
        }
        if(largest == i || largest >= heapsize){
            return;
        }
        swap(nums, i, largest);
        Maxify(nums, largest);
    }

    public void BuildMaxHeap(int[] nums){
        for (int i = nums.length/2 - 1; i >= 0; i--){
            Maxify(nums, i);
        }
    }

    private int right(int i) {
        return 2*(i+1);
    }

    private int left(int i) {
        return 2*i + 1;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {3,2,1,5,6,4};
        int k1 = 2;
        int[] nums2 = {2, 1};
        int k2 = 1;
        System.out.println(solution.findKthLargest(nums1, k1));
        System.out.println(solution.findKthLargest(nums2, k2));
    }
}
