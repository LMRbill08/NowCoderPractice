package practice;

import java.util.*;

public class ClockwisePrintMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		// int[][] matrix = { { 1, 2, 3, 4 }};
		// int[][] matrix = {{1}, {2}, {3}, {4}, {5}};
		ArrayList<Integer> list = printMatrix(matrix);
		System.out.println(list.toString());
	}

	public static ArrayList<Integer> printMatrix(int[][] matrix) {
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
}
