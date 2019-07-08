package practice;
/*
 * 在二维数组中查找target元素是否存在
 */

public class TargetInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		int target = 7;
		System.out.println("finding " + target + " in following array: \n\n");
		printArr(arr);
		boolean result = findFromTopRight(target, arr);
		//boolean result = findFromBottomLeft(target, arr);
		System.out.println("\n\nif target in array: " + result);
	}

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

	public static void printArr(int[][] array) {
		int row = array.length;
		int col = array[0].length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(array[i][j] + "    ");
			}
			System.out.println(" ");
		}
	}
}
