package com.dhatric.heap;

public class MinHeap {
	int[] heap;
	int maxSize;
	int size;

	public MinHeap(int maxSize) {
		this.heap = new int[maxSize + 1];
		this.maxSize = maxSize;
		this.size = 0;
		heap[0] = Integer.MIN_VALUE;
	}

	public int parent(int pos) {
		return pos / 2;
	}

	public int leftChild(int pos) {
		return pos * 2;
	}

	public int rightChild(int pos) {
		return (pos * 2) + 1;
	}

	public boolean isLeafNode(int pos) {
		if (pos >= (size+1) / 2 && pos <= size) {
			return true;
		}
		return false;
	}

	public void swap(int pos1, int pos2) {
		int temp = heap[pos1];
		heap[pos1] = heap[pos2];
		heap[pos2] = temp;
	}

	public void replaceHeadNode(int element) {

		if (element > heap[1]) {
			heap[1] = element;
			minifyHeap(1);
		}
	}

	public void minifyHeap(int pos) {
		if (isLeafNode(pos)) {
			return;
		}

		if (heap[pos] > heap[leftChild(pos)] || heap[pos] > heap[rightChild(pos)]) {
			if (heap[leftChild(pos)] < heap[rightChild(pos)]) {
				swap(pos, leftChild(pos));
				minifyHeap(leftChild(pos));
			}else {
				swap(pos, rightChild(pos));
				minifyHeap(rightChild(pos));
			}

		}

	}

	public void insert(int element) {
		heap[++size] = element;
		int currentPos = size;
		while (heap[currentPos] < heap[parent(currentPos)]) {
			swap(currentPos, parent(currentPos));
			currentPos = parent(currentPos);
		}

	}

	public static int[] getLargestElements(int input[], int k) {
		MinHeap minHeap = new MinHeap(k);
		for (int i = 0; i < k; i++) {
			minHeap.insert(input[i]);
		}
		
		for (int i = k; i < input.length; i++) {
			minHeap.replaceHeadNode(input[i]);
		}
		return minHeap.heap;

	}

	public static void main(String args[]) {
		int[] input = { 30, 10, 40, 60, 80, 100,5 };
		int[] output = getLargestElements(input, 3);
		for (int i = 1; i < output.length; i++) {
			System.out.println(output[i]);
		}

	}

}