class Solution:
    def shortestCompletingWord(self, licensePlate, words):
        """
        :type licensePlate: str
        :type words: List[str]
        :rtype: str
        """
        license_dict = {}
        licensePlate = licensePlate.lower()
        for i in licensePlate:
            if (i >= 'a' and i <= 'z') or (i >= 'A' and i <= 'Z'):
                if i in license_dict:
                    license_dict[i] = license_dict[i] + 1
                else:
                    license_dict[i] = 1
        min_len = 16
        ans = ""
        for i in range(len(words)):
            word = words[i]
            flag = True
            for key in license_dict:
                if word.count(key) < license_dict.get(key):
                    flag = False
                    break
            if flag:
                if len(word) < min_len:
                    ans = word
                    min_len = len(word)
        return ans