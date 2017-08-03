/**
*LZS
*Solution349:给定两个整型数组，找出两个数组共有的元素，以整形数组的形式返回
*
*思路1（时间复杂度为O(n)）：
*	1.构造集合set1，将nums1中的元素全部添加都set1中，由于集合自动处理重复元素，只保留一个，所以重复添加也没关系
*	2.构造集合set2，遍历nums2中的元素，如果set1中包含该元素，则添加到set2中
*	3.构造整型数组res，大小同set2.将set2中的元素依次添加到res中，并返回
*
*注意：这里使用list也可以完成，只是需要注意重复元素的手动处理。因此在处理重复元素时，优先考虑使用Set。

*思路2（时间复杂度为O(nlogn)）：
*	1.将nums1和nums2排序
*	2.使用两个指针i和j，如果nums[i]>nums[j],则j++;如果nums[i]<nums[j],则i++;如果相等，则加入set中
*	3.把set中的元素放到数组中并返回。
**/


//思路1：
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1==null || nums2==null)  return null;
        
        Set<Integer> set1=new HashSet<>();
        Set<Integer> set2=new HashSet<>();
        
        for(int item:nums1) set1.add(item);
        
        for(int item:nums2){
            if(set1.contains(item))
                set2.add(item);
                
        }
        
        int res[]=new int[set2.size()];
        
        int i=0;
        for(int item:set2)
            res[i++]=item;
        return res;
    }
}

//思路2：
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1==null || nums2==null)  return null;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> set=new HashSet<>();
        int i=0,j=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<nums2[j]) i++;
            else if(nums1[i]>nums2[j])    j++;
            else{
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        
        int[] res=new int[set.size()];
        int k=0;
        for(int item:set)   res[k++]=item;
        return res;
    }
}