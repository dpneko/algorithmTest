from typing import List

class Solution:
    def _insertionSearchEqual(self, nums: List[int], target: int, start: int, end: int) -> List[int]:
        if start > end or target > nums[end] or target < nums[start]:
            return -1
        mid = self._mid(nums, target, start, end)
        if nums[mid] == target:
            return start, mid, end
        elif nums[mid] > target:
            return self._insertionSearchEqual(nums, target, start, mid-1)
        else:
            return self._insertionSearchEqual(nums, target, mid+1, end)
        

    def _mid(self, nums: List[int], target: int, start: int, end: int):
        return int(start+(target-nums[start])/(nums[end]-nums[start])*(end-start))


    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if len(nums) == 0:
            return [-1,-1]
        if nums[0]==nums[-1]:
            if nums[0] == target:
                return [0,len(nums)-1]
            else:
                return [-1,-1]

        start, end, rst = 0, len(nums)-1, -1
        while start <= end and target <= nums[end] and target >= nums[start]:
            mid = int(start+(target-nums[start])/(nums[end]-nums[start])*(end-start))
            if nums[mid] == target:
                rst = start, mid, end
                break
            elif nums[mid] > target:
                end = mid-1
            else:
                start = mid+1
        if rst == -1:
            return [-1, -1]

        left, right = rst[0], rst[2]

        start, end = rst[0], rst[1]
        while start <= end:
            mid = int((start+end)/2)
            if nums[mid] == target and (mid == 0 or nums[mid-1] != target):
                left = mid
                break
            elif nums[mid] == target:
                end = mid-1
            else:
                start = mid+1

        start, end = rst[1], rst[2]
        while start <= end:
            mid = int((start+end)/2)
            if  nums[mid] == target and (mid == len(nums)-1 or nums[mid+1] != target):
                right = mid
                break
            elif nums[mid] != target:
                end = mid-1
            else:
                start = mid+1
        # i = rst[1]-1
        # while i >= rst[0] and nums[i] == target:
        #     i -= 1
        # left = i+1
        # i = rst[1]+1
        # while  i <= rst[2] and nums[i] == target:
        #     i += 1
        # right = i-1
        return [left, right]


print(Solution().searchRange([1,3], 1))
