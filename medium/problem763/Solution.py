class Solution:
    def partitionLabels(self, S):
        """
        :type S: str
        :rtype: List[int]
        """
        res, n = [], len(S)
        idx_dict = {}
        for i in range(n):
            idx_dict[S[i]] = i
        i = 0
        while i < n:
            start = j = i
            while i <= j:
                last_si_idx = idx_dict[S[i]]
                if j < last_si_idx:
                    j = last_si_idx
                i += 1
            res.append(j-start+1)

        return res