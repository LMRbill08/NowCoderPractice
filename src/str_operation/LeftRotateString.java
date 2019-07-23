package str_operation;

public class LeftRotateString {
	public static String function(String str, int n) {
		if (str == null || n < 0)
			return null;
		int len = str.length();
		if (len == 0)
			return str;
		int bit = n % len;
		if (bit == 0)
			return str;
		StringBuilder sBuilder = new StringBuilder(str);
		sBuilder.append(sBuilder.substring(0, bit));
		sBuilder.delete(0, bit);
		return sBuilder.toString();
	}
}
