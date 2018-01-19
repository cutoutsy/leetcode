class Solution(object):
    def distributeCandies(self, candies):
    	"""
	:type candies: List[int]
	:rtype: int
	"""
	return min(len(candies)/2, len(set(candies)))	

candies1 = [1,1,2,2,3,3]
candies2 = [1,1,2,3]
solution = Solution()
print(solution.distributeCandies(candies1))
print(solution.distributeCandies(candies2))
