/**
 * https://leetcode.com/problems/max-consecutive-ones-iii/description/
 * Given an array A of 0s and 1s, we may change up to K values from 0 to 1.

Return the length of the longest (contiguous) subarray that contains only 1s. 

Example 1:

Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
Output: 6
Explanation: 
[1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
Example 2:

Input: A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
Output: 10
Explanation: 
[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.

1 <= A.length <= 20000
0 <= K <= A.length
A[i] is 0 or 1 
 */

/**
 * A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
[1,1,1,0,0,0,1,1,1,1,0]
[1,2,3,0,0,0,1,2,3,4,0] K=0
[1,2,3,4,]
*/
package com.LongestSubarray;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Main
{
    public static void main(String[] args)
    {
        int[] A = new int[]{0,1,1,0,1,1,1,1,0,1,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,1,1,1,0,0,1,1,0,1,1,1,1,0,0,1,0,1,0,1,1,0,0,0,1,0,0,1,1,0,0,0,1,1,0,1,0,1,1,0,0,1,0,0,0,0,1,1,1,1,0,0,0,1,0,1,1,0,1,0,1,1,1,1,1,1,1,1,0,1,0,1,1,1,0,0,0,1,1,1,1,1,1,0,1,0,0,1,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,1,0,0,1,0,0,1,0,1,0,0,1,1,1,0,0,0,1,1,0,1,1,1,0,0,0,1,1,1,0,1,1,0,1,1,1,0,0,1,1,0,1,0,0,0,0,1,0,0,0,1,0,0,1,0,1,1,1,1,0,0,1,1,1,1,0,1,1,0,1,0,1,0,0,0,1,0,0,0,1,0,1,1,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,0,0,1,1,0,0,1,1,1,1,1,0,1,1,1,1,1,1,1,0,1,0,1,0,0,1,0,1,0,0,0,1,1,1,0,1,1,0,1,1,1,1,1,0,1,0,1,0,1,0,1,1,1,0,1,0,1,1,0,1,0,1,0,0,1,0,1,0,0,0,0,1,1,1,0,1,0,1,0,0,1,1,0,1,0,0,0,0,0,1,1,0,1,0,0,0,0,1,0,0,0,0,0,1,1,1,1,1,0,1,0,1,0,0,0,0,0,1,1,0,1,0,0,1,0,0,0,1,0,0,0,1,1,1,0,1,1,1,0,0,1,0,1,1,1,0,1,1,1,1,0,1,0,0,0,0,0,1,1,1,0,0,0,0,1,1,0,0,0,0,1,1,1,0,1,0,0,0,0,0,0,0,1,1,0,1,0,1,1,1,0,0,1,0,0,0,1,0,0,1,1,1,1,1,0,0,1,1,0,0,1,0,1,1,1,1,0,0,1,1,1,0,1,1,1,0,0,1,0,0,1,0,0,1,1,1,1,0,1,0,0,0,1,1,1,1,1,0,1,0,0,1,1,0,0,1,0,1,1,1,0,1,0,0,0,0,1,1,0,1,1,1,0,1,1,1,1,0,1,1,1,1,0,1,1,1,0,0,1,0,0,1,1,1,1,1,1,0,0,1,1,0,0,1,0,1,1,0,1,0,1,1,0,1,1,1,0,0,0,0,1,1,1,0,1,1,0,1,1,0,0,1,1,1,1,1,0,1,1,0,1,0,1,1,1,0,1,1,1,1,0,0,0,0,0,0,0,1,0,1,1,0,1,0,1,0,0,1,1,0,1,1,1,1,0,1,0,0,1,0,0,0,0,0,0,1,0,1,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0,1,1,0,0,1,0,1,1,0,1,1,0,1,0,0,1,0,0,0,1,0,0,0,0,1,0,0,1,1,1,1,1,0,1,1,0,0,0,1,1,0,0,0,1,1,0,0,0,1,1,1,0,1,0,1,1,0,0,1,1,1,0,1,1,1,0,0,0,1,1,0,1,0,1,1,1,1,0,1,0,1,1,0,1,0,0,1,0,0,0,1,1,0,0,0,0,1,0,1,0,0,0,0,1,1,0,0,0,0,1,1,1,0,0,0,0,1,0,1,1,0,0,0,1,0,0,0,0,1,0,1,1,0,1,0,1,1,0,0,1,0,0,1,0,0,1,1,0,1,0,1,0,1,1,0,1,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,1,1,0,1,0,1,1,0,1,1,0,0,0,0,0,1,0,0,1,0,1,1,0,1,0,1,1,1,1,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,1,1,0,1,0,0,1,0,0,1,0,0,0,0,0,1,0,1,0,0,0,0,1,1,0,1,1,0,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,1,0,0,1,1,1,0,1,1,1,1,0,1,0,0,1,0,0,0,1,0,0,0,1,1,0,0,1,0,0,0,0,0,1,1,0,0,0,0,1,1,1,0,0,1,0,1,0,0,1,1,1,1,1,0,1,1,1,1,1,0,0,1,0,0,0,1,1,1,0,1,0,1,1,1,0,0,1,1,1,1,1,0,0,0,0,1,1,1,0,0,0,0,1,1,1,1,1,0,1,1,1,1,1,0,1,1,0,0,1,1,1,1,1,0,0,0,1,1,1,0,0,0,1,1,0,1,0,1,0,0,0,1,1,0,1,1,0,1,0,1,1,1,1,0,0,1,1,0,1,0,0,1,0,1,1,0,1,0,1,1,1,1,0,1,0,0,1,0,1,0,0,0,1,0,1,1,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,1,1,0,0,1,1,1,1,1,0,1,1,0,0,1,0,1,1,0,1,1,0,1,1,1,0,0,0,1,0,1,0,0,1,0,1,1,0,0,1,1,0,1,0,1,0,0,1,0,0,0,1,1,1,0,1,1,1,0,0,1,0,0,0,1,1,1,0,0,1,1,1,1,1,0,1,1,1,1,0,0,1,1,1,0,1,0,0,1,0,1,1,1,0,0,0,0,1,0,1,1,1,0,0,1,1,1,1,1,1,0,1,0,1,0,1,1,0,1,0,1,1,0,1,1,1,1,1,1,0,1,0,0,1,0,1,1,0,0,1,1,0,0,1,1,1,1,1,1,1,1,0,0,0,0,0,1,1,1,1,0,1,0,1,0,1,0,0,0,0,1,1,0,0,0,0,1,1,1,0,0,1,1,1,0};
        int K = 256;
        System.out.println("longestOnes:"+Solution3.longestOnes(A, K));
    }
}
class MyList{
    public int[] array;
    public int length;
    public MyList(int length){
        array = new int[length];
        this.length = 0;
    }
    public void add(int value){
        this.array[length] = value;
        length++;
    }
}
class Solution {
    public static int longestOnes(int[] A, int K) {
        int length = A.length;
        // 把A中连续的0叫0区，连续的1叫1区
        //创建数组存储0区的长度和1区的长度的数量，0区长度记为负数，1区长度记为正数
        MyList count  = new MyList(length);
        int sum = 0,last = A[0];
        for(int i = 0 ; i < length; i++){
            if(A[i] != last){
                count.add(last == 1 ? sum : -sum);
                sum = 1;
            } else{
                sum ++;
            }
            last = A[i];
        }
        // 把最后一串0或1记录下来
        count.add(last == 1 ? sum : -sum);
        // 在count末尾补一个长度为0的1区，这样就保证count末尾一定是1区了，方便后面计算
        count.add(0);
        // 记录count中所有负数的下标
        MyList indexOfZero = new MyList(count.length);
        for(int i = 0; i < count.length; i++){
            if(count.array[i] < 0){//用<0判断，去掉count末尾的长度为0的1区的影响
                indexOfZero.add(i);
            }
        }
        // max记录所有可能会是最大值的值
        int realMax = 0;
        // ways记录每一片0区，靠右填充j个1时，0区右边的1区能连接起来的最多的1的长度
        int [][] ways = new int[indexOfZero.length+1][K+1];
        // ways第一列初始化为第一个1区或0
        for(int i = 0;i<K+1;i++){
            ways[0][i] = Integer.max(count.array[0], 0);
        }
        for(int i = 1;i<indexOfZero.length+1;i++){//i为第几个0区
            int indexOf0 = indexOfZero.array[i-1];
            int wideOf0 = -count.array[indexOf0];
            //Input: A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
            //count.array=[-2,2,-2,3,-1,2,-3,4,0]
            //往0区左边填充1,考虑把1填充到当前0区还是之前的0区，将结果与最大值比较
            for(int j = 0;j<K+1;j++){//j为给之前的0区填充多少个1
                if(K-j<wideOf0){
                    if(ways[i-1][j]+K-j > realMax){
                        realMax = ways[i-1][j]+K-j;
                    }
                }else{
                    if(ways[i-1][j]+wideOf0+count.array[indexOf0+1] > realMax){
                        realMax = ways[i-1][j]+wideOf0+count.array[indexOf0+1];
                    }
                }
            }
            //往0区右边填充1，优先把1填充到当前0区
            for(int j = 0;j<K+1;j++){//j为给当前的0区填充多少个1
                if(j<wideOf0){
                    ways[i][j] = count.array[indexOf0 + 1] + j;
                } else{
                    ways[i][j] = count.array[indexOf0 + 1] + wideOf0 + ways[i-1][j-wideOf0];
                }
            }
        }
        //把ways最后一列加入max
        for(int j = 0;j<K+1;j++){
            if(ways[indexOfZero.length][j] > realMax){
                realMax = ways[indexOfZero.length][j];
            }
        }

        return realMax;
    }
}

class Solution2{
    public static int longestOnes(int[] A, int K) {
        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
        int q = 0;
        int max = 0;
        for(int num : A){
            if(num == 0){
                if(queue.size() > max)
                    max = queue.size();
                queue.addLast(num);
                q++;
                if(q > K){
                    while(queue.removeFirst() != 0){}
                    q--;
                }
            } else{
                queue.addLast(num);
            }

        }
        if(queue.size() > max)
            max = queue.size();
        return max;
    }
}

class Solution3{
    public static int longestOnes(int[] A, int K) {
        int start = 0,end = 0;
        int sizeOfZero = 0;
        int max = 0;
        for(int i = 0; i<A.length; i++){
            if(A[i] == 0){
                if(end - start > max)
                    max = end - start;
                end++;
                sizeOfZero++;
                if(sizeOfZero > K){
                    while(A[start] != 0){
                        start++;
                    }
                    start++;
                    sizeOfZero--;
                }
            } else{
                end++;
            }
        }
        if(end - start > max)
            max = end - start;
        return max;
    }
}
