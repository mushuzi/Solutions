/**
*LZS
*Solution 414:给定非空整型数组，返回数组中第三大元素，如果数组元素不满三个，则返回最大的那个元素。
*几种需要考虑的特殊情况：
*	1.数组元素个数可能不足三个，例如[1,2];
*	2.数组中可能包含有重复元素，如果[1,2,3,2];
*	3.数组长度可能超过三个，但是不同的元素不到三个，如果[1,2,2,2,2].
*思路：
*	1.首先用Arrays.sort(nums)对数组排序；
*	2.用一个list来存放排序后的nums元素，重复的元素不再加入list中
*	3.判断list的大小，如果达到三个，则说明已经找到了第三大元素，则终止循环；
*	4.如果list的大小不足三个，则后面不存在第三大元素，返回最大的元素。
**/

public class Solution414 {
    public static int thirdMax(int[] nums) {
        
        Arrays.sort(nums);
        
        List<Integer> list=new ArrayList<>();
        int thirdMax=0;
        
        for(int i=nums.length-1;i>=0;i--){            	
            if(!list.contains(nums[i]))    list.add(nums[i]);
            if(list.size()==3) {
            	thirdMax=list.get(2);
            	break;
            }
        }  
        if(list.size()<3)	thirdMax=list.get(0);
        return thirdMax;
    }
}