/**
*LZS
*Solution541: 给定一个字符串s和整数k，将字符串从开头到结尾每2*k个字母的前k个字母翻转顺序，不足k个字母时全部翻转
*	不足2*k个字母时只翻转前k个字母，其他的保持不变
*
*思路1（自己想的，逻辑还是很清晰的，但是代码很繁琐，效率不高）
*	1.利用栈的思想实现字符串的倒序，并封装到一个reverse方法中；
*	2.针对s.length()与2*k之间的关系进行讨论
*
*思路2（官方做法，代码简洁，效率很高）
*	1.将字符串转化成字符数组
*	2.采用间隔为2*k的外层循环遍历字符数组中的每一个2*k，采用间隔为1的内层循环遍历每个2*k中的前k个元素，并实现翻转
*	3.翻转的过程采用前后双指针的方法进行简单的数据交换，避免了借助复杂数据类型stack来实现，终止条件是前指针<后指针
*/

//思路1 
class Solution {
    public String reverseStr(String s, int k) {
        
        int flag = s.length() / (2*k);
        
        if(flag == 0){  //说明s.length()<2*k;接下来需要判断s.length()与k的关系
            if(s.length() < k) return reverse(s);   //长度小于k时，全部要做倒序操作
            else{   //k <= s.length() < 2*k，需要先将前k个字母倒序，再与剩下的字母拼接并返回
                return reverse(s.substring(0,k)) + s.substring(k, s.length());
            }
        }
        
        //针对s.length() >= 2*k的情况进行讨论
        int i=0;
        String temp="";
        while(i < flag){
            temp += reverse(s.substring(2*k*i, 2*k*i+k)) + s.substring(2*k*i+k, 2*k*i+2*k);
            i++;
        }
        
        //针对s.length()%(2*k)的部分进行处理
        if(s.length() % (2*k) < k)  return temp + reverse(s.substring(flag*2*k, s.length()));
        else    return temp + reverse(s.substring(flag*2*k, flag*2*k+k)) + s.substring(flag*2*k+k, s.length());
    }
    
    //专门负责将字符串倒序输出的方法，在主方法中输入参数会是s的各个满足条件的子串
    public String reverse(String s){
        String res="";
        Stack<Character> stack = new Stack<>();
        
        for(char c : s.toCharArray())   stack.push(c);
        
        while(!stack.empty())   res+=stack.pop();
        
        return res;
        
    }
}

//思路2 
class Solution {
    public String reverseStr(String s, int k) {
        //先把字符串转化成字符数组
        char[] chars= s.toCharArray();
        
        //遍历字符数组
        for(int left = 0; left < chars.length; left += 2*k){ //left以2*k的间隔递增
            for(int i=left, j=Math.min(left+k-1, chars.length-1); i<j; i++, j--){
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
            }
        }
        return new String(chars);
    }
}