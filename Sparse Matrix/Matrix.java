
/* This is a component class.
 * This class consists of methods to store sparse matrix in an efficient way.
 * It consists of methods to perform different operations on matrix.
 * @author Bhupendra
 */
public final class Matrix implements Cloneable {
	private final int sparseMatrix[][];
	
	/* Constructor
	 * @param array matrix
	 */
	public Matrix(int array[][]) {
		this.sparseMatrix = Matrix.matrixToSparse(array);
	}

	/* Used to deep clone the object of class Matrix. Override method clone(0 of
	 * Cloneable interface.
	 * @see java.lang.Object#clone()
	 */
	public Object clone() throws CloneNotSupportedException {
		int mat[][] = Matrix.sparseToMatrix(this.sparseMatrix);
		Matrix cloned = new Matrix(mat);
		return cloned;
	}

	/* This method is used to fetch th value of sparse matrix.
	 * @return sparse matrix of calling object.
	 */
	public int[][] getSparseMatrix() {
		return this.sparseMatrix;
	}

	/* This method is used to find the transpose of calling matrix.
	 * @return transpose of matrix.
	 * @throws Exception
	 */
	public Matrix transpose() {
		int transpose[][] = new int[this.sparseMatrix.length][this.sparseMatrix[0].length];
		int row = 0;
		int col = 1;
		
		if(transpose.length == 0)
			throw new AssertionError("Matrix is Empty.");

		for (int i = 0; i < this.sparseMatrix[0].length; i++) {
			transpose[col][i] = this.sparseMatrix[row][i];
			transpose[row][i] = this.sparseMatrix[col][i];
			transpose[2][i] = this.sparseMatrix[2][i];
		}
		Matrix transposeMatrix = new Matrix(Matrix.sparseToMatrix(transpose));
		return transposeMatrix;
	}

	/* This method checks the symmetry of the given matrix.
	 * @param m matrix
	 * @return true if matrix is symmetric, false otherwise.
	 * @throws Exception
	 */
	public static boolean checkSymmetry(Matrix m)
	{
		int matrix[][] = m.sparseMatrix.clone();
		
		if(matrix.length == 0)
			throw new AssertionError("Matrix is Empty.");
		
		Matrix transposeObj = m.transpose();
		int transpose[][] = transposeObj.sparseMatrix;

		if (!(matrix[0].length == transpose[0].length))
			return false;
		for (int i = 0; i < matrix[0].length; i++) {
			if (matrix[0][i] != transpose[0][i]
					|| matrix[1][i] != transpose[1][i]
					|| matrix[2][i] != transpose[2][i])
				return false;
		}
		return true;
	}

	/* This method perform addition of two given matrices.
	 * @param m1 matrix
	 * @param m2 matrix
	 * @return sum of two matrices, null otherwise.
	 */
	public static Matrix add(Matrix m1, Matrix m2) {
		int matrix1[][] = m1.sparseMatrix;
		int matrix2[][] = m2.sparseMatrix;
		int count1 = 0, count2 = 0;
		
		if(matrix1.length == 0 | matrix2.length == 0 | matrix1[0].length == 0 | matrix2[0].length == 0)
			throw new AssertionError("One of the matrix is Empty! Addition will be same as the other.");

		// Variables to store dimensions of both matrices.
		int matrix1Row = (matrix1[0][matrix1[0].length - 1]) + 1;
		int matrix1Col = (matrix1[1][matrix1[0].length - 1]) + 1;
		int matrix2Row = (matrix2[0][matrix2[0].length - 1]) + 1;
		int matrix2Col = (matrix2[1][matrix2[0].length - 1]) + 1;

		if (matrix1Row != matrix2Row || matrix1Col != matrix2Col){
			System.out.println("Matrices dimensions differ. Hence, can't be added!");
			return null;
		}

		// Initializing the new matrix to store sum.
		int sum[][] = new int[matrix1Row][matrix2Col];
		int row = 0, col = 1;
		
		while (count1 < matrix1[0].length || count2 < matrix2[0].length) {
			if (count1 != matrix1[0].length && count2 != matrix2[0].length
					&& matrix1[row][count1] == matrix2[row][count2]
					&& matrix1[col][count1] == matrix2[col][count2]) {
				sum[matrix1[row][count1]][matrix1[col][count1]] = matrix1[2][count1]
						+ matrix2[2][count2];
				count1++;
				count2++;
				continue;
			}
			if (count1 == matrix1[0].length
					|| matrix1[row][count1] > matrix2[row][count2]) {
				sum[matrix2[row][count2]][matrix2[col][count2]] = matrix2[2][count2];
				count2++;
				continue;
			}
			if (count2 == matrix2[0].length
					|| matrix1[row][count1] < matrix2[row][count2]) {
				sum[matrix1[row][count1]][matrix1[col][count1]] = matrix1[2][count1];
				count1++;
				continue;
			}
			if (count1 != matrix1[0].length && count2 != matrix2[0].length
					&& matrix1[row][count1] == matrix2[row][count2]) {
				if (matrix1[col][count1] > matrix2[col][count2]) {
					sum[matrix2[row][count2]][matrix2[col][count2]] = matrix2[2][count2];
					count2++;
				} else {
					sum[matrix1[row][count1]][matrix1[col][count1]] = matrix1[2][count1];
					count1++;
				}
			}
		}
		return new Matrix(sum);
	}

	/* This method perform multiplication of two given matrices.
	 * @param m1 matrix.
	 * @param m2 matrix.
	 * @return product of two matrices, null otherwise.
	 */
	public static Matrix multiply(Matrix m1, Matrix m2)throws Exception {
		
		// Retreiving original matrices from stored sparse matrices.
		int matrix1[][] = Matrix.sparseToMatrix(m1.sparseMatrix);
		int matrix2[][] = Matrix.sparseToMatrix(m2.sparseMatrix);
		
		if(matrix1.length == 0 | matrix2.length == 0 || matrix1[0].length == 0 | matrix2[0].length == 0)
			throw new AssertionError("One of the matrix is Empty! Addition will be same as the other.");

		// Variables to store dimensions of both matrices.
		int matrix1Row = matrix1.length;
		int matrix1Col = matrix1[0].length;
		int matrix2Row = matrix2.length;
		int matrix2Col = matrix2[0].length;

		// Checks the operational compatibility.
		if (matrix1Col != matrix2Row){
			System.out.println("Matrices dimensions incompatible to multiplied!");
			return null;
		}

		// Initializing the new matrix to store product.
		int multiplied[][] = new int[matrix1Row][matrix2Col];

		// Performing multiplication.
		for (int i = 0; i < matrix1.length; i++) {
			for (int j = 0; j < matrix2[0].length; j++) {
				for (int k = 0; k < matrix1[0].length; k++) {
					multiplied[i][j] = multiplied[i][j] + matrix1[i][k]
							* matrix2[k][j];
				}
			}
		}
		Matrix.show(multiplied);
		return new Matrix(multiplied);
	}

	/* This method convert matrix to its sparse format.
	 * @param array actual matrix.
	 * @return sparse matrix.
	 */
	public static int[][] matrixToSparse(int array[][]) {
		int size = Matrix.countNonZero(array);
		int sparseMatrix[][] = new int[3][size];
		int sparseCount = 0;

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				if (array[i][j] != 0)
				{
					sparseMatrix[0][sparseCount] = i;
					sparseMatrix[1][sparseCount] = j;
					sparseMatrix[2][sparseCount] = array[i][j];
					sparseCount++;
				}
			}
		}
		return sparseMatrix;
	}

	/* This method convert sparse to actual matrix.
	 * @param sparse matrix.
	 * @return actual matrix.
	 */
	public static int[][] sparseToMatrix(int sparse[][]) {
		int array[][] = sparse.clone();
		int row = -1;
		int col = -1;

		for (int i = 0; i < array[0].length; i++) {
			if (array[0][i] > row)
				row = array[0][i];
			if (array[1][i] > col)
				col = array[1][i];
		}
		row++;
		col++;

		int matrix[][] = new int[row][col];
		for (int i = 0; i < array[0].length; i++) {
			int m = array[0][i];
			int n = array[1][i];
			matrix[m][n] = array[2][i];
		}
		return matrix;
	}
	
	/* Counts all non-zero elements in a given array matrix.
	 * @param array.
	 * @return count of non-zero elements.
	 */
	public static int countNonZero(int array[][]) {
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j] != 0)
					count++;
			}
		}
		return count;
	}

	/* This method prints the given array.
	 * @param array
	 */
	public static void show(int array[][]) {
		System.out.println();
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++)
				System.out.print(array[i][j] + "  ");
			System.out.println();
		}
	}
}
