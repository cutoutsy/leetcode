class Solution:
    def countArrangement(self, N):
        """
        :type N: int
        :rtype: int
        """
        nums = []
        return self.process(N, nums, N)

    def process(self, index, nums, n):
        if index == 0:
            return 1
        count = 0
        leaves = []
        for x in range(1, n + 1):
            if x not in nums:
                leaves.append(x)

        for i in range(len(leaves)):
            if index % leaves[i] == 0 or leaves[i] % index == 0:
                nums.append(leaves[i])
                count += self.process(index - 1, nums, n)
                nums.remove(leaves[i])
        return count
        