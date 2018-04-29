class Solution:
    def numFriendRequests(self, ages):
        """
        :type ages: List[int]
        :rtype: int
        """
        if not ages: return 0
        cnt = 0
        N = len(ages)
        ages.sort()
        for i in range(N):
            a = ages[i]
            if a<=14: continue
            idx1 = bisect.bisect(ages, a)
            x = 0.5*a+7
            idx2 = bisect.bisect(ages, x)
            while idx2<N and ages[idx2]==x:
                idx2 += 1
            cnt += max(0, idx1-idx2+(-1 if idx2<=i<=idx1 else 0)) 
        return cnt