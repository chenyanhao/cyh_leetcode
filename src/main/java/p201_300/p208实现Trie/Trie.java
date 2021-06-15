package p201_300.p208实现Trie;

class Trie {

    // 字母映射表
    private Trie[] children;

    // 该结点是否是一个串的结束
    private boolean isEnd;

    /** Initialize your data structure here. */
    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }
    
    /** Inserts a word into the trie. */
    /**
     * 这个操作和构建链表很像。
     * 首先从根结点的子结点开始与 word 第一个字符进行匹配，一直匹配到前缀链上没有对应的字符，
     * 这时开始不断开辟新的结点，直到插入完 word 的最后一个字符，
     * 同时还要将最后一个结点 isEnd 标记为 true，表示它是一个单词的末尾。
     */
    public void insert(String word) {
        Trie node = this;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    /**
     * 从根结点的子结点开始，一直向下匹配，
     * 如果出现结点值为空就返回 false，
     * 如果匹配到了最后一个字符，只需判断 node.isEnd 即可。
     */
    public boolean search(String word) {
        Trie node = this;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            node = node.children[index];
            if (node == null) {
                return false;
            }
        }
        return node.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    /**
     * 和 search 操作类似，只是不需要判断最后一个字符结点的isEnd
     */
    public boolean startsWith(String prefix) {
        Trie node = this;
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            node = node.children[index];
            if (node == null) {
                return false;
            }
        }
        return true;
    }
}