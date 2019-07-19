
/* This is a component class,
 * Consists of methods to perform Search operations on an array.
 * Recursive approach is used.
 * @author Bhupendra
 */
public class Search {
	// Static variables used to perform recursive Linear Search.
	static int index = 0;
	static int flag = 0;

	/* This method recursively perform searching of an element in an array provided as an argument
	 * using Linear Search algorithm.
	 * Returns index if element is found, -1 otherwise.
	 * @param array of elements
	 * @param n number to be searched in given array
	 * @return index of array where element is found, otherwise -1
	 */
	public int linearSearch(int array[], int n) {
		// Will execute only once per instance.
		if (flag == 0) {
			flag = 1;
			index = 0;
		}
		
		// If array is empty.
		if (index == array.length) {
			flag = 0;
			return -1;
		}

		// Base case.
		if (array[index] == n) {
			flag = 0;
			return index;
		}

		index++;
		return linearSearch(array, n);
	}

	// Static variables used to perform recursive Binary Search.
	static int pivot;
	static int start;
	static int end;
	static int flagB = 0;

	/* This method recursively perform searching of an element in an array provided as an argument
	 * using Binary Search algorithm.
	 * @param array of elements.
	 * @param n number to be searched in given array.
	 * @return index of array where element is found, otherwise -1.
	 */
	public int binarySearch(int array[], int n) {
		// Will execute only once per instance.
		if (flagB == 0) {
			
			// If array is empty.
			if(array.length == 0)
				return -1;
			
			// Initialization of variables.
			flagB = 1;
			pivot = array.length / 2;
			start = 0;
			end = array.length - 1;
		}
		
		// If searched element doesn't exist in given array.
		if (n > array[array.length - 1] || n < array[0]){					
			flagB = 0;
			return -1;
		}
		
		// Base case.
		if (array[pivot] == n) {
			flagB = 0;
			return pivot;
		}
		
		// If pivot element is greater than searched element. 
		if (array[pivot] > n) {
			end = pivot - 1;
			pivot = (start + end) / 2;
			return binarySearch(array, n);
		}
		// If pivot element is smaller than searched element.
		if (array[pivot] < n) {
			start = pivot + 1;
			pivot = (start + end) / 2;
			return binarySearch(array, n);
		}
		return -1;
	}
}
