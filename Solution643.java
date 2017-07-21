/**
*LZS
*Solution643：求最大平均子串。给定一个长度为n的整型字符串，求出连续k个元素的最大平均值
*
*思路1：暴力求解，每次用累加求出k个连续元素的和，再比较大小。这样需要两层循环，外层进行nums.length-k+1次循环，
*		内层进行k次循环，总共进行（nums.length-k+1）*k次循环，时间复杂度为O(nums.length*k)级别，时间超时！
*
*思路2：使用滑动窗口模型.每次还是求出k个连续元素的和，再比较大小，但不同的是不再用求和的方式求k个连续元素的和，
*		而是维持一个大小为k的窗口，每次当前所求的和为前一次求得的和加上进入窗口的值的大小再减去离开窗口的值的大小，这样就可以避免由
*		累加带来的额外的复杂度，时间复杂度为O(nums.length)+O(k)！
**/


public class Solution643 {
    public double findMaxAverage(int[] nums, int k) {
        double res = 0;
        for(int i=0;i<k;i++)
            res+=nums[i];
        double sum = res;
        for (int s = 1; s < nums.length - k + 1; s++) {    
            sum+=nums[s+k-1]-nums[s-1];
            res = Math.max(res, sum);
        }
        return (double)res/k;
    }
}