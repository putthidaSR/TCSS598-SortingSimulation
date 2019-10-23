package service;

/**
 * This class represents business logic that implements Selection Sort algorithm.
 */
public class SelectionSort extends SortingPrecondition {

	public SelectionSort(final int[] inputArray) {
		super(inputArray);
	}
	
	/**
	 * Utility method that contains Selection Sort algorithm.
	 * @param inputArray The given array contains elements to be sorted.
	 */
	public static void performSelectionSort(final int[] arr) {
		
		for (int i = 0; i < arr.length; i++) {
			
			int minIndex = i;
			
			// loop through every other element in the list to find the smallest one
			for (int j = i + 1; j < arr.length; j++) {
				
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			
			// swap current element with the smallest element found
			int smallestElement = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = smallestElement;
		}
	}

}
