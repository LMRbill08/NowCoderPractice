package array_operation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SortByOccurTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 1, 1, 2, 2, 2, 3, 3, 6, 6, 66, 6, 6, 6 };
		int[] result = reArrangeArray(initHashMap(array));
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}

	public static HashMap<Integer, Integer> initHashMap(int[] array) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < array.length; i++) {
			if (map.containsKey(array[i])) {
				map.put(array[i], map.get(array[i] + 1));
			} else {
				map.put(array[i], 1);
			}
		}
		return map;
	}

	public static int[] reArrangeArray(HashMap<Integer, Integer> map) {
		Set<Entry<Integer, Integer>> set = map.entrySet();
		List<Map.Entry<Integer, Integer>> infoIds = new ArrayList<>(set);
		Collections.sort(infoIds, new Comparator<Map.Entry<Integer, Integer>>() {
			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				// TODO Auto-generated method stub
				return (o2.getValue() - o1.getValue());
			}
		});
		return null;
	}
}
