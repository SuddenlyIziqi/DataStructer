package Leetcode;

/**
 * 79. 单词搜索
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode79 {
    static int h =0;
    static int w =0;
    public static void main(String[] args) {
        char[][] a = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        exist(a,"ABCCED");
    }

    public static boolean exist(char[][] board, String word) {
        h = board.length;
        w = board[0].length;
        int[][] visited = new int[h][w];
        for(int i = 0;i<h;i++){
            for(int j = 0;j<w;j++){
                boolean flag= check(board,i,j,word,0,visited);
                if(flag){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean check(char[][] board,int i, int j,String word,int k,int[][] visited){
        //先判断 board[i][j]是否 当前 第k（最开始是0位置）个字符
        if(board[i][j]!=word.charAt(k)){
            //不是的话返回
            return false;
        }else if(k==word.length()-1){
            //是的话 如果k是最后一位元素
            return true;
        }else{
            boolean result = false;
            //是的话 且不是最后一个元素，遍历上右下左来找下一个元素是不是第k+1位置的元素,
            //同时使用visited标记当前位置已经被使用过
            visited[i][j] = 1;
            //设置4方向遍历规则
            int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
            for(int[] dir:directions){
                int newI = i+dir[0];
                int newJ = j+dir[1];
                //先处理边界问题，越界直接下一个
                if(newI<0||newI>=h||newJ<0||newJ>=w||visited[newI][newJ]==1){
                    continue;
                }
                //未越界则判断是不是，并标记位置为1
                boolean flag = check(board,newI,newJ,word,k+1,visited);
                if(flag){
                    result = true;
                    break;
                }
            }
            //遍历4个方向 之后 将当前位置标记为未使用,给下一个元素遍历使用
            visited[i][j] = 0;
            return result;
        }
    }

}
