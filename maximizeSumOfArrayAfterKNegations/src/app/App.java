/*
https://leetcode-cn.com/problems/maximize-sum-of-array-after-k-negations/
1005. K 次取反后最大化的数组和
给定一个整数数组 A，我们只能用以下方法修改该数组：我们选择某个个索引 i 并将 A[i] 替换为 -A[i]，然后总共重复这个过程 K 次。（我们可以多次选择同一个索引 i。）
以这种方式修改数组后，返回数组可能的最大和。
*/
package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(new Solution().largestSumAfterKNegations(new int[]{-8,3,-5,-3,-5,-2}, 6));
    }
}

class Solution {
    public int largestSumAfterKNegations(int[] A, int K) {
        int[] count = new int[201];
        int sum = 0;
        for(int i = 0; i < A.length; i++){
            sum += A[i];
            count[A[i] + 100]++;
        }
        for(int i = 0; i < 100; i++){
            if(count[i]>0){
                if(K >= count[i]){
                    K -= count[i];
                    sum -= (i - 100) * count[i] * 2;
                    count[200 - i] += count[i];
                    count[i] = 0;
                } else {
                    count[i] -= K;
                    count[200 - i] += K;
                    sum -= (i - 100) * K * 2;
                    K = 0;
                }
            }
        }
        if(K % 2 == 1 && count[100] == 0){
            for(int i = 101; i <= 200; i++){
                if(count[i] > 0){
                    sum -= (i - 100) * 2;
                    break;
                }
            }
        }
        return sum;
    }
}