package Leetcode;

/**
 * 208. 实现 Trie (前缀树)
 */
public class LeetCode208 {
    public static void main(String[] args) {

    }

}

class Trie {
    private Trie[] childrens;
    private boolean isEnd;

    public Trie() {
        childrens = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        //node 作为临时指针 进行遍历
        Trie node = this;
        //遍历 word 依次于查找 Trie 的 node ，node.childrens[index] 是否有值，没有则创建新的 new Trie()，
        //有的话就略过，然后
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (node.childrens[index] == null) {
                node.childrens[index] = new Trie();
            }
            //指针向后 进行遍历
            node = node.childrens[index];
        }
        //直到完成最后一个字符的，把当前Trie  标记为 结束
        node.isEnd = true;
    }

    public boolean search(String word) {
        //temp为遍历指针
        Trie trie = searchPrefix(word);
        if (trie != null && trie.isEnd) return true;
        return false;
    }

    public boolean startsWith(String prefix) {
        Trie trie = searchPrefix(prefix);
        if (trie != null) return true;
        return false;
    }

    //查找前缀
    private Trie searchPrefix(String prefix) {
        Trie temp = this;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int index = c - 'a';
            if (temp.childrens[index] != null) {
                //指针向后 进行遍历
                temp = temp.childrens[index];
            } else {
                return null;
            }
        }
        return temp;
    }
}