package com.dhatric.linkedlist;

public class MergeLinkedListMySol {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		
		if(l1 == null) {
			return l2;
		}
		if(l2 == null) {
			return l1;
		}
		
		ListNode mergedListHeadNode = new ListNode();
		ListNode lastNode = mergedListHeadNode;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				ListNode node = new ListNode(l1.val);
				l1 = l1.next;
				lastNode.next = node;
				lastNode = node;

			} else {
				ListNode node = new ListNode(l2.val);
				l2 = l2.next;
				lastNode.next = node;
				lastNode = node;
			}
		}

		if (l1 != null) {
			lastNode.next = l1;
		}
		if (l2 != null) {
			lastNode.next = l2;
		}
		return mergedListHeadNode.next;
	}
}
