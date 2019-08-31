package array_operation;

import java.util.Arrays;

public class MoreThanHalfNum {

	/*
	 * record the time of elements. if the numbers are identical, time + 1; else
	 * time - 1.
	 */
	public static int func1(int[] array) {
		int len = array.length;
		if (len == 0) {
			return 0;
		} else if (len == 1) {
			return array[0];
		} else {
			int res = array[0];
			int count = 1;
			for (int i = 1; i < len; i++) {
				if (array[i] == res) {
					count++;
				}
				if (array[i] != res && count == 1) {
					res = array[i];
				}
				if (array[i] != res && count > 1) {
					count--;
				}
			}
			if (count > 0) {
				count = 0;
				for (int j = 0; j < len; j++) {
					if (array[j] == res)
						count++;
				}
				if (count > len / 2) {
					return res;
				} else {
					return 0;
				}
			} else {
				return 0;
			}
		}
	}

	/*
	 * quick sort and find the middle one shortage: error if there is no number that
	 * occurs more than half
	 */
	public static int func2(int[] array) {
		int len = array.length;
		if (len == 0) {
			return 0;
		} else if (len == 1) {
			return array[0];
		} else {
			Arrays.sort(array);
			return array[len / 2];
		}
	}
}
