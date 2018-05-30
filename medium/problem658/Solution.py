class Solution:
    def findClosestElements(self, arr, k, x):
        """
        :type arr: List[int]
        :type k: int
        :type x: int
        :rtype: List[int]
        """
        ans = []
        exist = -1
        count = 0
        if x in arr:
            count = 1
            exist = arr.index(x)
            ans.append(arr[exist])
        else:
            i = bisect.bisect_left(arr, x)
            arr.insert(i, x)
            exist = i
        left = exist - 1
        right = exist + 1
        while count < k:
            count += 1
            if left == -1:
                ans.append(arr[right])
                right += 1
                continue
            if right == len(arr):
                ans.insert(0, arr[left])
                left -= 1
                continue
            if (arr[exist] - arr[left]) <= (arr[right] - arr[exist]):
                ans.insert(0, arr[left])
                left -= 1
            elif (arr[exist] - arr[left]) > (arr[right] - arr[exist]):
                ans.append(arr[right])
                right += 1
        return ans