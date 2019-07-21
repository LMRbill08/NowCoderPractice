package array_operation;

public class FindNumsAppearOnce {
	public static void function(int[] array, int[] num1, int[] num2) {
		int len = array.length;
		if (len < 2) {
			return;
		}
		if (len == 2) {
			num1[0] = array[0];
			num2[0] = array[1];
		}
		int bitRes = 0; // store the result of '^'
		for (int i = 0; i < len; i++) {
			bitRes ^= array[i];
		}
		// find the first '1' bit, representing the first different bit of the two
		// numbers
		int index = 0;
		while (index < 32 && ((bitRes & 1) == 0)) {
			bitRes >>= 1;
			index++;
		}
		// based on index, divide the numbers into two groups
		for (int i = 0; i < len; i++) {
			if (digitIsOne(array[i], index)) {
				num1[0] ^= array[i];
			} else {
				num2[0] ^= array[i];
			}
		}
	}

	// check if the index is i
	public static boolean digitIsOne(int cur, int index) {
		return ((cur >> index) & 1) == 1;
	}
}
