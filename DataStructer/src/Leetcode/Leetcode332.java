package Leetcode;

public class Leetcode332 {

    public static void main(String[] args) {
        int[] coins = new int[]{2};
        int amount = 3;
        coinChange(coins,amount);
    }
    public  static int coinChange(int[] coins, int amount) {
        // int[] memo =  new int[];
        return   helper(coins,amount);
    }
    public static int helper(int[] coins, int amount) {
        if(amount==0) return 0;
        if(amount<0) return -1;
        int  res = Integer.MAX_VALUE;

        for(int coin:coins){
            int sub =  helper(coins,amount-coin);
            if(sub<0) continue;
            res=Math.min(res,sub+1);
        }
        return res==Integer.MAX_VALUE?-1:res;
    }
}
