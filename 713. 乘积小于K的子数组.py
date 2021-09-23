"""
给定一个正整数数组 nums和整数 k 。

请找出该数组内乘积小于 k 的连续的子数组的个数。
https://leetcode-cn.com/problems/subarray-product-less-than-k/
"""
from typing import List


class Solution:
    def numSubarrayProductLessThanK(self, nums: List[int], k: int) -> int:
        start = 0
        end = 0
        product = 1
        total = 0
        while start < len(nums):
            while end < len(nums) and product*nums[end] < k:
                product *= nums[end]
                end += 1
            if start<end:
                total += end - start
                product /= nums[start]
            else:
                end = start + 1
            start += 1
        return total

from functools import reduce
nums = [1,2,3]
Solution().numSubarrayProductLessThanK([57,44,92,28,66,60,37,33,52,38,29,76,8,75,22],
18)
