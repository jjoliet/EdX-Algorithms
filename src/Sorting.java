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

	/* Merge sort Algorithm.  Due to the recursion, this one does not as easily for printing out the array in the driver class */
	public static int[] mergeSort(int[] arr) {
		if(arr == null) {
			return null;
		}
		
		int length = arr.length;

		if(length > 1) {
			int[] left = new int[length/2];
			int[] right = new int[length - (length/2)];
			int lInd = 0;
			int rInd = 0;
			/* Go through and assign the elements of the array to a left or right side split array. */
			for(int i = 0; i < length; i++) {
				if(i < length/2) {
					/* Less then halfway, so add to left side */
					left[lInd++] = arr[i];
				}else {
					/* More than halfway point, add to right side array. */
					right[rInd++] = arr[i];
				}
			}

			/* Recursive call to continue splitting the left and right sides */
			left = mergeSort(left);
			right = mergeSort(right);
			return merge(left, right);
		}else {
			/* Base case so we always make sure to return */
			return arr;
		}	
	}

	private static int[] merge(int[] left, int[] right) {
		int i = 0;
		int lInd = 0;
		int rInd = 0;
		System.out.println("MERGING: " + Arrays.toString(left) + " | " + Arrays.toString(right));
		int[] mergedArray = new int[left.length + right.length];
		/* Go through each arrays index until one of the sub arrays has been depleted. This is where it is sorting. */
		while(lInd < left.length && rInd < right.length) {
			if(left[lInd] < right[rInd]) {
				mergedArray[i++] = left[lInd++];
			}else {
				mergedArray[i++] = right[rInd++];
			}
		}		
		/* Go through the remainder of the array that has not been depleted */
		while(lInd < left.length) {
			mergedArray[i++] = left[lInd++];
		}
		while(rInd < right.length) {
			mergedArray[i++] = right[rInd++];
		}

		System.out.println("MERGED ARRAY: " + Arrays.toString(mergedArray));
		return mergedArray;
	}
}
