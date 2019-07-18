package array_operation;

import java.util.*;

public class FindLeastK {

	// quick sort and select the first k elements
	public static ArrayList<Integer> func1(int[] input, int k) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (k > input.length)
			return list;
		QuickSort.quickSort(input);
		for (int i = 0; i < k; i++) {
			list.add(input[i]);
		}
		return list;
	}

	// use heap
	public static ArrayList<Integer> func2(int[] input, int k) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		int len = input.length;
		if (len <= 0 || k <= 0 || k > len) {
			return result;
		}
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			};
		});
		for (int i = 0; i < len; i++) {
			if (maxHeap.size() != k) {
				maxHeap.add(input[i]);
			} else if (maxHeap.peek() > input[i]) {
				maxHeap.poll();
				maxHeap.add(input[i]);
			}
		}
		for (Integer integer : maxHeap) {
			result.add(integer);
		}
		return result;
	}
}
