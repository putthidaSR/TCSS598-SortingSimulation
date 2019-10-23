package service;

/**
 * This class represents business logic that implements Merge Sort algorithm.
 */
public class MergeSort extends SortingPrecondition {

	public MergeSort(final int[] inputArray) {
		super(inputArray);
	}

	/**
	 * Utility method that contains business logic for Merge Sort algorithm.
	 * @param inputArray The given array contains elements to be sorted
	 */
	public static void performMergeSort(final int[] inputArray) {
		sort(inputArray, 0, inputArray.length - 1);
	}

	/**
	 * Helper method that utilizes divide and conquer algorithmic paradigm to implement merge sort algorithm.
	 * @param inputArray Represents the given unsorted array contains elements to be sorted
	 * @param start Represents the starting index of the element in unsorted array
	 * @param end Represents the last index of the element in unsorted array
	 */
	public static void sort(int[] inputArray, int start, int end) {
		
		if (end <= start) {
			return; // we're done traversing the array
		}

		// Divide steps: Sort left and right half
		int mid = (start + end) / 2;
		sort(inputArray, start, mid);
		sort(inputArray, mid + 1, end);
		
		// Conquer step: merge sorted results into inputArray
		merge(inputArray, start, mid, end);
	}

	/**
	 * Sort given elements in the array in order.
	 * @param inputArray Represents the given unsorted array contains elements to be sorted
	 * @param start Represents the index of left slot
	 * @param mid Represents the index of the middle element in the array
	 * @param end Represents the last index of right slot
	 */
	private static void merge(int inputArray[], int start, int mid, int end) {

		int tempArray[] = new int[end - start + 1];

		// index counter of left side of array
		int leftSlot = start;

		// index counter of right side of array
		int rightSlot = mid + 1;

		int k = 0;

		// Iterate over left and right slots of the input array and store it into the temporary array as a place holder
		while (leftSlot <= mid && rightSlot <= end) {

			if (inputArray[leftSlot] < inputArray[rightSlot]) {
				tempArray[k] = inputArray[leftSlot];
				leftSlot++;

			} else {
				tempArray[k] = inputArray[rightSlot];
				rightSlot++;
			}

			k++;
		}

		/*
		 * When reaching here, that means the above loop has completed. So both the
		 * right and the left side of the sub-array can be considered sorted.
		 */
		if (leftSlot <= mid) {
			while (leftSlot <= mid) {
				tempArray[k] = inputArray[leftSlot];
				leftSlot++;
				k++;
			}
			
		} else if (rightSlot <= end) {
			while (rightSlot <= end) {
				tempArray[k] = inputArray[rightSlot];
				rightSlot++;
				k++;
			}
		}

		// Copy over the tempArray into the appropriate slots of the inputArray
		for (int i = 0; i < tempArray.length; i++) {
			inputArray[start + i] = tempArray[i];
		}
	}
}
