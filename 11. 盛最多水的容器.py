"""
给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/container-with-most-water
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""

from typing import List


class Solution:
    def maxArea(self, height: List[int]) -> int:
        max_contain = 0
        i, j = 0, len(height)-1
        while i < j:
            max_contain = max(max_contain, min(height[i], height[j])*(j-i))
            if height[i] >= height[j]:
                j -= 1
            else:
                i += 1
        return max_contain

Solution().maxArea([1,2,1])