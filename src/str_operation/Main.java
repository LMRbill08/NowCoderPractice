package str_operation;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("===============Replace Space to \"%20\"===============");
		String strReplaceSpaceString = "Hello, this is Bill!";
		System.out.println("String is: " + strReplaceSpaceString);
		System.out.println("New String is: " + SpaceReplacement.replaceSpace(new StringBuffer(strReplaceSpaceString)));
		System.out.println();
		
		System.out.println("===============Print The First Not Repeating Char in String===============");
		String firstSingleOccurChar = "google";
		System.out.println("String is: " + firstSingleOccurChar);
		int firstChar = FirstNotRepeatingChar.func2(firstSingleOccurChar);
		System.out.println("Index of first not repeating char is: " + firstChar);
		System.out.println();

		System.out.println("===============Left Rotate String===============");
		String leftRotateStr = "abcdefg";
		int rotateBit = 3;
		System.out.println("String is: " + leftRotateStr);
		System.out.println("Rotate Bit is: " + rotateBit);
		System.out.println("Result is: " + LeftRotateString.function(leftRotateStr, rotateBit));
		System.out.println("");
		
		System.out.println("==============Reverse Sentence==============");
		String strRev = "Hi, this is Bill. ";
		System.out.println(strRev);
		System.out.println(ReverseSentence.function(strRev));
		
		
	}

}
