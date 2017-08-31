/**
*LZS
*Solution455；分配饼干。给定两个整形数组g和s，g的长度表示孩子的个数，g中元素的大小代表满足该孩子至少需要多大的饼干
*	s的长度表示现有的饼干的个数，s中元素的大下代表饼干的大下。求在给定条件下能满足孩子的个数
*
*思路：这道题看似很复杂，实际上很简单，使用两个指针i和j分别指向g和s中的元素，再比较其大小关系即可。
*	具体实现看代码：
*
*注意：显然本题与两个数组中的元素的大小有关，于是先将两个数组从小到大排序
**/

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if(g == null || s == null)  return 0;
        
        int i = 0, j = 0, count = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        
        while(i < g.length && j < s.length){
            if(g[i] <= s[j]){
                count++;
                i++;
                j++;
            }
            else    
                j++;
        }
        return count;
    }
}
