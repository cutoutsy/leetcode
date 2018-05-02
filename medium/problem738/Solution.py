class Solution:
    def monotoneIncreasingDigits(self, N):
        """
        :type N: int
        :rtype: int
        """
        if N < 10: return N
        n, inv_index = N, -1
        num = [int(d) for d in str(n)[::-1]]
        
        for i in range(1, len(num)):
            if num[i] > num[i - 1] or (inv_index != -1 and num[inv_index] == num[i]):
                inv_index = i
        
        if inv_index == -1: return N
        
        for i in range(inv_index): num[i] = 9
        num[inv_index] -= 1
            
        return int(''.join([str(i) for i in num[::-1]]))
        