

public class Matrix {

	public int[][] matrix;
	int numberOfRows;
	int numberOfColumns;

	//Constructor
	Matrix(int numberOfRows, int numberOfColumns) {
		this.numberOfRows = numberOfRows;
		this.numberOfColumns = numberOfColumns;
		this.matrix = new int[this.numberOfRows][this.numberOfColumns];
	}

	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
		this.numberOfRows = matrix.length;
		this.numberOfColumns = matrix[0].length;
	}

	public int getNumberOfRows() {
		return numberOfRows;
	}

	public int getNumberOfColumns() {
		return numberOfColumns;
	}

	public boolean addElements(int row, int column, int value) {
		this.matrix[row][column] = value;
		if (matrix[row][column] == value) {
			return true;
		}
		return false;
	}

	public int getElement(int row, int column) {
		return this.matrix[row][column];
	}
}







