package str_operation;

public class SpaceReplacement {
	public static String replaceSpace(StringBuffer sBuffer) {
		int len = sBuffer.length();
		int spaceNum = 0;
		for (int i = 0; i < len; i++) {
			if (sBuffer.charAt(i) == ' ') {
				spaceNum++;
			}
		}
		int newLen = len + 2 * spaceNum;
		int oldIndex = len - 1;
		int newIndex = newLen - 1;
		sBuffer.setLength(newLen);
		for (; oldIndex >= 0 && oldIndex < newIndex; oldIndex--) {
			if (sBuffer.charAt(oldIndex) == ' ') {
				sBuffer.setCharAt(newIndex--, '0');
				sBuffer.setCharAt(newIndex--, '2');
				sBuffer.setCharAt(newIndex--, '%');
			} else {
				sBuffer.setCharAt(newIndex--, sBuffer.charAt(oldIndex));
			}
		}
		return sBuffer.toString();
	}
}
