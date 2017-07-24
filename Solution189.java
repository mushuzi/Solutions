/**
*LZS
*Solution189:给定一个整形数组和整数k，将数组nums中的元素依次向后移动k个位置，超出索引的元素循环到nums开头
*例如：输入：[1,2,3,4,5,6,7]  输出：[5,6,7,1,2,3,4].
*思路1（时间复杂度和空间复杂度均为O(n)）：
*	1.申明一个新的数组temp，每次移动到元素放置到temp中对应的位置，再将temp中的元素赋值给nums
*	2.索引的对应规则为(index+k)%nums.length;
*
*思路2（时间复杂度为O(n)，空间复杂度为常数）：
*	1.直接从start索引开始按照顺序遍历nums，同时将元素移动到对应的位置上去，直到回到开始的索引start位置，一次处理结束；
*	2.经过若干次1步骤所示过程，整个nums中的所有元素都被处理完毕。
*	3.可以使用count进行计数，被移动的次数为nums.length时，整个算法结束。
*注意：在思路2中，需要有记录每一轮置换开始的那个索引，代码中为start；每一轮置换中有可能有多次置换，每次置换的
*	源位置的索引用current表示，目的位置的索引用next表示。每一次置换中目的位置上被置换的元素用temp表示，
*	源位置上被处理的元素用prev表示，每一轮置换开始时，prev=nums[start]；每一次置换开始时，prev记录上一个
*	被置换的元素，即prev=temp
**/

//思路1
public class Solution {
    public void rotate(int[] nums, int k) {
        int[] temp=new int[nums.length];
        
        for(int i=0;i<nums.length;i++){
            int tempIndex=(i+k)%nums.length;
            temp[tempIndex]=nums[i];
        }
        
        for(int i=0;i<nums.length;i++)
            nums[i]=temp[i];
	}
}

//思路2：
public class Solution {
    public void rotate(int[] nums, int k) {
		int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }
}