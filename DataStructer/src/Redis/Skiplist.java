package Redis;

import java.util.Arrays;

/**
 * 1206. 设计跳表
 * 跳表分两部分  1.Skiplist
 * 2.SkiplistNode
 */
public class Skiplist {

    private static final double SKIPLIST_P = 0.25;
    private static final int MAX_LEVEL = 32;

    private SkiplistNode header;//头结点
    private SkiplistNode tail;//尾结点
    private int level;//跳跃表的当前最高等级 但是实际使用的时候 我们取得是 level-1 因为SkiplistNode的数组是从0开始的
    private int length;//除了头结点 header 外的 节点数量

    public Skiplist() {
        this.header = new SkiplistNode(-1, MAX_LEVEL);
        this.level = 0;
    }

    /**
     * 查找
     * 从头结点开始查
     * 从最高层开始遍历
     */
    public boolean search(int target) {
        SkiplistNode curr = this.header;
        //从最高层开始遍历，找到最后一个小于target的节点，然后逐层往下直到第一层 level 0
        //要注意，因为数组从0 开始的 因此当 level从最高层到第一层数组表现为：  从 level-1 到 0
        for (int i = level - 1; i >= 0; i--) {
            while (curr.forward[i] != null && curr.forward[i].value < target) {
                curr = curr.forward[i];
            }
        }
        //遍历到了第一层，此时curr是最后一个小于 target的节点，此时后移来判断 target是否==这个节点
        curr = curr.forward[0];

        return curr == null && curr.value == target;
    }

    /**
     * 插入
     * 找到待插入节点的前驱结点数组  pre[]
     * 然后讲
     *
     * @param num
     */
    public void add(int num) {
        //找到待插入节点的前驱结点数组
        SkiplistNode[] pre = new SkiplistNode[MAX_LEVEL];
        Arrays.fill(pre, header);
        SkiplistNode curr = this.header;
        for (int i = level - 1; i >= 0; i--) {
            while (curr.forward[i] != null && curr.forward[i].value < num) {
                curr = curr.forward[i];
            }
            pre[i] = curr;
        }
        //随机层数
        int newLevel = randomLevel();
        //更新最高层数
        this.level = Math.max(newLevel, level);
        //新节点
        SkiplistNode newNode = new SkiplistNode(num, newLevel);
        for (int i = 0; i < newLevel; i++) {
            newNode.forward[i] = pre[i].forward[i];
            pre[i].forward[i] = newNode;
        }
    }

    public boolean erase(int num) {
        SkiplistNode[] pre = new SkiplistNode[MAX_LEVEL];
        Arrays.fill(pre, header);
        SkiplistNode curr = this.header;
        for (int i = level - 1; i >= 0; i--) {
            while (curr.forward[i] != null && curr.forward[i].value < num) {
                curr = curr.forward[i];
            }
            pre[i] = curr;
        }
        //查到第一层 并指向目标小于 num的最后一个节点
        curr = curr.forward[0];
        //判断 num是否存在，
        if (curr == null || curr.value != num) {
            return false;
        }
        //num存在，此时 curr即为所需要删除的节点
        //遍历 level逐层删除
        for (int i = 0; i < level; i++) {
            if (pre[i].forward[i] != curr) {
                //从下往上删除，一旦不是curr说明更上层更不会是了也就结束了
                break;
            }
            //当前去节点的下一个节点是curr时，直接断链删除即可
            pre[i].forward[i] = pre[i].forward[i].forward[i];
        }
        //删完之后判断是否要保留上层level
        while (level > 1 && header.forward[level - 1] == null) {
            level--;
        }
        return true;
    }


    /**
     * 随机层数
     *
     * @return
     */
    private int randomLevel() {
        int level = 1;
        // 当 level < MAX_LEVEL，且随机数小于设定的晋升概率时，level + 1
        while (Math.random() < SKIPLIST_P && level < MAX_LEVEL) {
            level++;
        }
        return level;
    }


}

/**
 * 跳跃表节点
 */
class SkiplistNode {
    int value;
    SkiplistNode[] forward;

    public SkiplistNode(int value, int maxLevel) {
        this.value = value;
        this.forward = new SkiplistNode[maxLevel];
    }
}
