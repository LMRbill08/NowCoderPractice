package practice;

public class FirstNotRepeatingChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "google";
		int result = firstNotRepeatingChar(str);
		System.out.println(result);

	}
	
	public static int firstNotRepeatingChar(String str) {
		String s = str;
		int len = s.length();
		boolean flag = true;
		for (int i = 0; i < len - 1; i++) {
			flag = true;
			char temp = s.charAt(i);
			if (temp == '*') continue;
			for (int j = i + 1; j < len; j++) {
				if (s.charAt(j) == temp) {
					s = s.replace(temp, '*');
					flag = false;
				}
			}
			if (flag == true) return i;
		}
		return -1;
	}

}
