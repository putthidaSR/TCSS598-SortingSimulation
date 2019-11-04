/**

 * This class represents business logic that implements Bubble Sort algorithm.

 */

public class BubbleSort extends SortingPrecondition {

	

	public BubbleSort(final int[] inputArray) {

		super(inputArray);

	}

	

	/**

	 * Utility method that contains Bubble Sort algorithm.

	 * @param inputArray The given array contains elements to be sorted

	 */

	public void sort(final int[] inputArray) {

		

		boolean isSorted = false;

		

		// last element is already in placed after each iteration

		int lastUnsorted = inputArray.length - 1;

		

		while (!isSorted) {

			

			isSorted = true;

			

			for (int i = 0; i < lastUnsorted; i++) {

				

				// swap each pair of adjacent elements if they are not in order

				if (inputArray[i] > inputArray[i + 1]) {

					swap(inputArray, i, i + 1);

					isSorted = false;

				}

			}

			lastUnsorted--;

		}

		

	}

	

	/**

	 * Helper method to swap two elements in the given array.

	 * @param arr Array that contains the elements to be swapped

	 * @param i Index of the element to be swapped

	 * @param j Index of the other element to be swapped

	 */

	private static void swap(final int[] arr, final int i, final int j) {

		int temp = arr[i];

		arr[i] = arr[j];

		arr[j] = temp;

	}

	

}