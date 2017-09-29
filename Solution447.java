/**
*LZS
*Solution447:Number of Boomerangs
*	给定一组二元组组成的点（i,j,k)，寻找满足|j-i|=|k-i|的三元组的个数
*
*示例：
*	Input:[[0,0],[1,0],[2,0]] 	Output: 2
*
*	Explanation: The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
*
*思路：
*	1.本题涉及到两点之间的距离，肯定需要计算距离。为方便起见，将计算距离的代码封装在一个方法中：
*		private int getDistance(int[] a, int[] b)	//输入为两个坐标点（用数组表示）
*	
*	2.怎样找到具有相同距离的组合？
*		针对当前的点points[i],计算剩下的所有点points[j]到points[i]的距离，将距离作为键存放在map中，对应的相同
*	距离的组合个数作为值存放在map中，直到以points[i]作为参考节点，遍历完所有剩下的节点为止。
*
*	3.以points[i]作为参照，怎么计算可以产生的组合数？
*		遍历完所有以points[i]为参照的点之后，所有可能的距离值以及对应的组合个数都存放在了map中，以示例为例：
*	假设以points[1]为参照点，遍历完后map={(1,2)},即和points[1]距离为1的点有两个，这个这两个点与points[1]就可以组成
*	一个满足条件的三元组，即组合数为val * (val - 1),对于map中的值，依次累加即可。
*
*	4.正因为map是针对当前特定的points[i]存储的，所以当i后移时，map要记得清空，进行下一次points[i+1]对应的存储。
**/

class Solution {
    public int numberOfBoomerangs(int[][] points) {
        if(points == null || points.length < 3 || points[0] == null || points[0].length == 0)   return 0;
        int m = points.length;  //int n = 2;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();    //只对一个points[i]有效，到points[i+1]之前需要clear，然后重新填入数据
        for(int i = 0; i < m; i++){
            for(int j = 0; j < m; j++){
                if(i == j)  continue;
                int dis = getDistance(points[i], points[j]);
                map.put(dis, map.getOrDefault(dis, 0) + 1);     //将除了points[i]以外所有的点到points[i]的距离作为键存储，相同距离的组合个数作为值存储
            }
        
            for(int val : map.values())
                res += val * (val - 1); //相同距离的组合个数大于等于2时，可以和当前的points[i]组成一个三元组，组合方式有val * (val - 1)种。
            map.clear();
        }
        return res;
    }
    
    private int getDistance(int[] a, int[] b){
        int disX = a[0] - b[0];
        int disY = a[1] - b[1];
        return disX * disX + disY * disY;
    }
} 
