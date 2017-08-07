class Solution(object):
    def canConstruct(self, ransomNote, magazine):
        """
        :type ransomNote: str
        :type magazine: str
        :rtype: bool
        """
	ans = True
	for i,ch in enumerate(ransomNote):
	    if(ch in magazine):
		magazine = magazine.replace(ch,'',1)
	    else:
		ans = False
	return ans
solution = Solution()
print(solution.canConstruct("a", "b"))
print(solution.canConstruct("aa", "ab"))
print(solution.canConstruct("aa", "aab"))
