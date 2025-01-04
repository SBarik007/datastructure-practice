package com.srikantbarik.datastructure.trie;

//Q.208
/*
208. Implement Trie (Prefix Tree)
Medium
A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings.
There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

Trie() Initializes the trie object.
void insert(String word) Inserts the string word into the trie.
boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.


Example 1:

Input
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output
[null, null, true, false, true, null, true]

Explanation
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // return True
trie.search("app");     // return False
trie.startsWith("app"); // return True
trie.insert("app");
trie.search("app");     // return True

 */

class Trie {
      Trie[] child;
      boolean wordEnd;

    public static void main(String[] args) {
        Trie t=new Trie();
        t.insert("apple");
        t.insert("dog");
        System.out.println(t.search("apple"));
        System.out.println(t.startsWith("do"));
        //System.out.println("Done");
    }
      public Trie() {
            child= new Trie[26]; //IMP
        }

        public void insert(String word) {
            char[] charArray = word.toCharArray();
            Trie rootNode = this;
            Trie currentNode = rootNode;
            for (char c : charArray) {
                if (currentNode.child[c - 'a'] == null) {
                    currentNode.child[c - 'a'] = new Trie();
                }
                currentNode=currentNode.child[c - 'a'];
            }
            currentNode.wordEnd=true;
        }

        public boolean search(String word) {
            char[] charArray = word.toCharArray();
            Trie currentNode = this;
            boolean wordEnd = false;
            for (char c : charArray) {
                if (currentNode.child[c - 'a'] != null) {
                    currentNode = currentNode.child[c - 'a'];
                    wordEnd = currentNode.wordEnd;
                } else {
                    return false;
                }
            }
            if (wordEnd) {
                return true;
            } else {
                return false;
            }
        }

        public boolean startsWith(String prefix) {
                char[] charArray = prefix.toCharArray();
                Trie currentNode = this;
                boolean wordEnd = false;
                for (char c : charArray) {
                    if (currentNode.child[c - 'a']!=null) {
                        wordEnd=currentNode.wordEnd;
                        currentNode = currentNode.child[c - 'a'];
                    } else {
                        return false;
                    }
                }
                    return true;
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

