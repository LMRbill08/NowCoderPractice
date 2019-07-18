package array_operation;
/*
 * 在二维数组中查找target元素是否存在
 */

public class TargetInArray {

	/*
	 * 从右上角开始寻找
	 */
	public static boolean findFromTopRight(int target, int[][] array) {
		int row = 0;
		int col = array[0].length - 1;
		while (row < array.length && col >= 0) {
			System.out.println("current element: " + array[row][col]);
			if (array[row][col] == target) {
				return true;
			} else if (target > array[row][col]) {
				row++;
			} else {
				col--;
			}
		}
		return false;
	}

	/*
	 * 从左下角开始寻找
	 */
	public static boolean findFromBottomLeft(int target, int[][] array) {
		int row = array.length - 1;
		int col = 0;
		while (row >= 0 && col < array[0].length) {
			System.out.println("current element: " + array[row][col]);
			if (target == array[row][col])
				return true;
			else if (target < array[row][col])
				row--;
			else
				col++;
		}
		return false;
	}
}
