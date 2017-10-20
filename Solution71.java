/**
*LZS
*Solution71:简化路径
*
*思路：
*	定义一个栈来存放有效的路径块
*	1.首先明确简化的规则：
*		1）如果出现多个“//”,只能算一个
*		2）如果路径名是“.”，则不做处理
*		3）如果路径名是“..”，则返回上级目录，对应栈顶元素出栈，如果栈为空，则不做处理
*		4）如果路径名是其他，则进去当前目录，对应入栈
*	2.考虑如何把路径名从各种'/'和'//'之间独立出来
*		利用Java提供的split()方法，该方法输入参数为字符串类型，返回参数为字符串数组类型。对应到这里：String[] strArr = path.split("/");
*	分析切分好的strArr数组：
*		1）数组的第一个元素肯定为空，因为路径都是以'/'开头的，以'/'对path进行划分时，第一个数组元素为空字符串
*		2）如果存在连续的两个斜杠，则会对应数组中会产生一个空字符串
*	举例：  path = "/."		strArr = { , .};
*			path = "/.."	strArr = { , ..};
*			path = "/c/.//cw/../e"	strArr = { , c, . , , cw , .. , e}
*	3.遍历strArr，按照1所给的规则入栈即可，最后将栈中剩下的元素读出来即可。
*
*注意：
*	1.栈为空的时候，返回的应该是“/”，而不是空字符串，即path == "/"时，返回也应该是"/"
*	2.判断字符串的相等，此处应该用值相等的判断标准，即equals()方法，而不能用等号！！！
*	3.最后读栈元素的时候，一定要注意顺序，栈元素自底向上应该对应新路径的从左到右
**/

class Solution {
    public String simplifyPath(String path) {
        if(path == null || path.length() == 0)  return path;
        //1.将path按照'/'划分成字符串数组
        String[] strArr = path.split("/");
        
        //2.定义一个栈，将strArr中的字符串按照规则压栈
        Stack<String> stack = new Stack();
        for(int i = 1; i < strArr.length; i++){
        	String str = strArr[i];
            if(str.equals(".") || str.equals("")){
            	continue;
            }
            	
            else if(str.equals("..")){
            	if(!stack.empty())
            		stack.pop();
            	else
            		continue;
            }
            else
                stack.push("/" + str);
        }
        
        //3.定义StringBuilder对象，把简化后的路径从stack中读出来
        if(stack.empty())   return "/";
        String str = new String();
        while(!stack.empty()){
            str = stack.pop() + str;
        }
        return str;
    }
}