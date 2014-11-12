package layout;

public class Layout {
private int[][] contents;
	
	public Layout(int[][] array){
		//Creates a Layout containing a copy of the given array.
		if (array.length == 0 || array[0].length == 0) {
			throw new IllegalArgumentException();
		}
		contents = new int[array.length][array[0].length];
		for (int i = 0; i < array.length; i++){
			for (int j = 0; j < array[i].length; j++){
				contents[i][j] = array[i][j];
			}
		}
	}
	
	public Layout(int[] array){
		//Creates a Layout containing the given array.
		if (array.length == 0) throw new IllegalArgumentException();
		contents = new int[1][array.length];
		for (int j = 0; j < array.length; j++) {
			contents[0][j] = array[j];
		}
	}
	
	public Layout(int length){
		//1 Creates an Layout of length integers, and fills it with the numbers 1 to length.
		contents = new int[1][length];
		for (int j = 0; j < length; ) {
			contents[0][j] = ++j;
		}
	}
	
	public Layout reverse(){
		//2 Returns a new Layout whose values are in the reverse order of those in the given Layout.
		int[][] reversed = new int[this.rowCount()][this.columnCount()];
		for (int i = 0; i < this.rowCount(); i++) {
			for (int j = 0; j < this.columnCount(); j++) {
				reversed[i][j] = contents[i][this.columnCount() - j - 1];
			}
		}
		Layout reversed_layout = new Layout(reversed);
		return reversed_layout;
	}
	
	public Layout rotateRight(){
		//3 Returns a new Layout which is "rotated" a quarter-turn clockwise.
		int[][] rotated = new int[columnCount()][rowCount()];
		Layout rotated_layout;
		for (int i = 0; i < rotated.length; i++) {
			for (int j = 0; j < rotated[0].length; j++) {
				rotated[i][j] = at(rotated[0].length - 1 - j, i);
			}
		}
		rotated_layout = new Layout(rotated);
		return rotated_layout;
	}

	public Layout rotateLeft(){
		//4 Returns a new Layout which is "rotated" a quarter-turn counterclockwise.
		if (contents.length == 0) return this;
		int[][] rotated = new int[columnCount()][rowCount()];
		for (int i = 0; i < rotated.length; i++) {
			for (int j = 0; j < rotated[0].length; j++) {
				rotated[i][j] = this.at(j, this.columnCount() - 1 - i);
			}
		}
		Layout rotated_layout = new Layout(rotated);
		return rotated_layout;
	}

	public Layout transpose(){
		//5 Transposes a Layout of m rows and n columns to form a Layout of n rows and m columns. The value in location [i][j] of the Layout become the value in location [j][i] of the new Layout.
		int[][] transpose = new int[columnCount()][rowCount()];
		Layout transpose_layout;
		for (int i = 0; i < transpose.length; i++) {
			for (int j = 0; j < transpose[0].length; j++) {
				transpose[i][j] = contents[j][i];
			}
		}
		transpose_layout = new Layout(transpose);
		return transpose_layout;
	}
	
	public Layout ravel(int n){
		//6 Takes a one-dimensional Layout of m × n numbers and returns a two-dimensional Layout of m rows and n columns. The first n numbers of the given Layout are copied into the first row of the new Layout, the second n numbers into the second row, and so on. This method throws an IllegalArgumentException if the length of the input Layout is not evenly divisible by n.
		if (n == 0) throw new IllegalArgumentException();
		int new_row_count = columnCount() / n;
		if (columnCount() % n != 0) throw new IllegalArgumentException();
		int[][] ravelled_array = new int[new_row_count][n];
		int current = 0;
		for (int i = 0; i < new_row_count; i++) {
			for (int j = 0; j < n; j++) {
				ravelled_array[i][j] = at(0, current);
				current++;
			}
		}
		Layout return_layout = new Layout(ravelled_array);
		return return_layout;
	}

	public Layout unravel(){
		//7 Takes a m by n two dimensional Layout and returns a one-dimensional Layout of size m × n containing the same numbers. The first n numbers of the new Layout are copied from the first row of the given Layout, the second n numbers from the second row, and so on.
		return null;
	}

	public Layout reshape(int n){
		//8 Takes a two-dimensional array of r rows and c columns and reshapes it to have n columns by (r*c)/n rows. This method throws an IllegalArgumentException if r*c is not evenly divisible by n.
		int r_times_c = rowCount() * columnCount();
		if (n == 0 || r_times_c % n != 0) throw new IllegalArgumentException();
		Layout unravelled = this.unravel();
		Layout reshaped = unravelled.ravel(n);
		return reshaped;
	}

	public Layout join(Layout layout){
		//9 Adjoins a Layout with n rows and m1 columns to the parameter Layout with n rows and m2 columns, forming a new Layout with n rows and m1+m2 columns. This method throws an IllegalArgumentException if the input Layouts do not have the same number of rows.
		return null;
	}
	
	public Layout stack(Layout layout){
		//10 Forms a new Layout with n rows and m1+m2 columns by putting the recipient Layout with n1 rows and m columns on top of the parameter Layout of n2 rows and m columns. This method throws an IllegalArgumentException if the input Layouts do not have the same number of columns.
		if (layout.columnCount() != this.columnCount()) {
			throw new IllegalArgumentException();
		}
		int[][] result = new int[layout.rowCount() + this.rowCount()][columnCount()];
		for (int i = 0; i < rowCount(); i++) {
			for (int j = 0; j < columnCount(); j++) {
				result[i][j] = this.contents[i][j];
			}
		}
		for (int k = 0; k < layout.rowCount(); k++) {
			for (int m = 0; m < layout.columnCount(); m++) {
				result[rowCount() + k][m] = layout.contents[k][m];
			}
		}
		Layout stacked = new Layout(result);
		return stacked;
	}
	
	public int rowCount(){
		//11 Returns the number of rows in the Layout. For a one-dimensional Layout, this returns 1.
		return contents.length;
	}
	
	public int columnCount(){
		//12 Returns the number of columns in the Layout. For a one-dimensional Layout, this is the number of values in the Layout.
		return contents[0].length;
	}
	
	public Layout rows(int firstRow, int lastRow){
		//13 Returns a new Layout containing values from row firstRow to row lastRow, inclusive, of the recipient Layout.
		return null;
	}

	public Layout columns(int firstColumn, int lastColumn){
		//14 Returns a new Layout containing values from column firstColumn to column lastColumn, inclusive, of the recipient Layout.
		if (lastColumn < firstColumn) throw new IllegalArgumentException();
		int new_columns = lastColumn - firstColumn + 1;
		int[][] answer_array = new int[rowCount()][new_columns];
		for (int i = 0; i < rowCount(); i++) {
			for (int j = 0; j < new_columns; j++) {
				answer_array[i][j] = at(i, firstColumn + j);
			}
		}
		Layout answer = new Layout(answer_array);
		return answer;
	}

	public Layout slice(int firstRow, int lastRow, int firstColumn, int lastColumn){
		//15 Returns a new Layout containing values from the given portion of the recipient Layout.
		return null;
	}

	public Layout replace(Layout layout, int row, int column){
		//16 Returns a new Layout in which the parameter layout replaces the values of the recipient Layout, starting at the given row and column. This method throws an IllegalArgumentException if the parameter Layout would go beyond the bounds of the recipient layout.
		if (row > column) throw new IllegalArgumentException();
		int final_row = layout.rowCount() + row;
		int final_column = layout.columnCount() + column;
		if (final_row > this.rowCount() || final_column > this.columnCount()) {
			throw new IllegalArgumentException();
		}
		int[][] answer_array = new int[rowCount()][columnCount()];
		for (int i = 0; i < rowCount(); i++) {
			for (int j = 0; j < columnCount(); j++) {
				if (row <= i && i < final_row) {
					if (column <= j && j < final_column) {
						answer_array[i][j] = layout.at(i - row, j - column);
						continue;
					}
				}
				answer_array[i][j] = this.at(i, j);
			}
		}
		Layout answer = new Layout(answer_array);
		return answer;
	}

	@Override
	public boolean equals(Object o){
		//17 Returns true if and only if this Layout contains an array of the same shape and containing the same values as Object o.
		if (!(o instanceof Layout)) {
			return false;
		}
		Layout that = (Layout) o;
		if (rowCount() != that.rowCount() || (columnCount() != that.columnCount())) {
			return false;
		}
		for (int i = 0; i < rowCount(); i++) {
			for (int j = 0; j < columnCount(); j++) {
				if (at(i, j) != that.at(i, j)) {
					return false;
				}
			}
		}		
		return true;
	}
	
	@Override
	public int hashCode(){
		//18 Arrays have a hashCode method. Your Layout object contains an array. This method should return the hashCode of that array. Don't ask why, just do it.
		return this.contents.hashCode();
	}
	
	public int[] toArray1D(){
		//19 Returns a one-dimensional array of the values in the recipient Layout. If the Layout is two-dimensional, it is first unraveled.
		return null;
	}
	
	public int[][] toArray2D(){
		//20 Returns a copy of the two-dimensional array of the values in the recipient Layout. If the Layout is one-dimensional, the result will be an array containing, as its single element, a one-dimensional array. (Do not return the actual array; make a copy. If you were to return the actual array, and someone were to change some value in the array, that would change the value in the Layout. That violates our intention to make Layouts immutable.)
		int[][] result = new int[rowCount()][columnCount()];
		for (int i = 0; i < rowCount(); i++) {
			for (int j = 0; j < columnCount(); j++) {
				result[i][j] = this.at(i, j);
			}
		}
		return result;
	}
	
	public int at(int row, int column){
		//21 Returns the integer at the given row and column.
		return contents[row][column];
	}
}
