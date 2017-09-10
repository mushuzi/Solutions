/**
*LZS
*Solution287:给定一个包含n+1个整数的数组，其包含的所有整数都在1~n之间，则必然会存在一个重复元素。假定数组中只存在一个重复元素，找到这个重复元素。
*要求：
*	1.不能对数组进行修改
*	2.只能使用O(1)的空间复杂度
*	3.时间复杂度不能超过O(n*n)
*	4.数组中只存在一个重复数字，但是这个重复数字可能会重复多次
*
*思路：
*	这道题如果没有要求1，则可以简单地对数组进行排序，然后判断即可
*	在上面4个要求下，使用二分法解此题。
*	1.先找到数组中最小的元素l = 1和最大的元素r = nums.length-1; 定义其中间值mid = (l + r) / 2;
*	2.每次寻找最小数l和中值mid之间按照递增顺序，本来应该有的元素个数leftLen = mid - l + 1;
*		寻找实际上nums中在最小值l和中值mid之间的元素个数count（遍历nums）实现
*	3.如果leftLen < count，则说明重复元素一定在l~mid的区间里，下一次判断使得l不变，r = mid;
*		否则，重复元素一定在mid~r的区间里，下一次判断使得l = mid, r不变。
*	4.当l和r之间相差为1时，如果leftLen < count, 则说明重复元素就是l，否则，重复元素是r；
*	5.二分循环条件while(l < r)
**/

class Solution {
    public int findDuplicate(int[] nums) {
        if(nums == null || nums.length <= 1)    return -1;  //异常情况下返回-1；
        
        if(nums.length == 2)    return 1;   //数组长度为2的特殊情况下，重复元素必然是1；
        
        int l = 1, r = nums.length - 1; //l是数组中的最小数；r是数组中的最大数;mid是l和r的中值（注意不是指索引）
        int mid = (l + r) / 2;        
        
        while(l < r){   //循环条件是l<r
            int leftLen = mid - l + 1;  //计算mid和l之间不重复情况下的理应有的元素个数
            int count =0;
            
            //统计实际上nums中l和mid之间存在的元素个数
            for(int num : nums){
                if(num >= l && num <= mid)  count++;
            }
            
            //二分终止的边界条件是l+1==r；具体返回l还是r需要视count和leftLen的相对大小而定
            if(l + 1 == r){
                if(count > leftLen) return l;
                else    return r;
            }
            
            //不满足二分终止条件时根据条件，修改r、l和mid
            if(count > leftLen) r = mid;             
            else    l = mid;
            
            mid = (l + r) / 2;
        }
        return -1;
    }
}