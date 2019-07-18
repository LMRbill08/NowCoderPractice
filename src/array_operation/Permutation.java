package array_operation;

import java.util.ArrayList;
import java.util.Collections;

public class Permutation {

	public ArrayList<String> function(String str) {
		if (str == "") {
			return null;
		}

		char[] ch = str.toCharArray();
		ArrayList<String> result = new ArrayList<>();

		Collections.sort(result);

		return result;
	}
}
