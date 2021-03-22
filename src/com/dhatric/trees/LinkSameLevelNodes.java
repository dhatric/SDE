package com.dhatric.trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


public class LinkSameLevelNodes {
	public Node connect(Node root) {
		Map<Integer, LinkedList<Node>> map = new HashMap<>();
		populateMap(root, map, 1);

		for (Integer level : map.keySet()) {
			if (level == 1) {
				continue;
			}

			LinkedList<Node> levelNodes = map.get(level);
			Node node = levelNodes.pop();
			while (!levelNodes.isEmpty()) {
				Node current = levelNodes.pop();
				node.next = current;
				node = current;
			}
		}

		return root;
	}

	public void populateMap(Node node, Map<Integer, LinkedList<Node>> map, int level) {

		if (node == null)
			return;

		if (!map.containsKey(level)) {
			map.put(level, new LinkedList<Node>());
		}
		map.get(level).add(node);
		populateMap(node.left, map, level + 1);
		populateMap(node.right, map, level + 1);

	}
}


class Node {
	public int val;
	public Node left;
	public Node right;
	public Node next;

	public Node() {
	}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, Node _left, Node _right, Node _next) {
		val = _val;
		left = _left;
		right = _right;
		next = _next;
	}

}
