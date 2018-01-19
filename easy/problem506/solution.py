class Solution(object):
    def findRelativeRanks(self, nums):
        """
        :type nums: List[int]
        :rtype: List[str]
        """
	sortNums = nums[0:]
        sortNums.sort()
        rank = 1
	length = len(nums)-1
	while length >= 0:
	   nums[nums.index(sortNums[length])] = str(rank)
	   rank += 1
	   length -= 1
	nums[nums.index('1')] = 'Gold Medal'
	if len(nums) > 1:
	    nums[nums.index('2')] = 'Silver Medal'
	if len(nums) > 2:
	    nums[nums.index('3')] = 'Bronze Medal'
	return nums
        

solution = Solution()
print(solution.findRelativeRanks([5, 4, 3, 2, 1]))
