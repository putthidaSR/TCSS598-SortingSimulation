package service;

import java.util.ArrayList;
import java.util.List;

/**
 * This class contains business logic to implement any measure of sortedness methods.
 */
public class MeasureOfSortedness {

	/**
	 * Returns the list that constructs from the longest subsequence of a given input list 
	 * such that all elements of the new list are sorted in increasing order.
	 * 
	 * Example:
	 * Input:  [10, 22, 9, 33, 21, 50, 41, 60, 80]
	 * Output: [10, 22, 33, 50, 60, 80] 
	 * 
	 * Logic of the implementation is from: https://www.geeksforgeeks.org/java-program-for-longest-increasing-subsequence/
	 * 
	 * @param inputArray The original array that will construct the longest subsequence list from
	 * @return List of sorted elements in increasing order
	 */
	public static List<Integer> getLongestIncreasingSubsequence(final int[] inputArray) {
		
		List<Integer> longestSubsequenceList = new ArrayList<Integer>();
		
		// Temporary list that holds current longest increasing subsequence elements
        List<Integer> tempList = new ArrayList<Integer>(); 

		int currentMax = 0;
		int highestCount = 0;
		
		for (int i = 0; i < inputArray.length; i++) {
			
			currentMax = Integer.MIN_VALUE;
			
			for (int j = i; j < inputArray.length; j++) {
				
				if (inputArray[j] > currentMax) {
					tempList.add(inputArray[j]);
					currentMax = inputArray[j];
				}
			}

		    // Compare previous highest subsequence  
            if(highestCount < tempList.size()) {
                highestCount = tempList.size(); 
                longestSubsequenceList = new ArrayList<Integer>(tempList);   
            }
            
            tempList.clear(); 
		}
		
		return longestSubsequenceList;
	}

}
