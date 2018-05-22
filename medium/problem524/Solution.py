class Solution:
    def findLongestWord(self, s, d):
        """
        :type s: str
        :type d: List[str]
        :rtype: str
        """
        d.sort()
        i = 0
        ans = ""
        while i < len(d):
            pointer1 = 0
            pointer2 = 0
            temp = d[i]
            while pointer1 < len(s) and pointer2 < len(temp):
                if s[pointer1] == temp[pointer2]:
                    pointer1 += 1
                    pointer2 += 1
                else:
                    pointer1 += 1
            if pointer2 == len(temp):
                if len(temp) > len(ans):
                    ans = temp
            i += 1
        return ans
                
        