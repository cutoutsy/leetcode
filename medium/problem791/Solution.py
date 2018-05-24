class Solution:
    def customSortString(self, S, T):
        """
        :type S: str
        :type T: str
        :rtype: str
        """
        alpha_num = {}
        ans = ""
        for ele in T:
            if ele in alpha_num:
                alpha_num[ele] = alpha_num[ele] + 1
            else:
                alpha_num[ele] = 1
        for ele in S:
            if ele in alpha_num:
                ans += ele * alpha_num.get(ele)
                del alpha_num[ele]
        for key in alpha_num.keys():
            ans += key * alpha_num.get(key)
        return ans