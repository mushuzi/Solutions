/**
*LZS
*Solution557:给定一个由若干单词和空格组成的字符串，将字符串中每个单词翻转，但保持单词顺序不变
*
*示例：Input: "Let's take LeetCode contest"
*		Output: "s'teL ekat edoCteeL tsetnoc"
*
*思路1：使用栈完成。申明一个栈来存放每个单词中的字母，每当遇到空格时，将栈中元素出栈组成新的单词，
*		最后将这些新的单词串接起来即可
*
*思路2：使用StringBuilder类提供的reverse()方法实现
*	1.以空格为分界，使用split()方法将字符串转化成由若干个单词组成的字符串数组
*	2.针对每一个单词，使用StringBuilder的reverse()方法实现翻转
*	3.使用StringBuilder的append()方法将翻转后的单词拼接起来，并返回。
**/

//思路1：
class Solution {
    public String reverseWords(String s) {
        if(s==null) return null;
        String res="";
        
        Stack<Character> stack=new Stack<>();
        int i=0;
        while(i<s.length()){
            if(s.charAt(i)==' '){
                String temp="";
                while(!stack.empty())
                    temp+=stack.pop();
                res+=temp+" ";
            }
            else
                stack.push(s.charAt(i));
            i++;
        }
        while(!stack.empty()){
            res+=stack.pop();        
        }
        return res;
	}
}

//思路2： 
class Solution {
    public String reverseWords(String s) {        
        String[] str=s.split(" ");
        for(int i=0;i<str.length;i++)
            str[i]=new StringBuilder(str[i]).reverse().toString();
        StringBuilder res=new StringBuilder();
        for(String st:str)
            res.append(st+" ");
        return res.toString().trim();
    }
}