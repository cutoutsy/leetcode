class Solution:
    def shortestToChar(self, S, C):
        """
        :type S: str
        :type C: str
        :rtype: List[int]
        """
        ans = []
        length = len(S)
        prec = -1
        for i, s in enumerate(S):
            if s == C:
                ans.append(0)
                prec = i
            else:
                if prec == -1:
                    ans.append(length)
                else:
                    ans.append(i - prec)
        prec = -1
        for i, s in enumerate(S[::-1]):
            if s == C:
                prec = i
            else:
                if prec != -1:
                    dis = i - prec
                    if (dis < ans[length - i - 1]) :
                        ans[length - i - 1] = dis
        return ans
                
            
                