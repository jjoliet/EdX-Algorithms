import java.util.Arrays;

public class Sorting {

	/**
	 * Selection Sort algorithm written for edX Course: Microsoft: DEV285x Algorithms and Data Structures
	 * @param array of integer values.
	 */
	public static void SelectionSort(int[] arr) {
		if (arr == null) {
			return;
		}
		// Iterate through each element in the array
		for (int i = 0; i < arr.length; i++) {
			// Grab the minimum values position in the subarray from i to the end of the
			// array.
			int minPos = minimum(i, arr);
			// swap the min values position into the current position
			swap(i, minPos, arr);
		}
		System.out.println(Arrays.toString(arr));
	}

	private static void swap(int firstPos, int minPos, int[] arr) {
		// Assign a temp value for the first position
		int temp = arr[firstPos];
		// Assign the minimumPosition value to the first position (of the 'subarray')
		arr[firstPos] = arr[minPos];
		// Reassign the former minimum values position to the temp value holding the
		// first positions value.
		arr[minPos] = temp;
	}

	private static int minimum(int start, int[] arr) {
		int min = arr[start];
		int position = start;
		// Only go through the sub array
		for (int i = (start + 1); i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
				position = i;
			}
		}
		return position;
	}

	public static void BubbleSort(int[] arr) {
		if(arr == null) {
			return;
		}
		boolean swapped;
		do {
			//Set swapped to false before each run. 
			swapped = false;
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i] > arr[i + 1]) {
					// If the value to the right is lower than the value to the left, swap.
					swap(i, i + 1, arr);
					// Set swapped flag to true after the swap.
					swapped = true;
				}
			}
			//Keep going if a value has been swapped, otherwise exit loop.
		} while (swapped);
		System.out.println(Arrays.toString(arr));
	}
}
