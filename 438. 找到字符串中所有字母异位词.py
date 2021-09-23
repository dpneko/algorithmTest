"""
给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。

异位词 指字母相同，但排列不同的字符串。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
from typing import List


class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        cnt_p = {}
        for c in p:
            cnt_p[c] = cnt_p.get(c, 0) + 1
        wide = len(p)
        rtn = []
        cnt_s = {}
        for c in s[:wide]:
            if cnt_p.get(c) is not None:
                cnt_s[c] = cnt_s.get(c, 0) + 1
        if cnt_p == cnt_s:
            rtn.append(0)
        for i in range(len(s)-wide):
            if cnt_p.get(s[i]) is not None:
                cnt_s[s[i]] -= 1
            next = s[i+wide]
            if cnt_p.get(next) is not None:
                cnt_s[next] = cnt_s.get(next, 0) + 1
            if cnt_p == cnt_s:
                rtn.append(i+1)
        return rtn
        

Solution().findAnagrams(s = "cbaebabacd", p = "abc")