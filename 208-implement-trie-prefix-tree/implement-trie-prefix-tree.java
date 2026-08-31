class Trie {

    Trie[] next = new Trie[26];
    boolean end;

    public Trie() {}

    public void insert(String word) {
        Trie node = this;
        for (char c : word.toCharArray()) {
            if (node.next[c - 'a'] == null)
                node.next[c - 'a'] = new Trie();
            node = node.next[c - 'a'];
        }
        node.end = true;
    }

    public boolean search(String word) {
        Trie node = find(word);
        return node != null && node.end;
    }

    public boolean startsWith(String prefix) {
        return find(prefix) != null;
    }

    private Trie find(String word) {
        Trie node = this;
        for (char c : word.toCharArray()) {
            node = node.next[c - 'a'];
            if (node == null) return null;
        }
        return node;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */