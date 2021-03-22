package com.dhatric.linkedlist;

public class MergeLinkedListWithoutNewNodes {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode finalHead = new ListNode(-1);
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		ListNode l1Current = l1;
		ListNode l2Current = l2;
		ListNode current = finalHead;
		while (l1Current != null && l2Current != null) {
			if (l1Current.val == l2Current.val) {

				current.next = l1Current;
				current = current.next;
				l1Current = l1Current.next;

				current.next = l2Current;
				current = current.next;
				l2Current = l2Current.next;

			} else if (l1Current.val < l2Current.val) {

				current.next = l1Current;
				current = current.next;
				l1Current = l1Current.next;
			} else if (l1Current.val > l2Current.val) {

				current.next = l2Current;
				current = current.next;
				l2Current = l2Current.next;
			}
		}

		if (l1Current == null) {
			current.next = l2Current;
		} else if (l2Current == null) {
			current.next = l1Current;
		}

		return finalHead.next;
	}
}
