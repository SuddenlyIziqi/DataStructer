package Recursion;

/**
 *  迷宫回溯
 */
public class MiGong {
    public static void main(String[] args) {
        /**
         * 绘制迷宫地图
         * 8X7的格子
         * 1 为围墙
         * 2 表示通路
         * 3 表示该点已经走过了，但走不通
         */
        int[][] map= new int[8][7];
        for (int i = 0; i < 7; i++) {
            map[0][i] =1;
            map[7][i] =1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] =1;
            map[i][6] =1;
        }
        //加挡板
        map[3][1]=1;
        map[3][2]=1;
        System.out.println("地图如下：");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(" " + map[i][j]);
            }
            System.out.println();
        }
        boolean rout = getRout(map, 1, 1);
        System.out.println("走过了吗："+rout);
        System.out.println("走过的地图如下：");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(" " + map[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * 找路线
     * @param map  迷宫地图
     * @param i  初始化点的坐标
     * @param j  初始化点的坐标
     *          map[i][j] 为 当前点的位置
     *          map[7][6] 为 终点
     *  走迷宫需要策略：路线为 下右上左  ↓ → ↑ ← 的顺序来找路 如果走不通则回溯 （返回上一步的点）
     *           递归的感觉就是去 假设能行 再去验证，能行则继续假设，不行就回溯；
     * @return
     */
    public static boolean getRout(int[][] map,int i,int j){
        if(map[6][5]==2){
            //通路已找到  这是递归终止条件！！！
            return true;
        }else {
            //判断当前点是否走过
            if(map[i][j]==0){
                //当前点没有走过可以走
                //就假设它可以走通
                map[i][j]=2;
                //按照策略来找路： 下右上左  ↓ → ↑ ← 的顺序来找路 如果走不通则回溯 （返回上一步的点）
                //假设向↓走能走通
                if (getRout(map,i+1,j)){
                    return true;
                }else  if (getRout(map,i,j+1)){
                    //假设向→走能走通
                    return true;
                }else if (getRout(map,i-1,j)){
                    //假设向↑走能走通
                    return true;
                }else if (getRout(map,i,j-1)){
                    //假设向←走能走通
                    return true;
                }else{
                    //如果都不能走通 将此点设置为3
                    map[i][j]=3;
                    return false;
                }
            }else {
                //map[i][j]==1 是墙 不能走
                //map[i][j]==2 是通路  不需要走了
                //map[i][j]==3 是不能走通的路  不需要走了
                return false;
            }


        }
    }



}
