import java.util.Arrays;

/**
 * Driver class for running the algorithms written for EdX class: 
 * Microsoft: DEV285x Algorithms and Data Structures
 * 
 * @author jjoliet
 */
public class AlgorithmDriver {

	public static void main(String[] args) {
		int[] arr = new int[] { 5, 12, 3, 72, 4, 26 };
		int[] arr2 = new int[] { 45 };
		int[] arr3 = null;
		int[] arr4 = new int[] {};
		
//		Sorting.SelectionSort(arr4);
//		Sorting.BubbleSort(arr4);
		Sorting.mergeSort(arr);
	}
}
