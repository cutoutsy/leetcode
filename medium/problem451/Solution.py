class Solution:
    def frequencySort(self, s):
        """
        :type s: str
        :rtype: str
        """
        ans = ""
        alpha_dict = {}
        for ch in s:
            if ch in alpha_dict:
                alpha_dict[ch] = alpha_dict[ch] + 1
            else:
                alpha_dict[ch] = 1
        alpha_list = sorted(alpha_dict.items(), key = lambda item:item[1], reverse=True)
        for i in range(len(alpha_list)):
            ans += alpha_list[i][0] * alpha_list[i][1]
        return ans