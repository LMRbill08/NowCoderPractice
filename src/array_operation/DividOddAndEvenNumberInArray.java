package array_operation;
/*
 * divide an array into 2 parts, the front part of the array contains all the odd numbers in the original array, 
 * while the end part contains all the even numbers 
 * the relative location between numbers do not change 
 */
public class DividOddAndEvenNumberInArray {

	// create another array to store the final numbers
	public static int[] reOrderArray1(int[] array) {
		int len = array.length;
		int[] temp = new int[len];
		int cur_index = 0;
		for (int i = 0; i < len; i++) {
			if (array[i] % 2 == 1) {
				temp[cur_index] = array[i];
				cur_index++;
			}
		}
		for (int i = 0; i < len; i++) {
			if (array[i] % 2 == 0) {
				temp [cur_index] = array[i];
				cur_index++;
			}
		}

		return temp;
	}

	// use 2 other arrays to store odd and even numbers respectively
	public static void reOrderArray2(int[] array) {
		int len = array.length;
		int[] odd_list = new int[len];
		int[] even_list = new int[len];
		int odd_index = 0;
		int even_index = 0;
		for (int i = 0; i < len; i++) {
			if (array[i] % 2 == 1) {
				odd_list[odd_index] = array[i];
				odd_index++;
			} else {
				even_list[even_index] = array[i];
				even_index++;
			}
		}
		// System.out.println(odd_index + " " + even_index);
		for (int i = 0; i < odd_index; i++) {
			array[i] = odd_list[i];
		}
		for (int i = 0; i < even_index; i++) {
			array[odd_index + i] = even_list[i];
		}
	}


}
