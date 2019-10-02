// https://leetcode-cn.com/problems/shortest-subarray-with-sum-at-least-k/
// 返回 A 的最短的非空连续子数组的长度，该子数组的和至少为 K 。
// 如果没有和至少为 K 的非空子数组，返回 -1
package com.shortestSubarrayWithSumAtLeastK;
import java.util.Queue;
import java.util.ArrayDeque;
public class Main {
    public static void main(String[] args) {
        int[] A = {1};
        int K = 1;
        Solution1 solution = new Solution1();
        System.out.println(solution.shortestSubarray(A, K));
    }
}

class Solution {
    //此方法没有考虑 A=84,-37,32,40,95，k=167
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

class Solution1 {
    public int shortestSubarray(int[] A, int K){
        if(A.length == 0){
            return -1;
        }
        int[] sum = new int[A.length+1];
        sum[0] = 0;
        for(int i = 1; i<=A.length; i++){
            sum[i] = A[i-1]+sum[i-1];
        }
        int minLength = A.length;
        boolean success = true;
        for(int i = 0; i < A.length; i++){
            // if(!success && A[i+minLength])
            for(int j = i+1; j <= i + minLength && j < sum.length; j++){
                if(sum[j]-sum[i] >= K){
                    minLength = j-i;
                    break;
                }
            }
        }
        if(minLength == A.length && sum[sum.length - 1]<K)
            minLength = -1;
        return minLength;
    }
}

class Solution2 {
    public int shortestSubarray(int[] A, int K){
        if(A.length == 0){
            return -1;
        }
        int minLength = Integer.MAX_VALUE;
        int queueSum = 0;
        int headIndex = 0, tailIndex = 0;
        while(headIndex < A.length){
            queueSum += A[headIndex];
            headIndex++;
            if(queueSum >= K){
                minLength = headIndex - tailIndex;
                break;
            }
        }
        while(tailIndex < headIndex){
            if(tailIndex)
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

