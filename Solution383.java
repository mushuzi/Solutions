/**
*LZS
*Solution383:给定两个字符串ransomNote和magazine，判断ransomNote能否由magazine中的字母组成，并且要求magazine中的字母只能使用一次
*
*思路：考察两个字符串之间的字母的对应关系
*	1.声明一个长度为26的temp数组，用来存放26个字母在magazine中的出现次数
*	2.遍历ransomNote，每次出现一个字母，就在temp中将对应位置的数减一
*	3.检查temp数组，若数组中出现小于0的数，则返回false，否则返回true
**/

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] temp = new int[26];
        
        for(char c : magazine.toCharArray())  temp[c - 'a']++;
        
        for(char c : ransomNote.toCharArray())  temp[c - 'a']--;
        
        for(int i : temp){
            if(i < 0)   return false;
        }
        return true;
    }
}