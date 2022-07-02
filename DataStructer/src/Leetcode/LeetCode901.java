package Leetcode;

import java.util.Stack;

/**
 * 901. 股票价格跨度
 * 编写一个 StockSpanner 类，它收集某些股票的每日报价，并返回该股票当日价格的跨度。
 *
 * 今天股票价格的跨度被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。
 *
 * 例如，如果未来7天股票的价格是 [100, 80, 60, 70, 60, 75, 85]，那么股票跨度将是 [1, 1, 1, 2, 1, 4, 6]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/online-stock-span
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode901 {
    public static void main(String[] args) {

    }
    class StockSpanner {
        Stack<Integer> prices,weigths;
        public StockSpanner() {
            prices = new Stack();
            weigths = new Stack();
        }

        public int next(int price) {
            int w=1;
            while(!prices.isEmpty()&&price>=prices.peek()){
                prices.pop();
                w+=weigths.pop();
            }
            prices.push(price);
            weigths.push(w);
            return w;
        }
    }
}
