package array_operation;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("===============Find Target in Matrix===============");
		int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		int target = 7;
		System.out.println("finding " + target + " in following array: \n");
		printMatrix(arr);
		boolean result = TargetInArray.findFromTopRight(target, arr);
		// boolean result = findFromBottomLeft(target, arr);
		System.out.println("\nif target in array: " + result);
		System.out.println();
		System.out.println("===============Divid Odd And Even Number In Array===============");
		int[] list = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		DividOddAndEvenNumberInArray.reOrderArray2(list);
		print(list);
		int[] res = DividOddAndEvenNumberInArray.reOrderArray1(list);
		print(res);
		System.out.println();
		System.out.println("===============Clockwise Print Matrix===============\n");
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		// int[][] matrix = { { 1, 2, 3, 4 }};
		// int[][] matrix = {{1}, {2}, {3}, {4}, {5}};
		ArrayList<Integer> clockwiseList = clockwisePrintMatrix(matrix);
		System.out.println(clockwiseList.toString());
		System.out.println();
		System.out.println("===============Find The More Than Half Number===============");
		int[] arrayHalf = { 1, 2, 3, 2, 2, 2, 5, 4, 2 };
		print(arrayHalf);
		int resNumber = MoreThanHalfNum.func1(arrayHalf);
		System.out.println(resNumber);
		System.out.println();
		System.out.println("===============Find Least K Numbers===============");
		int[] leastK = { 5, 8, 2, 3, 7, 6, 9, 1, 4 };
		print(leastK);
		int K = 5;
		System.out.println("K = " + K);
		ArrayList<Integer> leastKList = FindLeastK.func2(leastK, K);
		System.out.println(leastKList.toString());
		System.out.println();
		System.out.println("===============Find Greatest Sum Of Sub Array===============");
		int[] maxSubArray = {6, -3, -2, 7, -15, 1, 2, 20};
		print(maxSubArray);
		System.out.println("greatest sum of sub array is: " + FindGreatestSumOfSubArray.function(maxSubArray));
		System.out.println();
		System.out.println("===============Print Min Number===============");
		int[] minNumber = {3, 32, 321};
		print(minNumber);
		System.out.println("min number is: " + PrintMinNumber.function(minNumber));
		System.out.println();
		System.out.println("===============Print The First Not Repeating Char in String===============");
		String firstSingleOccurChar = "google";
		System.out.println("String is: " + firstSingleOccurChar);
		int firstChar = FirstNotRepeatingChar.func2(firstSingleOccurChar);
		System.out.println("Index of first not repeating char is: " + firstChar);
		System.out.println();
		System.out.println("===============Get Nth ugly number===============");
		System.out.println(UglyNumber.function(7));
	}

	// print list
	public static void print(int[] list) {
		System.out.println("\n");
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}
		System.out.println("\n");
	}

	// print a matrix and print its clockwise order
	public static ArrayList<Integer> clockwisePrintMatrix(int[][] matrix) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int row = matrix.length;
		int col = matrix[0].length;
		if (row == 0 || col == 0)
			return list;
		int count = (Math.min(row, col) + 1) / 2;
		for (int i = 0; i < count; i++) {
			for (int j = i; j < col - i; j++) {
				list.add(matrix[i][j]);
			}
			for (int j = i + 1; j < row - i; j++) {
				list.add(matrix[j][col - i - 1]);
			}
			for (int j = col - i - 2; (j >= i) && (row - i - 1 != i); j--) {
				list.add(matrix[row - i - 1][j]);
			}
			for (int j = row - i - 2; (j >= i + 1) && (col - i - 1 != i); j--) {
				list.add(matrix[j][i]);
			}
		}
		return list;
	}

	// print a matrix
	public static void printMatrix(int[][] array) {
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
