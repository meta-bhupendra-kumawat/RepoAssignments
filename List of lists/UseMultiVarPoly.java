
public class UseMultiVarPoly {
	public static void main(String args[]) {
		int arr[] = new int[] { 4, 9, 2, 2, 3, 2, 2, 2, 2, 88, 1, 0, 1, 0, 0, 0};
		MultiVarPoly p1 = new MultiVarPoly(arr, 3);
		System.out.println(p1.degree());
//		p1.show();
	}
}
