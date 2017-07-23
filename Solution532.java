/**
*LZS
*Solution532:寻找数组中的K-diff对的个数，K-diff对是指数组中包含的两个索引不同的元素i和j,其绝对差值为给定的k。
*首先明确几个特殊情况：
*	1.数组可能为空，此时应返回0；
*	2.数组元素可能不超过两个，此时不满足“对”的概念，也应该返回0
*	3.数组中可能有重复元素，例如{3,1,4,1,5}，对于重复的对只能算一次。
*	4.k<0时无意义，此时也应该返回0。
*	5.k=0时，由于nums[i]+0=nums[i]，而根据题意这种情况是不对的，要避免这种映射到自身的情况发生
*
*思路（自己想的，效率比较低，但是很好理解）：
*	1.定义两个list1和list2，分别用来存放nums中的元素和已经检查过且满足k-diff对条件的元素；
*	2.遍历nums，针对当前元素，每次都删除list1中的对应元素，再判断nums[i]+k是否在list1中且nums[i]是否不在list2中，
*	如果两个条件都满足，则将当前元素添加进list2中；
*	3.最后返回list2的大小，即为要找的K-diff对的数量。

*说明：
*	1.在代码中每次判断之前要先将nums[i]从list1中删去，是为了避免特殊情况5所述的在k=0时映射到元素自身的情况。
*	2.在代码中每次先将nums[i]从list1中删去，判断完后再添加回来，是为了保证nums和list1中的元素一一对应，索引不变
**/

public class Solution {
    public int findPairs(int[] nums, int k) {
        
		if(nums==null || nums.length==0)    return 0;
        if(k<0) return 0;
        
        List<Integer> list1=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
        
        for(int item:nums)	list1.add(item);
        
        for(int i=0;i<nums.length;i++){
            list1.remove(i);
            if(list1.contains(nums[i]+k) && (!list2.contains(nums[i])))
                list2.add(nums[i]);
            list1.add(i,nums[i]);
        }
        return list2.size();
        
    }
}