package service;

/**
 * This class represents business logic that implements Quick Sort algorithm.
 */
public class QuickSort extends SortingPrecondition {

	public QuickSort(final int[] inputArray) {
		super(inputArray);
	}
	
	/**
	 * Utility method that contains Quick Sort algorithm.
	 * @param inputArray The given array contains elements to be sorted
	 */
	public static void performQuickSort(final int[] inputArray) {
		quickSort(inputArray, 0, inputArray.length - 1);
	}

	/**
	 * Recursive method that utilizes divide and conquer algorithmic paradigm to implement quick sort algorithm.
	 * @param inputArray The given array contains elements to be sorted
	 * @param start first index of the given array
	 * @param end last index of the given array
	 */
	public static void quickSort(int[] inputArray, int start, int end) {

		if (end <= start) {
			return; // done traversing array (elements are sorted)
		}

		// partition the input array into two parts: less than pivot value and greater or equal to pivot value
		int pivotLocation = partition(inputArray, start, end);
		
		quickSort(inputArray, start, pivotLocation - 1); // Sorts elements before pivot
		quickSort(inputArray, pivotLocation + 1, end); // Sorts elements after pivot
	}

	/**
	 * Utility method to sort elements in array in the correct order by placing any elements that are smaller than or equal to the pivot on the left side,
	 * and any elements that are greater than the pivot on the right side.
	 * 
	 * @param inputArray The given array contains elements to be sorted
	 * @param start first index of the given array
	 * @param end last index of the given array
	 * @return index of the next pivot location
	 */
	public static int partition(int[] inputArray, int start, int end) {
		
		int pivotIndex = end;
		int pivot = inputArray[end]; // make the last element as pivot element
		int leftPointer = start - 1; // index counter starting from the beginning of unsorted array (left side of pivot)

		for (int j = start; j < end; j++) {

			if (inputArray[j] <= pivot) {
				leftPointer += 1;
				swap(inputArray, leftPointer, j);
			}
		}

		swap(inputArray, leftPointer + 1, pivotIndex); // place the pivot element in its proper order
		return leftPointer + 1;
	}

	/**
	 * Helper method to swap two elements in the given array.
	 * 
	 * @param inputArray Array that contains the elements to be swapped
	 * @param i Index of the element to be swapped
	 * @param j Index of the other element to be swapped
	 */
	private static void swap(final int[] inputArray, final int i, final int j) {
		int temp = inputArray[i];
		inputArray[i] = inputArray[j];
		inputArray[j] = temp;
	}
}
