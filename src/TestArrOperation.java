import static org.junit.Assert.*;

import org.junit.Test;

public class TestArrOperation {

	@Test
	public void test() {
		ArrOperation ar = new ArrOperation();
		int actual = ar.maxMirror(new int[] { 1, 4, 5, 3, 5, 4, 1 });
		assertEquals(7, actual);
	}

	@Test
	public void test2() {
		ArrOperation ar = new ArrOperation();
		int actual = ar.maxMirror(new int[] { 7, 1, 4, 9, 7, 4, 1 });
		assertEquals(2, actual);
	}

	@Test
	public void test3() {
		ArrOperation ar = new ArrOperation();
		int actual = ar.maxMirror(new int[] { 1, 2, 3, 8, 9, 3, 2, 1 });
		assertEquals(3, actual);
	}

	@Test
	public void test4() {
		ArrOperation ar = new ArrOperation();
		int actual = ar.maxMirror(new int[] { 1, 4, 5, 3, 5, 4, 1 });
		assertEquals(7, actual);
	}

	@Test
	public void test5() {
		ArrOperation ar = new ArrOperation();
		int actual = ar
				.maxMirror(new int[] { 1, 2, 1, 2, 3, 3, 4, 3, 3, 2, 1 });
		assertEquals(9, actual);
	}

	// CLUMPS

	@Test
	public void test6() {
		ArrOperation ar = new ArrOperation();
		int actual = ar.countClumps(new int[] { 1, 2, 2, 3, 4, 4 });
		assertEquals(2, actual);
	}

	@Test
	public void test7() {
		ArrOperation ar = new ArrOperation();
		int actual = ar.countClumps(new int[] { 1, 1, 2, 1, 1 });
		assertEquals(2, actual);
	}

	@Test
	public void test8() {
		ArrOperation ar = new ArrOperation();
		int actual = ar.countClumps(new int[] { 1, 1, 1, 1, 1, 1});
		assertEquals(1, actual);

	}
	
	
	// FIXXX
	
	@Test
	public void test9() {
		ArrOperation ar = new ArrOperation();
		int expected[] = new int[]{2, 6, 3, 4, 5, 6, 4, 5 };
		int actual[] = ar.fixXY(4, 5, new int[] 
//		{ 1, 4, 1, 5, 5, 4, 1 } );
//		{1, 4, 1, 5} );    
//		{ 5, 4, 9, 4, 9, 5});
				{2,5,3,4,5,6,4,6});
//		System.out.println("\n\n\t FIXX\n");
//		for(int i=0; i< actual.length; i++)
//		{
//			System.out.print(actual[i]+ " ");
//		}
		assertArrayEquals("Test case-9 Fails!",expected, actual);

	}
	
	
	@Test
	public void test90() {
		ArrOperation ar = new ArrOperation();
		int actual = ar.splitArray(new int[] 
//				{ 1, 1, 1, 1, 1, 1});
//				{ 5, 4, 9, 4, 9, 5});
//				{2, 1, 1, 2, 1});
				{ 10, 10});
		System.out.println("Actual="+actual);
		assertEquals(1, actual);

	}

}
