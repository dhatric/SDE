package com.dhatric.trees;

import java.util.LinkedList;

/*
 * 
 * Given two binary trees original and cloned and given a reference to a node target in the original tree.
The cloned tree is a copy of the original tree.
Return a reference to the same node in the cloned tree.

 */

public class CloneTarget {
	public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
		TreeNode clonedTarget = null;
		LinkedList<TreeNode> nodes = new LinkedList<>();
		nodes.add(cloned);

		while (!nodes.isEmpty()) {
			TreeNode element = nodes.pop();
			if (element.val == target.val) {
				clonedTarget = element;
				break;
			}
			if (element.left != null) {
				nodes.add(element.left);
			}
			if (element.right != null) {
				nodes.add(element.right);
			}

		}

		return clonedTarget;
	}
}
