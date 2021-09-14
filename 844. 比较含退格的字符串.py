"""
给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。

注意：如果对空文本输入退格字符，文本继续为空。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/backspace-string-compare
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
class Solution:
    def backspaceCompare(self, s: str, t: str) -> bool:
        i, j = len(s)-1, len(t)-1
        while i >= 0 or j >= 0:

            count_s = 0
            while i >= 0:
                if s[i] == '#':
                    i -= 1
                    count_s += 1
                elif count_s > 0:
                    i -= 1
                    count_s -= 1
                else:
                    break

            count_t = 0
            while j >= 0:
                if t[j] == '#':
                    j -= 1
                    count_t += 1
                elif count_t > 0:
                    j -= 1
                    count_t -= 1
                else:
                    break
            
            if ((i >= 0) ^ (j >= 0)) or (i >= 0 and j >= 0 and s[i] != t[j]):
                return False
            else:
                i -= 1
                j -= 1
        return True

Solution().backspaceCompare("nzp#o#g","b#nzp#o#g")
