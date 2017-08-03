/**
*LZS
*Solution349:给定两个整型数组，找出两个数组共有的元素，以整形数组的形式返回
*
*思路：本题比较简单，使用集合Set实现即可。
*	1.构造集合set1，将nums1中的元素全部添加都set1中，由于集合自动处理重复元素，只保留一个，所以重复添加也没关系
*	2.构造集合set2，遍历nums2中的元素，如果set1中包含该元素，则添加到set2中
*	3.构造整型数组res，大小同set2.将set2中的元素依次添加到res中，并返回
*
*注意：这里使用list也可以完成，只是需要注意重复元素的手动处理。因此在处理重复元素时，优先考虑使用Set。

**/

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
        
        for(int i=0;i<list2.size();i++)
            res[i]=list2.get(i);
        return res;
    }
}