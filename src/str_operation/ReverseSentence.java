package str_operation;

public class ReverseSentence {
	public static String function(String str) {
		if (str.trim().equals("")) {
			return str;
		}
		String[] arr = str.split(" ");
		StringBuilder sBuilder = new StringBuilder();
		for (int i = arr.length - 1; i >=0; i--) {
			sBuilder.append(arr[i]);
			if (i > 0) {
				sBuilder.append(" ");
			}
		}
		return sBuilder.toString();
	}
}
