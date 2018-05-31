class Solution:
    def diffWaysToCompute(self, input):
        """
        :type input: str
        :rtype: List[int]
        """
        def dfs(s, cache):
            ops = {'+':lambda x,y:x+y, '-':lambda x, y: x - y, '*': lambda x, y: x*y}
            if s not in cache:
                ret = []
                for k, v in enumerate(s):
                    if v in '+-*':
                        for left in dfs(s[:k], cache):
                            for right in dfs(s[k+1:], cache):
                                ret.append(ops[v](left, right))
                if not ret:
                    ret.append(int(s))
                cache[s] = ret
            return cache[s]
        return dfs(input, {})