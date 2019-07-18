package array_operation;

public class QuickSort {

	// quick sort
	public static int[] quickSort(int[] array) {
		qSort(array, 0, array.length - 1);
		return array;
	}

	public static void qSort(int[] array, int low, int high) {
		int i = low;
		int j = high;
		int temp;
		if (i >= j)
			return;
		int pivot = array[low];
		while (i < j) {
			while (array[j] >= pivot && j > i) {
				j--;
			}
			while (array[i] <= pivot && i < j) {
				i++;
			}
			if (i < j) {
				temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		array[low] = array[i];
		array[i] = pivot;
		qSort(array, low, j - 1);
		qSort(array, j + 1, high);
	}
}
