/*
https://leetcode-cn.com/problems/water-and-jug-problem/description/
有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？

如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。

你允许：

装满任意一个水壶
清空任意一个水壶
从一个水壶向另外一个水壶倒水，直到装满或者倒空
*/
package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(new Solution().canMeasureWater(5, 3, 4));
    }
}
class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if(z < 0 || z > x+y){
            return false;
        }
        int subed,sub;
        if(x > y){
            subed = x;
            sub = y;
        }else{
            subed = y;
            sub = x;
        }
        if(sub == 0){
            return z == 0 || z == subed;
        }
        while(subed % sub != 0){
            int temp = subed;
            subed = sub;
            sub = temp % sub;
        }
        return z % sub == 0;
    }
}