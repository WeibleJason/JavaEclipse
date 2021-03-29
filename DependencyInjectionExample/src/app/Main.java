package app;

import java.util.Arrays;
import java.util.Collections;

public class Main {
	
	public static void merge(int[] array, int low, int mid, int high) {
		// implementation from: https://stackabuse.com/merge-sort-in-java/
		int leftArray[] = new int[mid - low + 1];
		int rightArray[] = new int[high - mid];
		
		// Copy subarrays into temp
		for (int i = 0; i < leftArray.length; i++)
			leftArray[i] = array[low + i];
		for (int i = 0; i < rightArray.length; i++)
			rightArray[i] = array[mid + i + 1];
		
		// iterators containing current index of temp subarrays
		int leftIndex = 0;
		int rightIndex = 0;
		
		// Copying from leftArray and rightArray back into array
		for (int i = low; i < high + 1; i++) {
			// if there are still uncopied elements in R and L, copy minimum of the two
			if (leftIndex < leftArray.length && rightIndex < rightArray.length) {
				if(leftArray[leftIndex] < rightArray[rightIndex]) {
					array[i] = leftArray[leftIndex];
					leftIndex++;
				} else {
					array[i] = rightArray[rightIndex];
					rightIndex++;
				}
			} else if(leftIndex < leftArray.length) {
				// if all elements have been copied from rightArray, copy rest of LeftArray
				array[i] = leftArray[leftIndex];
			} else if (rightIndex < rightArray.length) {
				// if all elements have been copied from LeftArray, copy rest of RightArray
				array[i] = rightArray[rightIndex];
				rightIndex++;
			}
		}
		
		
	}
	
	public static void mergeSort(int[] array, int low, int high) {
		if (high <= low) return;
		
		int mid = (low+high)/2;
		mergeSort(array, low, mid); // sort left half
		mergeSort(array, mid + 1, high); // sort right half
		merge(array, low, mid, high);
		
	}
	
	
	
	static void printArray(int[] array) {
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
		}
		
	}

	public static void main(String[] args) {
		int[] unsortedArray1 = {9, 4, 5, 2, 8, 3, 1, 8, 0, 2, 6};
		Integer[] unsortedArray2 = {9, 4, 5, 2, 8, 3, 1, 8, 0, 2, 6};
		
		mergeSort(unsortedArray1, 0, unsortedArray1.length - 1);
		int[] sortedArray = unsortedArray1;
		
//		Arrays.sort(unsortedArray2, Collections.reverseOrder());
		Arrays.sort(unsortedArray2, Collections.reverseOrder());
		System.out.print(Arrays.toString(unsortedArray2));
		System.out.println();
		
		printArray(sortedArray);
		
	}

}
