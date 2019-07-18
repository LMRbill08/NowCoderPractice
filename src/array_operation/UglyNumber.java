package array_operation;

import java.util.ArrayList;

/*
 *  Numbers containing only prime factors 2, 3, and 5 are called ugly Numbers
 *  given the number of index of ugly number lists 
 *  return the Nth ugly number in order from smallest to largest
 *   the first number is 1
 */
public class UglyNumber {
	public static int function(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		int i2 = 0, i3 = 0, i5 = 0;
		while (list.size() < n) {
			int m2 = list.get(i2) * 2;
			int m3 = list.get(i3) * 3;
			int m5 = list.get(i5) * 5;
			int min = Math.min(m2, Math.min(m3, m5));
			if (min == m2)
				i2++;
			if (min == m3)
				i3++;
			if (min == m5)
				i5++;
			list.add(min);
		}
		return list.get(list.size() - 1);
	}

}
