package com.dhatric.tries;

import java.util.Arrays;
import java.util.List;

//A class to store a Trie node

class TriesTest {

	// Iterative function to insert a string into a Trie
	public static void insert(Trie head, String str) {
		// start from the root node
		Trie curr = head;

		for (char c : str.toCharArray()) {
			// create a new node if the path doesn't exist
			if (curr.character[c - 'a'] == null) {
				curr.character[c - 'a'] = new Trie();
			}

			// go to the next node
			curr = curr.character[c - 'a'];
		}

		// store key in the leaf node
		curr.key = str;
	}

	// Function to perform preorder traversal on a given Trie
	public static void preorder(Trie curr) {
		// return if Trie is empty
		if (curr == null) {
			return;
		}

		for (int i = 0; i < 26; i++) {
			// if the current node is a leaf, print the key
			if (curr.character[i] != null && curr.character[i].key != null) {
				System.out.println(curr.character[i].key);
			}

			preorder(curr.character[i]);
		}
	}

	public static void main(String[] args) {
		// given set of keys
		List<String> dict = Arrays.asList("lexicographic", "sorting", "of", "a", "set", "of", "keys", "can", "be",
				"accomplished", "with", "a", "simple", "trie", "based", "algorithm", "we", "insert", "all", "keys",
				"in", "a", "trie", "output", "all", "keys", "in", "the", "trie", "by", "means", "of", "preorder",
				"traversal", "which", "results", "in", "output", "that", "is", "in", "lexicographically", "increasing",
				"order", "preorder", "traversal", "is", "a", "kind", "of", "depth", "first", "traversal");

		Trie head = new Trie();

		// insert all keys of a dictionary into a Trie
		for (String word : dict) {
			insert(head, word);
		}

		// print keys in lexicographic order
		preorder(head);
	}


}
