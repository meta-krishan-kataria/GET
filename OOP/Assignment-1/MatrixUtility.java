class MatrixUtility {
	//Utility function for matrix
	
	public static Matrix transposeOfMatrix(Matrix matrix) {
		Matrix transposedMatrix = new Matrix(matrix.getNumberOfColumns(), matrix.getNumberOfRows());
		int[][] transposeOfMatrix = new int[matrix.getNumberOfColumns()][matrix.getNumberOfRows()];
		for (int i = 0; i < matrix.getNumberOfRows(); i++) {
			for (int j = 0; j < matrix.getNumberOfColumns(); j++) {
				transposeOfMatrix[i][j] = matrix.getElement(j, i);
			}
		}
		transposedMatrix.setMatrix(transposeOfMatrix);
		return transposedMatrix;
	}

	public static int[][] multiplicationOfMatrix  (Matrix matrix1, Matrix matrix2){
		int output[][] = new int[matrix1.getNumberOfRows()][matrix2.getNumberOfColumns()];
		if(matrix1.getNumberOfColumns() == matrix2.getNumberOfRows()){

			for(int i = 0; i < matrix1.getNumberOfRows(); i++){
				for(int j = 0; j < matrix1.getNumberOfColumns(); j++){
					for(int k = 0; k < matrix2.getNumberOfColumns(); k++){
						output[i][j] += matrix1.getElement(i, k) * matrix2.getElement(k, j);
					}
				}
			}
		} else {
			System.out.println("Invalid Input");
			return null;
		}
		return output;
	}

	public static void showMatrix(Matrix matrix){
		for(int i = 0; i < matrix.getNumberOfRows(); i++){
			for(int j = 0; j < matrix.getNumberOfColumns(); j++){
				System.out.print(matrix.getElement(i, j) + " ");
			}
			System.out.println("");
		}
	}
}