
package com.dhatric.linkedlist;

import java.util.PriorityQueue;

public class MergeKSortedLinkedLists {
	public ListNode mergeKLists(ListNode[] lists) {

		if (lists == null) {
			return null;
		} else if (lists.length == 1) {
			return lists[0];
		}

		ListNode head = new ListNode(-1);
		ListNode current = head;
		PriorityQueue<ListNode> minQueue = new PriorityQueue<ListNode>((node1, node2) -> node1.val - node2.val);

		for (int index = 0; index < lists.length; index++) {
			if (lists[index] != null)
				minQueue.add(lists[index]);
		}

		while (!minQueue.isEmpty()) {
			ListNode minElementNode = minQueue.remove();
			ListNode minNode = new ListNode(minElementNode.val);
			current.next = minNode;
			current = minNode;
			if (minElementNode.next != null) {
				minQueue.add(minElementNode.next);
			}
		}

		return head.next;

	}
}
