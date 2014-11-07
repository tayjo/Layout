package layout;

public class Layout {
	
	public int[][] contents;
	
	public Layout(int[][] array){
		//Creates a Layout containing a copy of the given array.
		contents = new int[array.length][array[0].length];
		for (int i = 0; i < array.length; i++){
			for (int j = 0; j < array[i].length; j++){
				contents[i][j] = array[i][j];
			}
		}
	}
	
	public Layout(int[] array){
		//Creates a Layout containing the given array.
		contents = new int[1][array.length];
		for (int j = 0; j < array.length; j++) {
			contents[0][j] = array[j];
		}
	}
	
	public Layout(int length){
		//Creates an Layout of length integers, and fills it with the numbers 1 to length.
		
	}
	
	public Layout reverse(){
		//Returns a new Layout whose values are in the reverse order of those in the given Layout.
		return null;
	}
	
	public Layout rotateRight(){
		//Returns a new Layout which is "rotated" a quarter-turn clockwise.
		return null;
	}

	public Layout rotateLeft(){
		//Returns a new Layout which is "rotated" a quarter-turn counterclockwise.
		return null;
	}

	public Layout transpose(){
		//Transposes a Layout of m rows and n columns to form a Layout of n rows and m columns. The value in location [i][j] of the Layout become the value in location [j][i] of the new Layout.
		return null;
	}
	
	public Layout ravel(int n){
		//Takes a one-dimensional Layout of m × n numbers and returns a two-dimensional Layout of m rows and n columns. The first n numbers of the given Layout are copied into the first row of the new Layout, the second n numbers into the second row, and so on. This method throws an IllegalArgumentException if the length of the input Layout is not evenly divisible by n.
		return null;
	}

	public Layout unravel(){
		//Takes a m by n two dimensional Layout and returns a one-dimensional Layout of size m × n containing the same numbers. The first n numbers of the new Layout are copied from the first row of the given Layout, the second n numbers from the second row, and so on.
		return null;
	}

	public Layout reshape(int n){
		//Takes a two-dimensional array of r rows and c columns and reshapes it to have n columns by (r*c)/n rows. This method throws an IllegalArgumentException if r*c is not evenly divisible by n.
		return null;
	}

	public Layout join(Layout layout){
		//Adjoins a Layout with n rows and m1 columns to the parameter Layout with n rows and m2 columns, forming a new Layout with n rows and m1+m2 columns. This method throws an IllegalArgumentException if the input Layouts do not have the same number of rows.
		return null;
	}
	
	public Layout stack(Layout layout){
		//Forms a new Layout with n rows and m1+m2 columns by putting the recipient Layout with n1 rows and m columns on top of the parameter Layout of n2 rows and m columns. This method throws an IllegalArgumentException if the input Layouts do not have the same number of columns.
		return null;
	}
	
	public int rowCount(){
		//Returns the number of rows in the Layout. For a one-dimensional Layout, this returns 1.
		return 0;
	}
	
	public int columnCount(){
		//Returns the number of columns in the Layout. For a one-dimensional Layout, this is the number of values in the Layout.
		return 0;
	}
	
	public Layout rows(int firstRow, int lastRow){
		//Returns a new Layout containing values from row firstRow to row lastRow, inclusive, of the recipient Layout.
		return null;
	}

	public Layout columns(int firstColumn, int lastColumn){
		//Returns a new Layout containing values from column firstColumn to column lastColumn, inclusive, of the recipient Layout.
		return null;
	}

	public Layout slice(int firstRow, int lastRow, int firstColumn, int lastColumn){
		//Returns a new Layout containing values from the given portion of the recipient Layout.
		return null;
	}

	public Layout replace(Layout layout, int row, int column){
		//Returns a new Layout in which the parameter layout replaces the values of the recipient Layout, starting at the given row and column. This method throws an IllegalArgumentException if the parameter Layout would go beyond the bounds of the recipient layout.
		return null;
	}

	@Override
	public boolean equals(Object o){
		return false;
	}
	
	@Override
	public int hashCode(){
		//Arrays have a hashCode method. Your Layout object contains an array. This method should return the hashCode of that array. Don't ask why, just do it.
		return 0;
	}
	
	public int[] toArray1D(){
		//Returns a one-dimensional array of the values in the recipient Layout. If the Layout is two-dimensional, it is first unraveled.
		return null;
	}
	
	public int[][] toArray2D(){
		//Returns a copy of the two-dimensional array of the values in the recipient Layout. If the Layout is one-dimensional, the result will be an array containing, as its single element, a one-dimensional array. (Do not return the actual array; make a copy. If you were to return the actual array, and someone were to change some value in the array, that would change the value in the Layout. That violates our intention to make Layouts immutable.)
		return null;
	}
	
	public int at(int row, int column){
		//Returns the integer at the given row and column.
		return 0;
	}
}
