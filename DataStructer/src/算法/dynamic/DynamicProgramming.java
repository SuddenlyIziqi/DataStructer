package 算法.dynamic;

/**
 * 动态规划
 * 书包问题 求最高价值
 * 将 商品重量和价值合成一张二维表
 *  value[i] 为第i件商品的价值
 *  weight[i] 为第i件商品的重量
 *  table[i][j] 表示前i件商品，在当前容量为j的时候的最高价值
 *  其中 table[i][0]；table[0][j] 都是默认为0的
 *  1.当  weight[i]>j： 「也就是第i件商品的重量>当前容量j的时候，背包肯定是无法放入当前商品的」：
 *      table[i][j] = table[i-1][j]; 「那么此时table的最大价值 也就是上一层商品（i-1）在容量为j的时候的最大价值」
 *  2.否则：「也就是第i件商品的重量<=当前容量j的时候;背包是可以放入当前商品的。」
 *      table[i][j] = Math.max(table[i-1][j], value[i]+table[i-1][j- weight[i]]);
 *      那么需要判断大凹的是上一层价值高，还是这个商品i加入后的价值高；
 *              对于后者而言分析 ：value[i]+table[i-1][j- weight[i]]
 *              「value[i]；为当前要放入的商品单个价值；
 *               table[i-1][j- weight[i]]：为除去去当前商品，容量也减去当前商品的时候的最高价值；
 *               两者的和构成了：这个商品i加入后的最高价值」
 *  进一步，若需要求求最高价值的商品组合
 *
 *
 */
public class DynamicProgramming {
    public static void main(String[] args) {
        int[] value ={0,1500,3000,2000};//0只是占位，后三个为3种东西价值
        int[] weight = {0,1,4,3};//0只是占位，后三个为3种东西重量
        int m = 4;//书包总容量
        int n = value.length;//书包装的件数

        int[][] table = new int[n][m+1];
        String[][] detail = new String[n][m+1];
        int max =0;
        String maxDetail ="";

        for (int i = 1; i < table.length; i++) {
            for (int j = 1; j < table[i].length; j++) {
                //只需要比价格的话截止到此
             /* if(weight[i]>j){
                  table[i][j] = table[i-1][j];
              }else {
                  table[i][j] = Math.max(table[i-1][j], value[i]+table[i-1][j- weight[i]]);
              }*/
                //需要附加具体商品信息的话需要下面的信息
                if (weight[i] > j) {
                    table[i][j] = table[i - 1][j];
                    detail[i][j] = detail[i-1][j];
                } else {
                    if(table[i - 1][j] > value[i] + table[i - 1][j - weight[i]]){
                        table[i][j] = table[i - 1][j];
                        detail[i][j] = detail[i-1][j];
                    }else {
                        table[i][j] = value[i] + table[i - 1][j - weight[i]];
                        detail[i][j] = value[i]+"+"+table[i - 1][j - weight[i]];
                    }
                }
                if(max>=table[i][j]){

                }else {
                    max = table[i][j];
                    maxDetail= detail[i][j];

                }

            }
        }


        //遍历 table
        showTable(table);
        showDetail(detail);
        System.out.println("max = " + max);
        System.out.println("maxDetail = " + maxDetail);
    }

    private static void showTable(int[][] table) {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                System.out.print( table[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void showDetail(String[][] table) {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                System.out.print( table[i][j]+" ");
            }
            System.out.println();
        }
    }

}
