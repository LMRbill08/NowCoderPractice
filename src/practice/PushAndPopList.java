package practice;
import java.util.*;

/*
 * given two lists, one list contains the elements whose order is the push order of a stack, 
 * while another list contains the elements whose order is the pop order of the same stack. 
 * check if the two lists are correct 
 */

public class PushAndPopList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] pushA = { 1, 2, 3, 4, 5 };
		int[] popA = { 4, 5, 3, 2, 1 };
		boolean result = IsPopOrder(pushA, popA);
		System.out.println(result);
	}

	public static boolean IsPopOrder(int[] pushA, int[] popA) {
		Stack<Integer> stack = new Stack<Integer>();
		int index = 0;
		for (int i = 0; i < pushA.length; i++) {
			stack.push(pushA[i]);
			while (!stack.empty() && stack.peek() == popA[index]) {
				stack.pop();
				index++;
			}
		}
		return stack.empty();
	}
}
