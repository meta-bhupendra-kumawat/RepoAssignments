import static org.junit.Assert.*;

import org.junit.Test;

/* This is a JUnit test class.
 * @author Bhupendra
 */
public class TestMatrix {

	// This is a method which consists of a set of input and expected output value set.
	@Test
	public void test() {
		Matrix mI1 = new Matrix(new int[][] { { 0, 0, 0, 1 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 1, 0, 0, 0 } });
	    int calculated[][] = Matrix.sparseToMatrix( mI1.transpose().getSparseMatrix() );
	    int actual[][] = new int[][] { { 0, 0, 0, 1}, { 0, 0, 0, 0}, { 0, 0, 0, 0 }, { 1, 0, 0, 0 } };
		
	    assertArrayEquals(calculated, actual);
	}

	// This is a method which consists of a set of input and expected output value set.
	@Test
	public void test2() {
		Matrix mI1 = new Matrix(new int[][] { { 2, 3, 4 }, { 1, -5, 9 } });
	    int calculated[][] = Matrix.sparseToMatrix( mI1.transpose().getSparseMatrix() );
	    int actual[][] = new int[][] { { 2, 1 }, { 3, -5 }, { 4, 9 } };
		
	    assertArrayEquals(calculated, actual);
	}
	
	// This is a method which consists of a set of input and expected output value set.
	@Test
	public void test3() {
		Matrix mI1 = new Matrix(new int[][] { { 0, 0, 0, 1 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 1, 0, 0, 0 } });
	    boolean calculated = Matrix.checkSymmetry(mI1);
	    boolean actual = true;
		
	    assertEquals(calculated, actual);
	}
	
	// This is a method which consists of a set of input and expected output value set.
	@Test
	public void test4() {
		Matrix mI1 = new Matrix(new int[][] { { 1, 0, 0, 1 }, { 0, 2, 0, 0 }, { 0, 0, 3, 0 }, { 1, 0, 0, 4 } });
	    boolean calculated = Matrix.checkSymmetry(mI1);
	    boolean actual = true;
		
	    assertEquals(calculated, actual);
	}
	
	// This is a method which consists of a set of input and expected output value set.
	@Test
	public void test5() {
		Matrix mI1 = new Matrix(new int[][] { { 1, 2, 3, 4 }, { 1, 2, 3, 4 }, { 1, 2, 3, 4 }, { 1, 2, 3, 4 } });
	    boolean calculated = Matrix.checkSymmetry(mI1);
	    boolean actual = false;
		
	    assertEquals(calculated, actual);
	}
	
	// This is a method which consists of a set of input and expected output value set.
	@Test(expected = AssertionError.class)
	public void test6() {
		Matrix mI1 = new Matrix(new int[][] {});
	    boolean calculated = Matrix.checkSymmetry(mI1);
		boolean actual = false;
			
		assertEquals(calculated, actual);
	}
	
	// This is a method which consists of a set of input and expected output value set.
	@Test
	public void testAdd1() {
		Matrix mI1 = new Matrix(new int[][] { {1, 1, 1, 1},  
                							  {2, 2, 2, 2},  
                							  {3, 3, 3, 3},  
                							  {4, 4, 4, 4}});
		
		Matrix mI2 = new Matrix(new int[][] { {1, 1, 1, 1},  
											  {2, 2, 2, 2},  
										   	  {3, 3, 3, 3},  
											  {4, 4, 4, 4}});
		
		Matrix mI3 = new Matrix(new int[][] { {2, 2, 2, 2},  
				  							  {4, 4, 4, 4},  
				  							  {6, 6, 6, 6},  
				  							  {8, 8, 8, 8}});
		
	    Matrix sum = Matrix.add(mI1, mI2);
	    int calculated[][] = Matrix.sparseToMatrix(sum.getSparseMatrix());
	    int actual[][] = Matrix.sparseToMatrix(mI3.getSparseMatrix());
	    assertArrayEquals(calculated, actual);
	}
	
	// This is a method which consists of a set of input and expected output value set.
	@Test
	public void testAdd2() {
		Matrix mI1 = new Matrix(new int[][] { {1, 3, 4},  
                							  {2, 4, 3},  
                							  {3, 4, 5} });
		
		Matrix mI2 = new Matrix(new int[][] { {1, 3, 4},  
											  {2, 4, 3},  
											  {1, 2, 4} });
		             
		Matrix mI3 = new Matrix(new int[][] { {2, 6, 8},  
				  							  {4, 8, 6},  
				  							  {4, 6, 9} });
		
	    Matrix sum = Matrix.add(mI1, mI2);
	    int calculated[][] = Matrix.sparseToMatrix(sum.getSparseMatrix());
	    int actual[][] = Matrix.sparseToMatrix(mI3.getSparseMatrix());
	    assertArrayEquals(calculated, actual);
	}
	
	// This is a method which consists of a set of input and expected output value set.
	@Test(expected = AssertionError.class)
	public void testAdd3() {
		Matrix mI1 = new Matrix(new int[][] {});
		
		Matrix mI2 = new Matrix(new int[][] { {1, 3, 4},  
											  {2, 4, 3},  
											  {1, 2, 4} });
		
		Matrix mI3 = new Matrix(new int[][] { {2, 6, 8},  
				  							  {4, 8, 6},  
				  							  {4, 6, 9} });
		
	    Matrix sum = Matrix.add(mI1, mI2);
	    int calculated[][] = Matrix.sparseToMatrix(sum.getSparseMatrix());
	    int actual[][] = Matrix.sparseToMatrix(mI3.getSparseMatrix());
	    assertArrayEquals(calculated, actual);
	}
	
	// This is a method which consists of a set of input and expected output value set.
	@Test
	public void testMultiply1() throws Exception{
		Matrix mI1 = new Matrix(new int[][] { {1, 1, 1},
											  {0, 0, 0},
											  {0, 0, 0} });
		
		Matrix mI2 = new Matrix(new int[][] { {1, 3, 4},  
											  {2, 4, 3},  
											  {1, 2, 4} });
		
		Matrix mI3 = new Matrix(new int[][] { {4, 9, 11},  
				  							  {0, 0, 0},  
				  							  {0, 0, 0} });
		
	    Matrix multiply = Matrix.multiply(mI1, mI2);
	    int calculated[][] = Matrix.sparseToMatrix(multiply.getSparseMatrix());
	    int actual[][] = Matrix.sparseToMatrix(mI3.getSparseMatrix());
	    assertArrayEquals(calculated, actual);
	}
	
	// This is a method which consists of a set of input and expected output value set.
	@Test
	public void testMultiply2()throws Exception {
		Matrix mI1 = new Matrix(new int[][] { {1, 1, 1},
											  {1, 1, 1},
											  {1, 1, 1} });
		
		Matrix mI2 = new Matrix(new int[][] { {1, 1, 1},  
											  {1, 1, 1},  
											  {1, 1, 1} });
		
		Matrix mI3 = new Matrix(new int[][] { {3, 3, 3},  
				  							  {3, 3, 3},  
				  							  {3, 3, 3} });
		
	    Matrix multiply = Matrix.multiply(mI1, mI2);
	    int calculated[][] = Matrix.sparseToMatrix(multiply.getSparseMatrix());
	    int actual[][] = Matrix.sparseToMatrix(mI3.getSparseMatrix());
	    assertArrayEquals(calculated, actual);
	}
	
	// This is a method which consists of a set of input and expected output value set.
		@Test(expected = AssertionError.class)
		public void testMultiply3()throws Exception {
			Matrix mI1 = new Matrix(new int[][] {});
			
			Matrix mI2 = new Matrix(new int[][] { {1, 3, 4},  
												  {2, 4, 3},  
												  {1, 2, 4} });
			
			Matrix mI3 = new Matrix(new int[][] { {0, 0, 0},  
					  							  {0, 0, 0},  
					  							  {0, 0, 0} });
			
		    Matrix sum = Matrix.multiply(mI1, mI2);
		    int calculated[][] = Matrix.sparseToMatrix(sum.getSparseMatrix());
		    int actual[][] = Matrix.sparseToMatrix(mI3.getSparseMatrix());
		    assertArrayEquals(calculated, actual);
		}
}


