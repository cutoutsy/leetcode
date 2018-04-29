class Solution:
    def toGoatLatin(self, S):
        """
        :type S: str
        :rtype: str
        """
        lists = S.split()
        ans = ""
        vowel = ['a', 'e', 'i', 'o', 'u']
        for i in range(len(lists)):
            word = lists[i]
            change = ""
            first = word[0].lower()
            if vowel.count(first) == 1:
                change = word + "ma"
            else:
                change = word[1:] + word[0] + "ma"
            j = i + 1
            while j != 0:
                change += "a"
                j -= 1
            ans += change + " "
        return ans.strip()