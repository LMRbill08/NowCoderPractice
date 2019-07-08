package practice;
import java.util.ArrayList;

public class FindLeastK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 5, 8, 2, 3, 7, 6, 9, 1, 4 };
		ArrayList<Integer> list = GetLeastNumbers_Solution(a, 10);
		System.out.println(list.toString());
	}
	
	public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
		ArrayList<Integer> list = new ArrayList<Integer>();
        if (k > input.length) return list;
        for (int i = 0; i < k; i++) {
            int temp = input[i];
            int index = i;
            for (int j = i + 1; j < input.length; j++) {
				if (input[j] < temp) {
					temp = input[j];
					index = j;
				}
			}
            temp = input[i];
            input[i] = input[index];
            input[index] = temp;
            list.add(input[i]);
        }
        return list;
	}
}
