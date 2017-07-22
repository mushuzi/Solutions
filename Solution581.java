/**
*LZS
*Solution581:给定一个整型数组，返回满足子数组的长度，使得该数组按升序排列后整个数组也是按升序排列。
*思路1（我自己的思路，效率很低）：依次遍历数组元素，对当前元素nums[i]，依次与其之后的元素nums[j]比较（从后往前的顺序）
*	当出现nums[j]<nums[i]时，分别记录下所有遍历过的满足比较条件的元素的最小索引min和最大索引max。最后判断max>min是否成立，
*	若成立，则返回max-min+1;否则，返回0.
*
*思路2（参考网上，效率更高）：先用一个数组temp保存nums的值，然后对temp进行排序，然后比较temp和nums两个数组出现不同之处的
*	第一个位置和最后一个位置，并分别用start和end记录，最后返回end-start+1就是要找的长度。
*这里需要注意一点，Java中数组的复制不是值传递，而是引用传递，简单的使用int[] temp=nums的方法是不行的，因为这种方式只是
*	方式传递的是引用，之后改变其中一个数组另一个也会跟着变化。因此在程序中使用for循环来复制nums到temp中。也可以使用
*	Java自带的copyOf方法：int[] copy=Arrays.copyOf(nums,nums.length).
**/


//思路1代码
public class Solution581 {
    public static int findUnsortedSubarray(int[] nums) {
        if(nums==null || nums.length<2) return 0;
        
        int count=0;
        int max=0;int min=nums.length-1;
        
        for(int i=0;i<nums.length;i++){
            for(int j=nums.length-1;j>i;j--){
                if(nums[j]<nums[i]){
                    max=Math.max(max, j);
                    min=Math.min(min, i);
                    break;
                }
            }
        }
        if(max>min)
            count=max-min+1;
        return count;
	}
}


//思路2代码
public class Solution {
    public static int findUnsortedSubarray(int[] nums) {
        if(nums==null || nums.length<2) return 0;
		int n=nums.length;
        int[] temp=new int[n];
		
        for(int i=0;i<n;i++)
            temp[i]=nums[i];
        Arrays.sort(temp);
        
        int start=0,end=n-1;
        
        while(start<n && nums[start]==temp[start])
            start++;
        
        while(end>start && nums[end]==temp[end])
            end--;
		
        return end-start+1;
	}
}