package array_operation;

import java.util.Arrays;
import java.util.Comparator;

public class PrintMinNumber {
	public static String function(int[] numbers) {
		if (numbers == null || numbers.length == 0)
			return "";
		int len = numbers.length;
		String[] str = new String[len];
		for (int i = 0; i < len; i++) {
			str[i] = String.valueOf(numbers[i]);
		}
		Arrays.sort(str, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				String s1 = o1 + o2;
				String s2 = o2 + o1;
				return s1.compareTo(s2);
			}
		});
		StringBuilder sBuilder = new StringBuilder();
		for (int i = 0; i < len; i++) {
			sBuilder.append(str[i]);
		}
		return sBuilder.toString();
	}

}
