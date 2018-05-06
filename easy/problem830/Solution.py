class Solution:
    def largeGroupPositions(self, S):
        """
        :type S: str
        :rtype: List[List[int]]
        """
        ans = []
        pre = ''
        preindex = -1
        for i in range(len(S)):
            if S[i] != pre:
                pre = S[i]
                if i - preindex >= 3:
                    temp = [preindex, i - 1]
                    ans.append(temp)
                preindex = i
        if len(S) - preindex >= 3:
            ans.append([preindex, len(S) - 1])
        
        return ans