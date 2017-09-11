/**
*LZS
*Solution621:任务调度器：给定一个由A~Z大写字母组成的字符数组tasks表示不同的任务，每个任务需要一个interval完成，
*	每个interval，CPU可以执行一个任务，或者处于闲置状态，每两个相同任务之间必须至少间隔n个interval，问经过多少个interval可以完成给定任务。
*
*思路：先给出两个例子来说明实现的过程
* input：AACCCDDEEE 3
*	1.先统计字母出现的频次，找到最高的频次，本例中为3，最高频次的字母为C和E
*	2.两个相同字母之间至少间隔3个interval，则可以以n+1=4位单位，即CE##CE##CE，#表示一个尚未安排的interval，剩下的字母
*	就在这些#的位置插入即可，可以观察，上述排列组合中总共有(最高频次-1)*(n+1)+最高频次的字母个数=(3-1)*(3+1)+2=10个位置，这就是所求的interval总数.
*
*input：AACCCBEEE 2
*	按照上述方式有排列组合：CE#CE#CE,还剩两个空位，而还有AAB三个任务没有安排，则可以安排为CEACEACEB，此时应返回的是tasks数组的长度
*
*有了以上两个例子，相信不难理解本题的做法了！
**/


class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        //1.构造长度为26的数组temp统计字母出现的频率
        int[] temp = new int[26];
        for(char c : tasks) temp[c - 'A']++;
        
        //2.对temp排序，得到字母出现的最高频率temp[25]，注意是最高频率，而不是最高频率的字母！！！
        Arrays.sort(temp);
        
        //3.统计达到最高频率的字母的个数
        int count = 0;
        for(int num : temp){
            if(num == temp[25]) count++;
        }
        
        //4.返回结果
        return Math.max(tasks.length, (temp[25]-1) * (n + 1) + count);
        
    }
}