/**
*LZS
*Solution506：给定一个整型数组nums，数组i位置上的元素nums[i]代表运动员i的成绩，要求为这些运动员排名。
*	前三名为金银铜，之后的只需输出他们的相对排名即可
*
*思路：采用数组排序+map的方法解决，具体步骤见代码注释
*
*注意：
*	1.将数组nums的值赋值给temp，不能简单使用“temp=nums”来实现，这是因为数组本质上是地址，nums一变，temp也会变
*	2.数字到字符串的转换可以使用梁中国方法：
*		1）使用String str = String.valueOf(num);
*		2）使用String str = num + " ";
**/

class Solution {
    public String[] findRelativeRanks(int[] nums) {
        
        String res[]=new String[nums.length];
        
        //声明一个临时数组temp，用来对nums排序
        int[] temp=new int[nums.length];
        for(int i=0;i<nums.length;i++)  temp[i]=nums[i];
        Arrays.sort(temp);
        
        //声明一个map，存储不同分数对应的排名
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<temp.length;i++)  map.put(temp[i], temp.length-i);
        
        //遍历nums，根据nums中分数与map中排名的对应关系，将对应的排名转化为string
        for(int i=0;i<nums.length;i++){
            if(map.get(nums[i])==1) res[i]="Gold Medal";
            else if(map.get(nums[i])==2) res[i]="Silver Medal";
            else if(map.get(nums[i])==3) res[i]="Bronze Medal";
            //else    res[i]=String.valueOf(map.get(nums[i]));
            else    res[i]=map.get(nums[i])+"";
        }
        return res;
    }
}