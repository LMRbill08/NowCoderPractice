package practice;

/*
 * ����һ�����󣬰��մ���������˳ʱ���˳�����δ�ӡ��ÿһ������
 * ���磬�����������4 X 4���� 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 
 * �����δ�ӡ������1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */

import java.util.*;

public class ClockwisePrintMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		ArrayList<Integer> list = printMatrix(matrix);
		System.out.println(list.toString());
	}

	public static ArrayList<Integer> printMatrix(int[][] matrix) {
		ArrayList<Integer> list = new ArrayList<>();
		int row = matrix.length;
		int col = matrix[0].length;
		int round = (Math.min(row, col) - 1) / 2 + 1;
		for (int i = 0; i < round; i++) {
			for (int k = i; k < col - i; k++) {
				list.add(matrix[i][k]);
			}
			for (int k = i + 1; k < row - i; k++) {
				list.add(matrix[k][row - i - 1]);
			}
			for (int k = col - i - 2; (k >= i) && (row - i - 1 != i); k--) {
				list.add(matrix[row - i - 1][k]);
			}
			for (int k = row - i - 2; (k > i) && (col - i - 1 != i); k--) {
				list.add(matrix[k][i]);
			}
		}
		return list;
	}
}
