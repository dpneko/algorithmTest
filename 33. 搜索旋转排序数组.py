from typing import List


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if len(nums) == 0:
            return -1
        imin = 0  # 最小值所在下标
        if nums[0] > nums[-1]:
            start, end = 0, len(nums)-1
            while start <= end:
                mid = int((start+end)/2)
                if nums[mid] > nums[mid+1]:
                    imin = mid+1
                    break
                if nums[mid]>nums[0]:
                    start = mid
                else:
                    end = mid
        print(imin)
        if target < nums[imin] or target > nums[imin-1]:
            return -1
        if target >= nums[0]:
            start, end = 0, (imin-1) % len(nums)
        else:
            start, end = imin, len(nums)-1
        rst = -1
        while start <= end:
                mid = int((start+end)/2)
                if nums[mid] == target:
                    rst = mid
                if nums[mid]<target:
                    start = mid+1
                else:
                    end = mid-1
        return rst
            

Solution().search([0,1], 0)
