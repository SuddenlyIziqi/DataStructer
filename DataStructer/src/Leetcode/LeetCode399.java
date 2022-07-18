package Leetcode;

import java.util.HashMap;
import java.util.List;

/**
 * 399. 除法求值
 */
public class LeetCode399 {
    public static void main(String[] args) {

    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int size = equations.size();
        HashMap<String, Integer> map = new HashMap<>(size * 2);
        UnionFind unionFind = new UnionFind(size * 2);

        int index = 0;
        for (int i = 0; i < equations.size(); i++) {
            List<String> strings = equations.get(i);
            String x = strings.get(0);
            String y = strings.get(1);
            if (!map.containsKey(x)) {
                map.put(x, index);
                index++;
            }
            if (!map.containsKey(y)) {
                map.put(y, index);
                index++;
            }
            unionFind.union(map.get(x), map.get(y), values[i]);
        }

        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> strings = queries.get(i);
            String x = strings.get(0);
            String y = strings.get(1);
            Integer intX = map.get(x);
            Integer intY = map.get(y);
            if (intX == null || intY == null) {
                res[i] = -1.0;
            } else {
                //父节点权值得比值
                res[i] = unionFind.isConnected(intX, intY);
            }
        }
        return res;
    }

    /**
     * 并查集
     * 实质上还是一个字典（数组），可以通过不断找父亲来找到最终的root
     */
    class UnionFind {
        //节点的父节点
        public int[] parent;
        //节点的父节点的权值
        public double[] weight;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.weight = new double[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                weight[i] = 1.0d;
            }
        }

        //返回根节点的 id
        public int find(int n) {
            int root = parent[n];
            if (root == n) {
                //如果是根节点，那就 是自己 返回节点即可
            } else {
                //如果不是根节点那么需要考虑节点压缩，当前节点的权值 = 父节点权值*当前节点和父节点的比值
                int pre = parent[n];
                parent[n] = find(pre);
                weight[n] *= weight[pre];
            }
            return parent[n];
        }

        public void union(int x, int y, double value) {
            int rootX = find(x);
            int rootY = find(y);
            //先找 两个节点的根节点是否相等，如果相等说明2个节点已经在一个通量上了 不需要处理了
            if (rootX == rootY) {
                return;
            }
            //不相等则需建立新的通量 让后者作为前者的父节点，并附上两个节点之间的权值
            parent[rootX] = rootY;
            weight[rootX] = weight[y] * value / weight[x];

        }

        /**
         * 如果是同一通量中两个节点的比值
         */
        public double isConnected(Integer x, Integer y) {
            int rootX = find(x);
            int rootY = find(y);
            //先找 两个节点的根节点是否相等，如果相等说明在同一个通量中，只需求取权值的比值就是两个节点的比值
            if (rootX == rootY) {
                return weight[x] / weight[y];
            } else {
                //不等说明不在一个通量中，那就没有比值
                return -1.0;
            }

        }
    }
}
