"""
存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。

返回同样按升序排列的结果链表。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        # 避免链表开头出现重复的情况，所以添加空的头结点
        head = ListNode(None, head)

        p = head
        while p.next is not None:
            q = p.next.next
            while q is not None and p.next.val == q.val:
                q = q.next
            if q != p.next.next:
                p.next = q
            else:
                p = p.next
        return head.next


from functools import reduce
head = reduce(lambda head, x: ListNode(val=x, next=head), reversed([1,2,3,3,4,4,5]), ListNode())
p = head
while p is not None:
    print(p.val)
    p = p.next
head = Solution().deleteDuplicates(head)
p = head
while p is not None:
    print(p.val)
    p = p.next