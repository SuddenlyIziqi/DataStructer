package 算法.分治算法;

/**
 * 汉诺塔 ---算法.分治算法
 * 共 num 个 盘，A,B,C 三个塔，初始的 num 都在A上，目标上全部转移到C上
 * 1.如果只有一个盘：num = 1，直接 A -> C
 * 2.如果不止一个盘：num >=2。把所以num盘分为两部分； 下部分：只有最底层的那个；上部分：除了最底层剩下的
 *  2.1  先把A上半部分盘 从A->B
 *  2.2  再把A最下面的盘 从A->C
 *  2.3  最后把B盘所有盘 从B->C
 *
 *  a,b,c对应三个参数 位置
 * 把盘从 a->c  需要借助b
 *  a：为启动
 *  c：为目标
 *  b：为中介
 */
public class HanoiTower {

    public static void main(String[] args) {
        hanoiTower(5,'A','B','C');
    }
    public static void hanoiTower(int num,char a,char b ,char c){

        if (num==1) {
            System.out.println("第"+num+"个盘从"+a+"=>"+c );
            return;
        }
        //2.1 先把A上半部分盘 从A->B
        hanoiTower(num-1,a,c,b);

        //2.2 再把A最下面的一个盘 从A->C
        System.out.println("第"+num+"个盘从"+a+"=>"+c );

        //2.3 最后把B盘所有盘 从B->C
        hanoiTower(num-1,b,a,c);


    }
}
