import java.util.Arrays;

/**

 * This class represents pre-condition logics that should be performed prior to running any sorting algorithms.

 */

public class SortingPrecondition {

	

	public SortingPrecondition(final int[] inputArray) {

		

		if (inputArray.length == 0) {

			throw new IllegalArgumentException("The given Array must not be empty.");

		}

		

		if (inputArray.length == 1) {

			System.out.println("Array is already sorted.");

			return;

		}

	}

  public void sort(final int[] inputArray){
    Arrays.sort(inputArray);
    System.out.println("default method");
  }
	

}