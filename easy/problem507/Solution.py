class Solution:
    def checkPerfectNumber(self, num):
        """
        :type num: int
        :rtype: bool
        """
        if num <= 1:
            return False
        sum = 1
        square = int(math.sqrt(num))
        for i in range(2, square + 1):
            if num % i == 0:
                sum += i
                sum += int(num / i)
            if sum > num:
                return False
        if sum == num:
            return True
        return False