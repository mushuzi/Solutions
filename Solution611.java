/**
*LZS
*Solution611:给定一个非负整数构成的数组nums，判断nums中能组成三角形的三元组的数目。
*
*注意：对于输入为[2,2,3,4]的情况，存在3组这样的组合：
*	2,3,4   （使用第一个位置上的2）
*	2,3,4	（使用第二个位置上的2）
*	2,2,3	

*思路1：由Solution261的启发，采用回溯法，由于回溯法实际上是将所有情况一一列举出来，所以效率比较低，超时
*
*思路2：采用三指针法！定义三个指针left，right，i，令其对应的nums元素分别是三角形中的最短边、较长边、最长边
*	则满足条件nums[left] + nums[right] > nums[i] 时才能构成一个三角形！
*
*	1.为了完成nums[left]、nums[right]、nums[i] 和三角形最短边、较长边、最长边的对应，应该首先对nums进行排序
*	且任何时候有left < right < i成立。
*
*	2.不难证明当nums[left]、nums[right]、nums[i]满足构成三角形的条件时，介于nums[left]和nums[right]之间的元素
*	也一定和nums[right]、nums[i]构成三角形关系，因此这期间的元素可以不再判断，个数上直接累加right-left即可！
*	
*	3.每次构成一次三角形关系后，left保持不动，right向前移动一位，判断nums[left]、nums[right--]、nums[i]是否
*	存在三角形关系；否则，right不动，left向后移动一位，判断nums[left++]、nums[right]、nums[i]是否存在三角形关系
*
*	4.按照2和3的步骤进行，直到nums[i]与之前的所有nums[left]、nums[right]试过以后（left<right不再满足时），指针后移，
*	继续进行上述步骤。
*
*上述算法的时间复杂度为O(n*n)，空间复杂度为O(1)。
**/


//回溯法
class Solution {
    
    int res = 0;
    
    public int triangleNumber(int[] nums) {
        if(nums.length < 3 || nums == null) return 0;
        
        
        helper(nums, new ArrayList<Integer>(), 0);
        
        return res;
    }
    
    public void helper(int[] nums, ArrayList<Integer> temp, int level){
             
        if(temp.size() == 3 && temp.get(0) + temp.get(1) > temp.get(2) && temp.get(0) + temp.get(2) > temp.get(1) 
             && temp.get(2) + temp.get(1) > temp.get(0) ){
            res++;
            return;
        }
        
        for(int i = level; i < nums.length; i++){
            temp.add(nums[i]);
            helper(nums, temp, i+1);
            temp.remove(temp.size() - 1);
        }
        
    }
}


//三指针法
class Solution {
    public int triangleNumber(int[] nums) {
        
        if(nums.length < 3 || nums == null) return 0;
        int res = 0;
        
        Arrays.sort(nums);
        
        for(int i = 2; i < nums.length; i++){
            int left = 0, right = i - 1;
            
            while(left < right){
                if(nums[left] + nums[right] > nums[i]){
                    res += right - left;
                    right--;
                }
                else
                    left++;
            }
        }
        return res;    
    }
}