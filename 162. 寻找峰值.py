from typing import List


class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        start, end = 0, len(nums)-1
        while start <= end:
            mid = (start+end)//2
            if (mid == 0 or nums[mid-1] < nums[mid]) and (mid == len(nums)-1 or nums[mid] > nums[mid+1]):
                return mid
            if nums[mid] < nums[mid+1]:
                start=mid+1
            else:
                end=mid-1


Solution().findPeakElement([1,2,1,3,5,6,4,0,0,0,0,0,0,0])
