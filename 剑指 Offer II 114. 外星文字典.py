"""现有一种使用英语字母的外星文语言，这门语言的字母顺序与英语顺序不同。

给定一个字符串列表 words ，作为这门语言的词典，words 中的字符串已经 按这门新语言的字母顺序进行了排序 。

请你根据该词典还原出此语言中已知的字母顺序，并 按字母递增顺序 排列。若不存在合法字母顺序，返回 "" 。若存在多种可能的合法字母顺序，返回其中 任意一种 顺序即可。

字符串 s 字典顺序小于 字符串 t 有两种情况：

在第一个不同字母处，如果 s 中的字母在这门外星语言的字母顺序中位于 t 中字母之前，那么 s 的字典顺序小于 t 。
如果前面 min(s.length, t.length) 字母都相同，那么 s.length < t.length 时，s 的字典顺序也小于 t 。
 

示例 1：

输入：words = ["wrt","wrf","er","ett","rftt"]
输出："wertf"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/Jf1JuT
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
from typing import List


class Solution:
    def alienOrder(self, words: List[str]) -> str:
        if len(words) == 0:
            return ""
        if len(set(words)) == 1:
            return words[0]
        graph = {} # k为边的起始点，v为边的终止点的集合，图的边a->b表示a字母比b字母顺序小
        in_count = {}
        # 比较相邻两个单词
        for i in range(len(words)-1):
            s = words[i]
            t = words[i+1]
            first_diff = 0
            while first_diff < len(s) and first_diff < len(t) and s[first_diff] == t[first_diff]:
                in_count.setdefault(s[first_diff], 0)
                first_diff += 1
            if first_diff < len(s) and first_diff >= len(t):
                return ""
            if first_diff < len(s) and first_diff < len(t):
                a = s[first_diff]
                b = t[first_diff]
                if a in graph:
                    graph[a].append(b)
                else:
                    graph[a] = [b]
                in_count[b] = in_count.get(b, 0) + 1
                in_count.setdefault(a, 0)
            for c in s[first_diff:]:
                in_count.setdefault(c, 0)
            for c in t[first_diff:]:
                in_count.setdefault(c, 0)
        rtn = []
        while(len(in_count)>0):
            zero_in = None
            for k,v in in_count.items():
                if v <= 0:
                    zero_in = k
                    break
            if zero_in is None:
                return ""
            del in_count[zero_in]
            rtn.append(zero_in)
            for node in graph.get(zero_in, []):
                if node in in_count:
                    in_count[node] -= 1

        return "".join(rtn)

print(Solution().alienOrder(["abc","ab"]))

# 关键词：拓扑排序