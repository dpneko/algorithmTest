// https://leetcode-cn.com/problems/shortest-subarray-with-sum-at-least-k/
// 返回 A 的最短的非空连续子数组的长度，该子数组的和至少为 K 。
// 如果没有和至少为 K 的非空子数组，返回 -1
package com.shortestSubarrayWithSumAtLeastK;
import java.util.Queue;
import java.util.ArrayDeque;
public class Main {
    public static void main(String[] args) {
        int[] A = {84,-37,32,40,95};
        int K = 167;
        Solution solution = new Solution();
        System.out.println(solution.shortestSubarray(A, K));
    }
}

class Solution {
    public int shortestSubarray(int[] A, int K) {
        if(A.length == 0){
            return -1;
        }
        int minLength = Integer.MAX_VALUE;
        int queueSum = 0;
        int headIndex = 0, tailIndex = 0;
        while(headIndex < A.length){
            queueSum+=A[headIndex];
            headIndex++;
            if(queueSum >= K){
                minLength = Integer.min(minLength, headIndex - tailIndex);
                while(queueSum - A[tailIndex] >= K && tailIndex<headIndex){
                    queueSum-=A[tailIndex];
                    tailIndex++;
                    minLength = Integer.min(minLength, headIndex - tailIndex);
                }
            }
        }
        if(minLength == Integer.MAX_VALUE)
            minLength = -1;
        return minLength;
    }
}

