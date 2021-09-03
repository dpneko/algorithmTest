"""
给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。

你可以对一个单词进行如下三种操作：

插入一个字符
删除一个字符
替换一个字符

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/edit-distance
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        # distance[i,j]表示word1前i个字母变成word2前j个字母的最少操作数
        n = len(word1)+1
        m = len(word2)+1
        distance = [ [0] * m for _ in range(n)]
        for i in range(n):
            distance[i][0] = i
        for j in range(m):
            distance[0][j] = j

        for i in range(1, n):
            for j in range(1, m):
                a = distance[i-1][j]+1 # word1增加1个字母
                b = distance[i][j-1]+1 # word2增加1个字母
                c = int(word1[i-1]!=word2[j-1]) + distance[i-1][j-1] # word1和word2都增加1个字母，如果这两个字母不一样，则操作数+1
                distance[i][j] = min(a, b, c)
        # print(distance)
        return distance[-1][-1]

Solution().minDistance(word1 = "horse", word2 = "ros")