class Solution(object):
    def findContentChildren(self, g, s):
        """
        :type g: List[int]
        :type s: List[int]
        :rtype: int
        """
	ans = 0
	g.sort()
	s.sort()
	j = 0
	for i in range(len(g)):
	    while j < len(s):
	        if s[j] >= g[i]:
		    ans += 1
		    j += 1
		    break
		j += 1
	return ans

solution = Solution()
g1 = [1,2,3]
s1 = [1,1]
g2 = [1,2]
s2 = [1,2,3]

print(solution.findContentChildren(g1, s1))
print(solution.findContentChildren(g2, s2))
