class Solution:
    def dailyTemperatures(self, temperatures):
        """
        :type temperatures: List[int]
        :rtype: List[int]
        """
        ans = []
        temp_index = {}
        for i in range(len(temperatures) - 1, -1, -1):
            temp_index[temperatures[i]] = i
            temp = temperatures[i]
            all_temp = list(temp_index.keys())
            index = len(temperatures)
            for item in range(len(all_temp)):
                if all_temp[item] > temp and temp_index[all_temp[item]] < index:
                    index = temp_index[all_temp[item]]
            if index != len(temperatures):
                ans.insert(0, index - i)
            else:
                ans.insert(0, 0)
        return ans