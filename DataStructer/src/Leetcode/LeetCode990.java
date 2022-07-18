package Leetcode;

/**
 * 990. 等式方程的可满足性
 */
public class LeetCode990 {
    public static void main(String[] args) {
        LeetCode990 leetCode990 = new LeetCode990();
        String[] ss = {"c==c", "b==d", "x!=z"};
        boolean b = leetCode990.equationsPossible(ss);
        System.out.println("b = " + b);

    }

    public boolean equationsPossible(String[] equations) {
        UnionFind unionFind = new UnionFind(26);
        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                unionFind.union(equation.charAt(0) - 97, equation.charAt(3) - 97);
            }
        }
        for (String equation : equations) {
            if (equation.charAt(1) != '=') {
                if (unionFind.find(equation.charAt(0) - 97) == unionFind.find(equation.charAt(3) - 97)) {
                    return false;
                }

            }
        }
        return true;
    }

    class UnionFind {
        public int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int n) {
            if (n != parent[n]) {
                parent[n] = find(parent[n]);
            }
            return parent[n];
        }

        public void union(int x, int y) {
            int i = find(x);
            int j = find(y);
            if (i == j) {
                return;
            } else {
                parent[i] = j;
            }
        }
    }
}
