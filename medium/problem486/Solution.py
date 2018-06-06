class Solution:
    def PredictTheWinner(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        mem = [[None for i in range(len(nums))] for i in range(len(nums))]
        return self.process(nums, 0, len(nums) - 1, mem) >= 0
    def process(self, nums, s, e, mem):
        if mem[s][e] is None:
            if s == e:
                mem[s][e] = nums[s]
            else:
                mem[s][e] = max(nums[s] - self.process(nums, s + 1, e, mem), nums[e] - self.process(nums, s, e - 1, mem))
        return mem[s][e]