/*
直方图盛水
给定n个非负整数,表示直方图方柱高度,方柱宽度假定为1,假设用这个形状的容器盛水,求其最大盛水量。
*/
package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(new Solution().arrayWallSaveWater(new int[]{6,3,2,0,3,2,0,1,5,6,4,3,7,5,4,0,3,2,5,8,2,4}));
    }
}

class Solution {
    public int arrayWallSaveWater(int[] A){
        int sum = 0;
        int i = 0, j = A.length - 1;
        int leftHightest = 0;
        int rightHightest = 0;
        while(i < j){
            if(A[i] > A[j]){
                leftHightest = Math.max(leftHightest, A[i]);
                rightHightest = Math.max(rightHightest, A[j]);
                sum += rightHightest - A[j];
                j--;
            }else{
                rightHightest = Math.max(rightHightest, A[j]);
                leftHightest = Math.max(leftHightest, A[i]);
                sum += leftHightest - A[i];
                i++;
            }
        }
        return sum;
    }
}