/**
*LZS
*Solution139: Word break
*
*思路1：这道题我首先想到的是用回溯法来解，但是时间是指数级别的，超时！
*
*思路2：参考网上的大神，发现这道题可以用动态规划DP来解。
*动态规划的几个要素：
*	1.构建数组或者其他数据结构来保存需要的信息（一般都是数组），记为dp[n + 1]
*	2.确定初始条件，有初始条件意味着保存信息所用的数组需要比给定数据量大小多一个空间，并且dp[0] = true或者dp[0] = 1，视情况而定
*	3.确定递推式（如何在递推中保存有用的信息）
*
*在此题中，我们来进行一一映射：
*	1.题目中要求对数组进行判断，输出是布尔型，所以构建布尔型dp数组
*	2.由于需要保存初始条件，所以dp数组的长度为s.length() + 1，并且为了出发动态规划的进行，dp[0]设置为true
*	3.s能拆成功的话，则存在 0 < i < s.length(),使得s.substring(0, i)是wordDict中的字符串，并且s.substring(i, s.length())可拆，而
*s.substring(i, s.length())可拆，意味着dp[i]= true。因此，递推式为当dp[i] == true && wordDict.contains(s.substring(i, j)时，使得dp[j] =true。因此，递推式为当dp
*	最后，如果s满足题目给定的条件，则dp的最后一位一定为true，反之，s不可拆。返回最后一位即可
**/

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean f[] = new boolean[s.length() + 1];
        f[0] = true;
        
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                if(f[j] && wordDict.contains(s.substring(j, i))){
                    f[i] = true;
                    break;  //break 跳出当层循环，而不是跳出多层循环！！！这里理解错了，导致题一直做不出来！！！
                }
            }
        }
        
        return f[s.length()];
    }    
}