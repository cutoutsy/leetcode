class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int n = nums.size();
        int endHere = nums[0];
        int answer = nums[0];
        for (int i = 1; i < n; ++i) {
            endHere = max(endHere + nums[i], nums[i]);
            answer = max(endHere, answer);
        }
        return answer;
    }
};