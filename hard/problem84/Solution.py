class Solution:
    def largestRectangleArea(self, heights):
        """
        :type heights: List[int]
        :rtype: int
        """
        stack = []
        maxArea = 0
        area = 0
        i = 0
        while i < len(heights):
            if len(stack) == 0 or heights[stack[0]] <= heights[i]:
                stack.insert(0, i)
                i += 1
            else:
                top = stack.pop(0)
                if len(stack) == 0:
                    area = heights[top] * i
                else:
                    area = heights[top] * (i - stack[0] - 1)
                if area > maxArea: maxArea = area
        
        while len(stack) != 0:
            top = stack.pop(0)
            if len(stack) == 0:
                area = heights[top] * i
            else:
                area = heights[top] * (i - stack[0] - 1)
            if area > maxArea: maxArea = area

        return maxArea
