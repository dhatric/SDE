package com.dhatric.trees;

public class CloneTargetRecurive {
	public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
		return getNode(cloned, target);
	}
	

	TreeNode getNode(TreeNode node, TreeNode target) {
		TreeNode clonedTarget = null;
		if (node.val == target.val) {
			clonedTarget = node;
		} else {

			if (node.left != null) {
				clonedTarget = getNode(node.left, target);
			}
			if (clonedTarget == null && node.right != null) {
				clonedTarget = getNode(node.right, target);
			}

		}
		return clonedTarget;
	}
}
