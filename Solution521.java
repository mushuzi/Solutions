/**
*LZS
*Soution521:求两个字符串的最长非公共子串的长度
*
*思路：这道题很简单，如果两个字符串不想同，则最长非公共就是较长的那个字符串。若相同，则不存在最长非公共，返回-1
*
*需要注意的一点是：判断两个字符串的值是否相等，需要使用equals()方法进行判断，
*	而不能使用“==”进行判断，因为“==”判断的是两个字符串的地址是否相等
**/

class Solution {
    public int findLUSlength(String a, String b) {
        if(a == null || b == null)  return -1;
        
        if(a.equals(b))    return -1;
        else    return a.length() > b.length() ? a.length() : b.length();
    }
}