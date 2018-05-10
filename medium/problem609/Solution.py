class Solution:
    def findDuplicate(self, paths):
        """
        :type paths: List[str]
        :rtype: List[List[str]]
        """
        ans = []
        content = {}
        for i in range(len(paths)):
            directory = paths[i].split(" ")[0]
            for j in range(1, len(paths[i].split(" "))):
                file = paths[i].split(" ")[j].split("(")[0]
                con = paths[i].split(" ")[j].split("(")[1][:-1]
                path = directory + "/" + file
                if con in content:
                    content[con] = content[con] + [path]
                else:
                    content[con] = [path]
        for key in content:
            if len(content[key]) > 1:
                ans.append(content[key])
        return ans