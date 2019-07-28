package array_operation;

import javax.sound.midi.MidiChannel;

public class MinNumberInRotateArray {

	/*
	 * Normal Method 运行时间：252ms 占用内存：28116k
	 */
	public static int function(int[] arr) {
		int len = arr.length;
		if (len == 0)
			return 0;
		for (int i = 0; i < len - 1; i++) {
			if (arr[i] > arr[i + 1])
				return arr[i + 1];
		}
		return 0;
	}

	/*
	 * Using Binary Search
	 */
	public static int function2(int[] arr) {
		int len = arr.length;
		if (len == 0) {
			return 0;
		}
		int low = 0, high = len - 1;
		int mid = -1;
		while (low < high) {
			mid = (low + high) / 2;
			if (arr[mid] > arr[high]) {
				low += mid + 1;
			} else if (arr[mid] < arr[high]) {
				high = mid;
			} else {
				high -= 1;
			}
		}

		return arr[low];
	}

}
