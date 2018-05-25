class Solution:
    def findMinDifference(self, timePoints):
        """
        :type timePoints: List[str]
        :rtype: int
        """
        ans = 24 * 60
        time_min = []
        for time in timePoints:
            hour = int(time.split(":")[0])
            mins = int(time.split(":")[1])
            total_min = hour * 60 + mins
            time_min.append(total_min)
        time_min.sort()
        for i in range(len(timePoints) - 1):
            ans = min(time_min[i + 1] - time_min[i], ans)
        ans = min(60 * 24 + time_min[0] - time_min[len(time_min) - 1], ans)
        
        return ans