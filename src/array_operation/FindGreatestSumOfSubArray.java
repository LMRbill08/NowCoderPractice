package array_operation;

public class FindGreatestSumOfSubArray {
	public static int function(int[] array) {
		int res = array[0]; // store max of new sub arrays ending with array[i]
		int max = array[0]; // store the max of all current sub arrays
		for (int i = 1; i < array.length; i++) {
			max = Math.max(max + array[i], array[i]);
			res = Math.max(max, res);
		}
		return res;
	}
}
