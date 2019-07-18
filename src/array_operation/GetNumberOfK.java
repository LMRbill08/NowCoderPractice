package array_operation;

public class GetNumberOfK {

	//
	public static int func1(int[] array, int target) {
		int count = 0;
		if (array.length == 0)
			return -1;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == target)
				count++;
		}
		return count;
	}

	public static int func2(int[] array, int target) {
		int len = array.length;
		if (len == 0) {
			return 0;
		}
		int firstK = getFirst(array, target, 0, len - 1);
		int lastK = getLast(array, target, 0, len - 1);
		if (firstK != -1 && lastK != -1)
			return lastK - firstK + 1;
		else
			return -1;
	}

	// using while loop
	private static int getFirst(int[] array, int target, int low, int high) {
		// TODO Auto-generated method stub
		if (low > high) {
			return -1;
		}
		int mid = (low + high) >> 1;
		if (target < array[mid]) {
			return getFirst(array, target, low, mid - 1);
		} else if (target > array[mid]) {
			return getFirst(array, target, mid + 1, high);
		} else if (mid - 1 >= 0 && array[mid - 1] == target) {
			return getFirst(array, target, low, mid - 1);
		} else {
			return mid;
		}
	}

	// using recursion
	private static int getLast(int[] array, int target, int low, int high) {
		// TODO Auto-generated method stub
		if (low > high)
			return -1;
		int mid = (low + high) >> 1;
		while (low <= high) {
			if (target < array[mid]) {
				high = mid - 1;
			} else if (target > array[mid]) {
				low = mid + 1;
			} else if (mid + 1 < array.length && array[mid + 1] == target) {
				low = mid + 1;
			} else {
				return mid;
			}
			mid = (low + high) / 2;
		}
		return -1;
	}
}
