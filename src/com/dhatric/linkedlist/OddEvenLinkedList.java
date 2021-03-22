package com.dhatric.linkedlist;

public class OddEvenLinkedList {
	public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode oddHead = head;
		ListNode evenHead = head.next;

		ListNode oddCurrent = oddHead;
		ListNode evenCurrent = evenHead;

		while (evenCurrent != null && evenCurrent.next != null) {
			oddCurrent.next = evenCurrent.next;
			evenCurrent.next = evenCurrent.next.next;
			oddCurrent = oddCurrent.next;
			evenCurrent = evenCurrent.next;
		}
		oddCurrent.next = evenHead;
		return oddHead;

	}
}
