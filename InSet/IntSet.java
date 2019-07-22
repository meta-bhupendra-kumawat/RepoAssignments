import java.util.ArrayList;
import java.util.List;

/* This is a component class.
 * This class is implemented to store and perform operations on integer set.
 * @author Bhupendra
 */
public class IntSet {
	// Instance variables.
	final int set[];
	static int universal[] = new int[1000];
	
	// Initializing Universal set.
	{
		for (int i = 0; i < universal.length; i++)
			universal[i] = i + 1;
	}

	/* Parameterised Constructor
	 * @param array of integers.
	 */
	public IntSet(int array[]) {
		IntSet.sort(array);
		array = IntSet.removeDuplicate(array);
		this.set = array;
	}

	/* This method checks that given integer x is part of set.
	 * @param x integer
	 * @return true if x is a member of set, false otherwise.
	 */
	public boolean isMember(int x) {
		int array[] = this.set;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == x)
				return true;
		}
		return false;
	}

	/* This method counts the number of members in a set.
	 * @return size of set.
	 */
	public int size() {
		return set.length;
	}

	/* This method checks whether a set is SubSet of a another set.
	 * @param sub set of integer.
	 * @return true if set is subset of caller set, false otherwise.
	 */
	public boolean isSubSet(IntSet sub) {
		int set[] = this.set;
		int subSet[] = sub.set;
		int j = 0;
		int count = 0;

		for (int i = 0; i < subSet.length; i++) {
			while (j < set.length) {
				if (subSet[i] == set[j]) {
					count++;
					break;
				}
				j++;
			}
		}
		if (count == subSet.length)
			return true;
		else
			return false;
	}

	/* This method is used to find out the complement set of the given set.
	 * @return complement set.
	 */
	public IntSet getComplement() {

		int setArrayA[] = this.set;
		int countA = 0, countU = 0;
		int n = setArrayA.length + universal.length;

		List<Integer> complementList = new ArrayList<Integer>();

		for (int i = 0; i < n - 1; i++) {
			if (countA == setArrayA.length && countU == universal.length)
				break;
			if (countA == setArrayA.length && countU < universal.length) {
				complementList.add(universal[countU++]);
				continue;
			}
			if (countU == universal.length && countA < setArrayA.length) {
				complementList.add(setArrayA[countA++]);
				continue;
			}
			if (setArrayA[countA] < universal[countU]) {
				complementList.add(setArrayA[countA++]);
				continue;
			}
			if (setArrayA[countA] > universal[countU]) {
				complementList.add(universal[countU++]);
				continue;
			}
			if (setArrayA[countA] == universal[countU]) {
				countA++;
				countU++;
			}
		}
		return new IntSet(IntSet.listToArray(complementList));
	}

	/* This method is used to perform union of given two set a & b.
	 * @param setA
	 * @param setB
	 * @return union set.
	 */
	public static IntSet union(IntSet setA, IntSet setB) {
		int setArrayA[] = setA.set;
		int setArrayB[] = setB.set;
		int countA = 0, countB = 0;
		int n = setArrayA.length + setArrayB.length;

		List<Integer> unionList = new ArrayList<Integer>();

		for (int i = 0; i < n - 1; i++) {
			if (countA == setArrayA.length && countB == setArrayB.length)
				break;
			if (countA == setArrayA.length && countB < setArrayB.length) {
				unionList.add(setArrayB[countB++]);
				continue;
			}
			if (countB == setArrayB.length && countA < setArrayA.length) {
				unionList.add(setArrayA[countA++]);
				continue;
			}
			if (setArrayA[countA] < setArrayB[countB]) {
				unionList.add(setArrayA[countA++]);
				continue;
			}
			if (setArrayA[countA] > setArrayB[countB]) {
				unionList.add(setArrayB[countB++]);
				continue;
			}
			if (setArrayA[countA] == setArrayB[countB]) {
				unionList.add(setArrayA[countA]);
				countA++;
				countB++;
			}
		}
		int union[] = IntSet.listToArray(unionList);

		return new IntSet(union);
	}

	/* Sorts the array in increasing order.
	 * @param array
	 * @return array of integers in ascending order.
	 */
	private static int[] sort(int array[]) {
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] > array[j]) {
					array[i] = array[i] + array[j];
					array[j] = array[i] - array[j];
					array[i] = array[i] - array[j];
				}
			}
		}
		return array;
	}

	/* This method converts ArrayList to array of integers.
	 * @param l ArrayList.
	 * @return array of integers.
	 */
	private static int[] listToArray(List<Integer> l) {
		int array[] = new int[l.size()];
		for (int i = 0; i < l.size(); i++)
			array[i] = (int) l.get(i);
		return array;
	}

	/* This method removes duplicate entries from an array.
	 * @param array.
	 * @return distinct valued array of integers.
	 */
	private static int[] removeDuplicate(int array[]) {
		List<Integer> distinctList = new ArrayList<Integer>();
		for (int i = 0; i < array.length; i++) {
			int j = i + 1;
			while (j < array.length && array[j] == array[i])
				j++;
			distinctList.add(array[i]);
			i = j - 1;
		}
		return IntSet.listToArray(distinctList);
	}
}
