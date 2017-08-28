/**
*LZS
*Solution453:给定一个长度为n的非空整形数组nums，每步可以给n-1个元素加一，求经过多少步可以使得所有元素等大小。
*
*思路：这其实是一个数学问题，n-1个元素同时加一等价于1个元素减一
*	1.给数组排序，求出数组中的最小的那个数min
*	2.遍历数组，所求次数为nums[i]-min的累加和
**/

class Solution {
    public int minMoves(int[] nums) {
        if(nums.length==0)  return 0;
        Arrays.sort(nums);
        
        int res=0;
        for(int num:nums){
            res+=num-nums[0];
        }
        return res;
    }
}