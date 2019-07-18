package other;
import java.util.ArrayList;

public class Fibonacci {
	ArrayList<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10;
		int res1 = fibLoop(n);
		int res2 = fibRecursion(n);
		int res3 = fibTailRecursion(n);
		int res4 = fibDP(n);
		System.out.println(res4);
	}

	// using loop
	public static int fibLoop(int n) {
		int firstNum = 0;
		int sndNum = 1;
		int result = 0;
		if (n == 0 || n == 1) {
			return n;
		} else {
			for (int i = 2; i <= n; i++) {
				result = firstNum + sndNum;
				firstNum = sndNum;
				sndNum = result;
			}
			return result;
		}
	}

	// using recursion
	public static int fibRecursion(int n) {
		if (n == 0 || n == 1) {
			return n;
		} else {
			return fibRecursion(n - 1) + fibRecursion(n - 2);
		}
	}

	// using tail recursion
	public static int fibTailRecursion(int n) {
		return fibTailRecursion(n, 0, 1);
	}

	public static int fibTailRecursion(int n, int acc1, int acc2) {
		if (n == 0)
			return n;
		if (n == 1)
			return acc2;
		else
			return fibTailRecursion(n - 1, acc2, acc1 + acc2);
	}

	// using Dynamic Planning
	public static int fibDP(int n) {
		if (n <= 1) {
			return n;
		}
		int[] record = new int[n + 1];
		record[0] = 0;
		record[1] = 1;
		for (int i = 2; i <= n; i++) {
			record[i] = record[i - 1] + record[i - 2];
		}
		return record[n];
	}
}
