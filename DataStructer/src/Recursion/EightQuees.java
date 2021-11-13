package Recursion;

/**
 *  八皇后
 *  判断条件：8个棋子不能再同一排，同一列，或同一斜线
 *  思路
 *  1.第一个皇后放在第1行第1列
 *  2.第二个皇后放在第2行，第1列，判断是否ok，如果不ok，那么放第2行第2列，第3列,第4列。。。。找到合适的
 *  3.第三个皇后放在第2行，第1列，判断是否ok，如果不ok，那么放第2行第2列，第3列,第4列。。。。找到合适的
 *  4.当得到一个正确的解时，在栈回退到上一个栈时，就会开始回溯，即 将第一个皇后，放到第一列的所有正确解全部的得到
 *  5，回头继续第一个皇后放第二列，后面继续循环1-4；
 *
 *  说明：
 *  理论上 八皇后应该用二维数组，实际上可以通过算法，用一个一维数组来表示
 *  arr[8] = {1,2,3,4,5,6,78}
 *  arr[i] i代表第i+1个皇后，数组下标代表 第 i+1行， 也就是 i 及代表是 第i+1个皇后 也代表 第 i+1行，
 *  arr[n] 具体元素代表第 n+1 列
 */
public class EightQuees {
    public static void main(String[] args) {
        check(0);
        System.out.println("checkCount = " + checkCount);
        System.out.println("judgeCount = " + judgeCount);
        System.out.println("success = " + success);
    }

    //定义一个max代表一共多少个皇后
    static int  max = 8;
    static int  success = 0;
    static int  checkCount = 0;
    static int  judgeCount = 0;

    //定义一个数组array 保存 棋盘信息   递归的时候 数组是可以共享的
    static int[] array = new int[max];

    public static void check(int n){
        checkCount++;
        if(n==max){
            //n= max =8，其其实8个皇后已经放好了
            print();
            return;
        }
        //下面涉及核心递归
        //依次放入皇后马斌判断是否冲突
        for (int i = 0; i < max; i++) {
            //先把当前黄后n, 放入该行的第 i列 从1 开始
            array[n]=i;
            //check判断是否可以
            if(judge(n)){
                //如果check判断可以 则继续放下一个皇后n+1 进入递归
                check(n+1);
                //
            }
            //check判断不可以，则回溯当前皇后 n 继续遍历i 判断下一列 i+1是否可以
        }
    }

    /**
     * 判断条件
     *      ：同一排，同一列，或同一斜线
     *      当我们放第 n 个皇后时，就是检测该皇后是否和前面已经摆放的皇后冲突
     *       同一列：     元素相同=在同一列  array[i]==array[n]
     *       同一排：     index相同=在同一行  i==n (因为一直递增所以不会重复行，所以实际代码中无需对此校验)
     *       同一斜线：   两点之间 横坐标和竖坐标 差模 一样大（想象一下：等腰指教三角形非直角定点 到指教的距离一样）
     *                  * * * *
     *                  * * * *
     *                  * * * *
     *                  * * * *
     *                  两点纵坐标之差  ==   两点横坐标只差
     *                  Math.abs(n-i)==Math.abs(array[n]-array[i])
     */
    public static boolean judge(int n){
        judgeCount++;
        for (int i = 0; i < n; i++) {
            //元素相同=在同一列
            //index相同=在同一行
            if(array[i]==array[n]){
                return false;
            }else if(Math.abs(n-i)==Math.abs(array[n]-array[i])){
                //在同一斜线上
                return false;
            }
        }
        return true;
    }

    /**
     * 打印输出
     */
    public static  void  print(){
        success++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
    /**
     * 打印输出检查次数
     */
    public static  void  countCheck(){

        System.out.println();
    }
}
