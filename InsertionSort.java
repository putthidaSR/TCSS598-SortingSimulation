/**

 * This class represents business logic that implements Insertion Sort algorithm.

 */

public class InsertionSort extends SortingPrecondition {



	public InsertionSort(final int[] inputArray) {

		super(inputArray);

	}

	

	/**

	 * Utility method that contains Insertion Sort algorithm.

	 * @param inputArray The given array contains elements to be sorted.

	 */

	public  void sort(final int[] inputArray) {

				

		// Iterate through unsorted input from left to right

		for (int i = 1; i < inputArray.length; i++) {

			

			// Iterate through sorted list from right to left

			for (int j = i; j > 0; j--) {



				if (inputArray[j] < inputArray[j - 1]) {

					int temp = inputArray[j];

					inputArray[j] = inputArray[j - 1];

					inputArray[j - 1] = temp;

				}

			}

		}

		

	}

}