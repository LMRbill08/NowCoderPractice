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

	private static int getFirst(int[] array, int target, int i, int j) {
		// TODO Auto-generated method stub
		return 0;
	}

	private static int getLast(int[] array, int target, int i, int j) {
		// TODO Auto-generated method stub
		return 0;
	}
}
