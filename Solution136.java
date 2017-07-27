/**
*LZS
*Solution136:给定一个整型数组，该数组只只有一个元素出现一次，其余元素均出现两次。找出这个只出现一次的元素并返回。
*要求：线性时间复杂度，且不适用额外的空间。

*注意：根据题意，数组nums应该不存在为空的情况，即nums最少包含一个元素。
*
*	思路1（时间复杂度为线性，不占用额外空间，但是排序比较耗时，故而用时较多）：
*	1.先将数组排序
*	2.求得数组中所有不同的元素的和，记为sum1；求得数组中所有元素的和，记为sum2；
*	3.所求元素=2*sum1-sum2.
*
*思路2（时间复杂度为线性，不占用额外空间，速度很快）：
*	两个相同的数按位异或一定为0，一个数和0按位异或一定等于本身！
*	因此把nums中所有元素按位异或，最后得到的数一定是只出现一次的数。
**/

//思路1：
public class Solution {
    public int singleNumber(int[] nums) {
        if(nums.length==1)  return nums[0];
        
        Arrays.sort(nums);
        int sum1=0,sum2=0;
        
        for(int i=0;i<nums.length;){
            sum1+=nums[i];
            i+=2;
        }
        for(int i=0;i<nums.length;i++)
            sum2+=nums[i];
        return 2*sum1-sum2;
	}
}

//思路2：
public class Solution {
    public int singleNumber(int[] nums) {
        int res=0;
        for(int item:nums)
            res^=item;
        return res;
    }
}