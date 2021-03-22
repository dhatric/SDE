package com.dhatric.tries;

class Trie {
	String key; // non-empty when node is a leaf node
	Trie[] character;

	// Constructor
	Trie() {
		// Trie supports lowercase English characters `a – z`.
		// So, the character size is 26.
		character = new Trie[26];
	}
}