class NumArray:

    def __init__(self, nums):
        """
        :type nums: List[int]
        """
        sum = 0
        #sums = []
        self.sums = []
        for i in range(len(nums)):
            sum += nums[i]
            self.sums.append(sum)
        

    def sumRange(self, i, j):
        """
        :type i: int
        :type j: int
        :rtype: int
        """
        if i == 0:
            return self.sums[j]
        else:
            return self.sums[j] - self.sums[i-1] 