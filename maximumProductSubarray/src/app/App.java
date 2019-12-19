/*
乘积最大子序列
https://leetcode-cn.com/problems/maximum-product-subarray/
*/

package app;

// import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception {
        int[] A = {2,3,-2,4};
        System.out.println(new Solution().maxProduct(A));
    }
}

class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int imax = nums[0];
        int imin = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < 0){
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);
            max = Math.max(max, imax);
        }
        return max;
    }
}