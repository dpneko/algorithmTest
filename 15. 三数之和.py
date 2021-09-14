"""
给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。

注意：答案中不可以包含重复的三元组。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/3sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""

from typing import List

class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        rtn = []
        end = len(nums)-1
        last_first = None
        for first in range(end+1):
            if nums[first] != last_first:
                last_first = nums[first]
                second, third = first+1, end
                while second < third:
                    sum = nums[first] + nums[second] + nums[third]
                    if sum == 0:
                        rtn.append([nums[first], nums[second], nums[third]])
                    if sum <= 0:
                        second += 1
                        while second < third and nums[second] == nums[second-1]:
                            second += 1
                    if sum >= 0:
                        third -= 1
                        while second < third and nums[third] == nums[third+1]:
                            third -= 1
        return rtn
        
Solution().threeSum([-1, -1, 0, 1])