"""
给定两个由一些 闭区间 组成的列表，firstList 和 secondList ，其中 firstList[i] = [starti, endi] 而 secondList[j] = [startj, endj] 。每个区间列表都是成对 不相交 的，并且 已经排序 。

返回这 两个区间列表的交集 。

形式上，闭区间 [a, b]（其中 a <= b）表示实数 x 的集合，而 a <= x <= b 。

两个闭区间的 交集 是一组实数，要么为空集，要么为闭区间。例如，[1, 3] 和 [2, 4] 的交集为 [2, 3] 。



来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/interval-list-intersections
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
from typing import List


class Solution:
    def intervalIntersection(self, firstList: List[List[int]], secondList: List[List[int]]) -> List[List[int]]:
        merge = []
        i, j = 0, 0
        while i < len(firstList) or j < len(secondList):
            if (j >= len(secondList)) or (i < len(firstList) and firstList[i][0] <= secondList[j][0]):
                merge.append(firstList[i])
                i += 1
            else:
                merge.append(secondList[j])
                j += 1
        rtn = []
        max_tail = merge[0][1]
        for i in range(1, len(merge)):
            if merge[i][0] <= max_tail:
                rtn.append([merge[i][0], min(merge[i][1], max_tail)])
            max_tail = max(max_tail, merge[i][1])
        return rtn


Solution().intervalIntersection(firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]])
