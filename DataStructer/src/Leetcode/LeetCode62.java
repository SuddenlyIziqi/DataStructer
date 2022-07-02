package Leetcode;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 *
 * 问总共有多少条不同的路径？
 *
 *
 *输入：m = 3, n = 7
 * 输出：28
 *
 *
 *
 * 解题思路
 *
 * ⭐️利用排列组合
 * ⭐️C(m-1,m+n-2) = (m+n-2)!/((m-1)!(n-1)!)
 * ⭐️核心在于避免溢出问题
 * 以下程序主要是为了解决溢出
 *
 * 处理方法核心： 抵消分子分母重合部分，分为两部分
 * 处理核心步骤：
 * 1.一开始的阶乘方程式就直接抵消掉一部分分子分母
 * 2.分子可以整除分母的时候直接整除
 *
 * Tips
 * 1.int max = Math.max(m-1,n-1) 并不是没有用的，这样方便直接抵消较多部分的分子分母
 * 2.使用double而不使用 long 是因为当除不尽的时候也会有个位数为0的情况
 *
 *
 *
 * 作者：hrigh
 * 链接：https://leetcode-cn.com/problems/unique-paths/solution/pai-lie-zu-he-jie-jue-yi-chu-wen-ti-by-h-oa3g/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


 */
public class LeetCode62 {
   static int ans = 0;

    public static void main(String[] args) {
        int i = uniquePaths(40, 40);
        System.out.println("i = " + i);
    }
    public  static  int uniquePaths(int m, int n) {
        //利用排列组合
        //C(m-1,m+n-2) = (m+n-2)!/((m-1)!(n-1)!)
        //核心在于避免溢出问题
        int max = Math.max(m-1,n-1); //求分子中最大的值，用于分子和分母直接尽可能多的抵消（防止溢出）
        int min =(m+n-2)- max;
        double j = 1.0; //为分子
        double k = 1.0; //为分母
        for(int i = 1;i<=m+n-2;i++){
            if(i>max) j*=i;  //1.直接抵消掉 重合的部分分子和分母（防止溢出）
            if(i<=min)  k*=i;// 求出剩余的分母
            if(j>=k && k!=1.0 && j%k==0.0) {
                //2.分子可以整除分母的时候直接整除（防止溢出）
                j=j/k;
                k=1.0;
            }
        }
        return (int)(j);
    }
    /*public static void main(String[] args) {
        int i = uniquePaths(51, 9);
        System.out.println("i = " + i);

    }
    public static int uniquePaths(int m, int n) {
        dfs(m,n,0,0);
        return ans;
    }

    public static void dfs(int m, int n,int x,int y){
        if(x==m-1||y==n-1) {
            ans++;
            return;
        }
        for (int i = 0; i < 2; i++) {
            if(i==0){
                x++;
                dfs(m,n,x,y);
                x--;
            }else {
                y++;
                dfs(m,n,x,y);
                y--;
            }


        }

    }*/
}
