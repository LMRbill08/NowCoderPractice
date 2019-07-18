package array_operation;

import java.util.HashMap;

public class FirstNotRepeatingChar {

	// replace every character that equals to the current one (bad time complexity)
	public static int func1(String str) {
		String s = str;
		int len = s.length();
		boolean flag = true;
		for (int i = 0; i < len - 1; i++) {
			flag = true;
			char temp = s.charAt(i);
			if (temp == '*')
				continue;
			for (int j = i + 1; j < len; j++) {
				if (s.charAt(j) == temp) {
					s = s.replace(temp, '*');
					flag = false;
				}
			}
			if (flag == true)
				return i;
		}
		return -1;
	}

	// use hash map
	public static int func2(String str) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			if (map.containsKey(str.charAt(i))) {
				int time = map.get(str.charAt(i)) + 1;
				map.replace(str.charAt(i), time);
			} else {
				map.put(str.charAt(i), 1);
			}
		}
		int pos = -1;
		for (int i = 0; i < str.length(); i++) {
			if (map.get(str.charAt(i)) == 1) {
				return i;
			}
		}
		return pos;
	}

}
