class Solution:
    def canPartitionKSubsets(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: bool
        """
        if k == 1: return True
        
        self.n = len(nums)
            
        total = sum(nums)
        if total % k:
            return False
        
        self.subsum = total / k
        visit = [0]*self.n
        
        nums.sort(reverse=True)
        
        def dfs(k, ind, sum, cnt):
            if k == 1: return True
            if sum == self.subsum and cnt>0:
                return dfs(k-1, 0, 0, 0)
            for i in range(ind, self.n):
                if not visit[i] and sum+nums[i] <= self.subsum:
                    visit[i] = 1
                    if dfs(k, i+1, sum+nums[i], cnt+1):
                        return True
                    visit[i] = 0
            return False
        return dfs(k, 0, 0, 0)