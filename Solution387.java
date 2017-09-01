/**
*LZS
*Solution387:给定一个只包含小写的字符串s，找到字符串中第一个不重复的字符的索引
*
*思路：本题的意思简而言之就是找s中第一个只出现一次的字母的索引
*	1.声明一个长度为26的数组temp，存放s中的字母对应出现的次数
*	2.遍历s中的每个字母，直到找到第一个出现次数为1的字母，则返回该字母的索引
*	3.如果不存在出现次数为1的字母，则返回-1.
*
**/

class Solution {
    public int firstUniqChar(String s) {
        if(s==null || s=="") return -1;
        
        int[] temp=new int[26];
        
        for(int i=0;i<s.length();i++){
            temp[s.charAt(i)-'a']++;
        }
        
        for(int i=0;i<s.length();i++){
            if(temp[s.charAt(i)-'a']==1)  return i;
        }
        return -1;
    }
}