package com.company.xx.binaryTree.T208实现Trie前缀树;

public class Trie {
    // 字典树的孩子节点
    Trie[] children;
    // 该节点是否是某个单词的结尾
    boolean isEnd;


    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie root = this;
        char[] chars = word.toCharArray();

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (root.children[index] == null) {
                root.children[index] = new Trie();
            }
            root = root.children[index];

        }
        root.isEnd = true;
    }

    public boolean search(String word) {
        Trie root = this;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (root.children[index] == null) {
                return false;
            }
            root = root.children[index];
        }

        return root.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie root = this;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int index = c - 'a';
            if (root.children[index] == null) {
                return false;
            }
            root = root.children[index];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        // 返回 True
        System.out.println(trie.search("app"));
        // 返回 False
        System.out.println(trie.startsWith("app"));
        // 返回 True
        trie.insert("app");
        System.out.println(trie.search("app"));
        // 返回 True
    }
}
