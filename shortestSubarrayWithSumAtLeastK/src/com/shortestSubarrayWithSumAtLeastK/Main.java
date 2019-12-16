// https://leetcode-cn.com/problems/shortest-subarray-with-sum-at-least-k/
// 返回 A 的最短的非空连续子数组的长度，该子数组的和至少为 K 。
// 如果没有和至少为 K 的非空子数组，返回 -1
package com.shortestSubarrayWithSumAtLeastK;

import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        // int[] A = {84,-37,32,40,95};
        int[] A = {1,2,3,-4,5,6};
        int K = 6;
        System.out.println(new SolutionGF().shortestSubarray(A, K));
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
            //踢掉队末一个
            queueSum -= A[tailIndex];
            tailIndex++;
            if(queueSum >= K){
                minLength = Integer.min(minLength,headIndex - tailIndex);
            }
            //如果队末是正的，则对头继续向前
            if(A[tailIndex-1]>=0){
                while(headIndex < A.length && headIndex - tailIndex <= K){
                    queueSum += A[headIndex];
                    headIndex++;
                    if(queueSum >= K){
                        minLength = Integer.min(minLength,headIndex - tailIndex);
                        break;
                    }
                }
            } else{
                while(headIndex > tailIndex + 1){
                    queueSum -= A[headIndex - 1];
                    headIndex--;
                    if(queueSum >= K){
                        minLength = Integer.min(minLength,headIndex - tailIndex);
                    }
                }
            }
        }
        if(minLength == Integer.MAX_VALUE)
            minLength = -1;
        return minLength;
    }
}


class Solution3 {
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
        int i=0,j=1;
        for(i=0,j=1;j<sum.length;j++){
            if(i!=0 && sum[i]<sum[i-1]){
                continue;
            }
            if(i<j-minLength){
                i=j-minLength;
            }
            for(;i<j;i++){
                if(sum[j]-sum[i] < K){
                    i--;
                    break;
                }
            }
        }
        if(minLength == A.length && sum[sum.length - 1]<K)
            minLength = -1;
        return minLength;
    }
}

class Solution4 {
    public int shortestSubarray(int[] A, int K) {
        if(A.length == 0){
            return -1;
        }
        int[] sum = new int[A.length+1];
        sum[0] = 0;
        //sum[i]-sum[k] = sum{k ~ i-1}
        for(int i = 1; i<=A.length; i++){
            sum[i] = A[i-1]+sum[i-1];
        }
        int minLength = Integer.MAX_VALUE;
        int headIndex = 1, tailIndex = 0;
        int lastHead = 0;
        int lastTail = 0;
        int queueSum = 0;
        while(headIndex < A.length){
            if(sum[headIndex] < sum[lastHead]){
                headIndex ++;
                continue;
            }
            lastHead = headIndex;
            if(sum[headIndex]-sum[tailIndex] >= K){
                minLength = Integer.min(minLength, headIndex - tailIndex);
                while(queueSum - A[tailIndex] >= K && tailIndex<headIndex){
                    queueSum-=A[tailIndex];
                    tailIndex++;
                    minLength = Integer.min(minLength, headIndex - tailIndex);
                }
            }
            headIndex++;
        }
        if(minLength == Integer.MAX_VALUE)
            minLength = -1;
        return minLength;
    }
}
class SolutionGF {
    /*
    *官方解的关键在于,队尾,当队列头减尾满足大于k时,需要让队尾的数字增大一点点来判断队尾能不能再去掉几个元素,而如果队尾是按照递增排列的就很方便.
    这么想象,从队尾开始要找比队尾大一点点的元素,如果队尾第二个元素比队尾大很多,第三个大一点点,那肯定用第三个元素去判断,因为第三个比第二个小,更容易满足队头减队尾大于k,所以第二个元素在队尾中就是可以去掉的.
    */
    public int shortestSubarray(int[] A, int K) {
        int N = A.length;
        long[] P = new long[N+1];
        for (int i = 0; i < N; ++i)
            P[i+1] = P[i] + (long) A[i];

        // Want smallest y-x with P[y] - P[x] >= K
        int ans = N+1; // N+1 is impossible
        Deque<Integer> monoq = new LinkedList(); //opt(y) candidates, as indices of P

        for (int y = 0; y < P.length; ++y) {
            // Want opt(y) = largest x with P[x] <= P[y] - K;
            while (!monoq.isEmpty() && P[y] <= P[monoq.getLast()])
                monoq.removeLast();
            while (!monoq.isEmpty() && P[y] >= P[monoq.getFirst()] + K)
                ans = Math.min(ans, y - monoq.removeFirst());

            monoq.addLast(y);
        }

        return ans < N+1 ? ans : -1;
    }
}
