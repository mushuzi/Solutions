/**
*LZS
*Solution209:给定一个正整数数组nums和一个正整数s，寻找nums中满足和大于s的最短子序列的长度，如果不存在，则返回0.
*
*思路：双指针法。设置两个指针slow和fast。
*	1.fast一直向前走，直到走过的元素之和大于等于s，
*	2.然后slow一直向前走，直到由fast所走元素构成的和减去slow走过元素的构成的和小于s。
*	3.同时更新res的值。
**/

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0)    return 0;
        int sum = 0, res = Integer.MAX_VALUE;
        int slow = 0, fast = 0;
        
        while(fast < nums.length){
            sum += nums[fast++];
            while(sum >= s){
                res = Math.min(res, fast - slow);
                sum -= nums[slow++];
            }
        }
        return (res == Integer.MAX_VALUE) ? 0 : res;
    }
}