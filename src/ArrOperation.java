
/* This is a component class.
 * This class consists of methods to perform different operations on arrays.
 * @author Bhupendra
 */
public class ArrOperation {
	
	/* This method return the size of the largest mirror section found in the input
	 * array.
	 * @param array 
	 * @return size of largest mirror
	 */
	public int maxMirror(int array[]) {
		if(array.length == 0)
			throw new AssertionError("Array is Empty.");
		int count = 0, max = 0;
		for (int i = 0; i < array.length; i++) {
			int temp = i;
			for (int j = 0; j < array.length; j++) {
				int temp2 = j;
				if (!(temp < array.length)) {
					if (count > max) {
						max = count;
					}
					temp = i;
					break;
				}
				if (array[temp] == array[array.length - 1 - j]) {
					count++;
					temp++;
				} else {
					if (count > max)
						max = count;
					if (temp != i)
						j = temp2 - 1;
					temp = i;
					count = 0;
				}
			}
			if (count > max)
				max = count;
			count = 0;
		}
		return max;
	}

	/* This methods returns the number of clumps in an array. Clump in an array is a
	 * series of 2 or more adjacent elements of the same value.
	 * @param array
	 * @return number of clumps in the given array.
	 */
	public int countClumps(int array[]) {
		int count = 0, flag = 0;
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] == array[i + 1])
				flag = 1;
			else {
				if (flag == 1) {
					count++;
					flag = 0;
				}
			}
		}
		if (flag == 1)
			count++;
		return count;
	}

	/* This method return an array that contains exactly the same numbers as the
	 * input array, but rearranged so that every x is immediately followed by a y.
	 * @param x
	 * @param y
	 * @param array
	 * @return array of rearranged values of x & y.
	 */
	public int[] fixXY(int x, int y, int array[]) {
		if (array.length == 0)
			throw new AssertionError("Array is Empty.");

		// Check if occurence of x & y are equal, throws Assertion error otherwise.
		int countx = 0, county = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == x) {
				if (i < array.length - 1 && array[i + 1] == x)
					throw new AssertionError("Two adjacents X values are there.");
				countx++;
			}
			if (array[i] == y)
				county++;
		}
		if (countx != county)
			throw new AssertionError("There are unequal numbers of X and Y " + "in input array.");

		int y1 = -1;
		for (int i = 0; i < array.length; i++) {
			// If x is the last element in array, throws Assertion error.
			if (i == array.length - 1 && array[i] == x)
				throw new AssertionError("X occurs at the last index of array.");
			if (i < array.length - 1 && array[i] == x && array[i + 1] == y) {
				i = i + 1;
				continue;
			}
			if (array[i] == x) {
				if (y1 != -1) {
					ArrOperation.swap(i + 1, y1, array);
					y1 = -1;
					i++;
				} else {
					int temp = i + 2;
					while (temp < array.length && array[temp] != y)
						temp++;
					if (temp < array.length && array[temp] == y) {
						ArrOperation.swap(i + 1, temp, array);
						i++;
					}
				}
				continue;
			}
			if (array[i] == y && y1 == -1)
				y1 = i;
		}
		return array;
	}

	/* Return the index if there is a place to split the input array so that the sum
	 * of the numbers on one side is equal to the sum of the numbers on the other
	 * side else return -1.
	 * @param array
	 * @return index to split the array
	 */
	public int splitArray(int array[]) {
		if (array.length == 0)
			throw new AssertionError("Array Is Empty!");

		int sum = 0, index = 0;
		for (int i = 0; i < array.length; i++)
			sum = sum + array[i];

		if (sum % 2 != 0)
			return -1;
		else {
			int tempSum = 0;
			while (tempSum != (sum / 2)) {
				tempSum = tempSum + array[index];
				index++;
				if (tempSum > (sum / 2))
					return -1;
			}
		}
		return index;
	}

	/* This method is used to swap values in given array present at given two
	 * indices. 
	 * @param x index in array 
	 * @param y index in array
	 * @param array with swapped values
	 */
	public static void swap(int x, int y, int array[]) {
		array[x] = array[x] + array[y];
		array[y] = array[x] - array[y];
		array[x] = array[x] - array[y];
	}

}
