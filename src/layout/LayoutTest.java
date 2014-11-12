package layout;

import static org.junit.Assert.*;

import java.util.Arrays;
import org.junit.Test;

public class LayoutTest {
	
	int[][] first_array = { {1, 2, 3},
							{4, 5, 6},
							{7, 8, 9},
							{10, 11, 12} };
	Layout first_layout = new Layout(first_array);
	int[][] empty = {};

	@Test
	public void testHashCode() {
		Layout first = new Layout(first_array);
		int[][] other = { {1, 2, 3, 4} };
		Layout other_layout = new Layout(other);
		assertFalse(first.hashCode() == other_layout.hashCode());
		assertTrue(first.hashCode() == first.hashCode());
	}

	@Test
	public void testLayoutIntArrayArray() {
		int[][] my_array = { {1, 2, 3},
							 {4, 5, 6},
							 {7, 8, 9} };
		Layout my_layout = new Layout(my_array);
		for (int n = 0; n < my_array.length; n++) {
			for (int p = 0; p < my_array[0].length; p++) {
				assertEquals(my_array[n][p], my_layout.at(n, p));
			}
		}
		my_array[0][0] = 2;
		assertNotEquals(my_array[0][0], my_layout.at(0, 0));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testLayoutIntArrayArrayException1() {
		int[][] zero_rows = new int[0][5];
		new Layout(zero_rows);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testLayoutIntArrayArrayException2() {
		int[][] zero_cols = new int[5][0];
		new Layout(zero_cols);
	}
	
	@Test
	public void testLayoutIntArray() {
		int[] my_1d_array = {1, 2, 3, 4, 5};
		Layout my_layout = new Layout(my_1d_array);
		for (int j = 0; j < my_1d_array.length; j++) {
			assertEquals(my_layout.at(0, j), my_1d_array[j]);
		}
		my_1d_array[0] = 2;
		assertNotEquals(my_1d_array[0], my_layout.at(0, 0));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testLayoutIntArrayException() {
		int[] empty_1d_array = {};
		new Layout(empty_1d_array);
	}

	@Test
	public void testLayoutInt() {
		int length = 12;
		Layout my_layout = new Layout(length);
		for (int j = 0; j < length; j++) {
			assertEquals(j + 1, my_layout.at(0, j));
		}
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testLayoutIntException() {
		new Layout(0);
	}

	@Test
	public void testReverse() {
		Layout original = new Layout(first_array);
		int[][] reversed = { {3, 2, 1},
							{6, 5, 4},
							{9, 8, 7},
							{12, 11, 10} };
		Layout reversed_layout = new Layout(reversed);
		assertEquals(reversed_layout, original.reverse());
	}

	@Test
	public void testRotateRight() {
		int[][] one_rotate = { {10, 7, 4, 1},
							   {11, 8, 5, 2},
							   {12, 9, 6, 3} };
		Layout layout_one = new Layout(one_rotate);
		Layout rotated_once = first_layout.rotateRight();
		assertEquals(layout_one, rotated_once);
		int[][] two_rotate = { {12, 11, 10},
							   {9, 8, 7},
							   {6, 5, 4},
							   {3, 2, 1} };
		Layout layout_two = new Layout(two_rotate);
		Layout rotated_twice = rotated_once.rotateRight();
		assertEquals(layout_two, rotated_twice);
		int[][] three_rotate = { {3, 6, 9, 12},
								 {2, 5, 8, 11},
							     {1, 4, 7, 10} };
		Layout layout_three = new Layout(three_rotate);
		Layout rotated_thrice = rotated_twice.rotateRight();
		assertEquals(layout_three, rotated_thrice);
		Layout rotated_fourth = rotated_thrice.rotateRight();
		assertEquals(rotated_fourth, first_layout);
	}

	@Test
	public void testRotateLeft() {
		int[][] original_array = { {1, 2, 3, 4},
									{5, 6, 7, 8},
									{9, 10, 11, 12} };
		Layout original_layout = new Layout(original_array);
		int[][] one_rotate = { {4, 8, 12},
							   {3, 7, 11},
							   {2, 6, 10},
							   {1, 5, 9} };
		Layout layout_one = new Layout(one_rotate);
		Layout rotated_once = original_layout.rotateLeft();
		assertEquals(layout_one, rotated_once);
		int[][] two_rotate = { {12, 11, 10, 9},
							   {8, 7, 6, 5},
							   {4, 3, 2, 1} };
		Layout layout_two = new Layout(two_rotate);
		Layout rotated_twice = rotated_once.rotateLeft();
		assertEquals(layout_two, rotated_twice);
		int[][] three_rotate = { {9, 5, 1},
								 {10, 6, 2},
							     {11, 7, 3},
							     {12, 8, 4} };
		Layout layout_three = new Layout(three_rotate);
		Layout rotated_thrice = rotated_twice.rotateLeft();
		assertEquals(layout_three, rotated_thrice);
		Layout rotated_fourth = rotated_thrice.rotateLeft();
		assertEquals(rotated_fourth, original_layout);	
	}

	@Test
	public void testTranspose() {
		int[][] transpose = { {1, 4, 7, 10},
						 		 {2, 5, 8, 11},
						 		 {3, 6, 9, 12} };
		Layout transpose_layout = new Layout(transpose);
		assertEquals(first_layout.transpose(), transpose_layout);
		int[][] second_array = { {1, 2, 3, 4, 5} };
		Layout second_layout = new Layout(second_array);
		int[][] transpose2 = { {1},
							   {2},
							   {3},
							   {4},
							   {5} };
		Layout transpose2_layout = new Layout(transpose2);
		assertEquals(transpose2_layout, second_layout.transpose());
	}

	@Test
	public void testRavel() {
		int[][] one_dim = { {1, 2, 3, 4, 5, 6, 7, 8} };
		Layout unravelled = new Layout(one_dim);
		int[][] two_dim = { {1, 2, 3, 4},
							{5, 6, 7, 8} };
		Layout answer = new Layout(two_dim);
		assertEquals(answer, unravelled.ravel(4));
		
		int[][] total_ravel = { {1}, {2}, {3}, {4}, {5}, {6}, {7}, {8} };
		answer = new Layout(total_ravel);
		assertEquals(answer, unravelled.ravel(1));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testDoesntDivideByArgument() {
		int[][] one_dim = {{1, 2, 3, 4, 5, 6, 7, 8}};
		Layout unravelled = new Layout(one_dim);
		unravelled.ravel(5);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testArgumentZero() {
		int[][] one_dim = {{1, 2, 3, 4, 5, 6, 7, 8}};
		Layout unravelled = new Layout(one_dim);
		unravelled.ravel(0);
	}

	@Test
	public void testUnravel() {
		int[] unraveled = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		Layout unraveled_layout = new Layout(unraveled);
		assertEquals(first_layout.unravel(), unraveled_layout);
	}

	@Test
	public void testReshape() {
		int[][] answer_array = { {1, 2, 3, 4, 5, 6}, {7, 8, 9, 10, 11, 12} };
		Layout answer = new Layout(answer_array);
		Layout first = new Layout(first_array);
		assertEquals(answer, first.reshape(6));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testReshapeZero() {
		int[][] one_dim = {{1, 2, 3, 4, 5, 6, 7, 8}};
		Layout unravelled = new Layout(one_dim);
		unravelled.reshape(0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testReshapeArgumentDoesntDivide() {
		int[][] input = {{1, 2, 3, 4}, {5, 6, 7, 8} };
		Layout unravelled = new Layout(input);
		unravelled.reshape(5);
	}

	@Test
	public void testJoin() {
		int[][] second_array = { {13},
								 {14},
								 {15},
								 {16} };
		Layout second_layout = new Layout(second_array);
		int[][] joined = { {1, 2, 3, 13},
						   {4, 5, 6, 14},
						   {7, 8, 9, 15},
						   {10, 11, 12, 16} };
		Layout joined_layout = new Layout(joined);
		assertEquals(joined_layout, first_layout.join(second_layout));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testJoinException() {
		int[][] second_array = { {1, 2, 3},
								 {4, 5, 6},
								 {7, 8, 9} };
		Layout second_layout = new Layout(second_array);
		first_layout.join(second_layout);
	}

	@Test
	public void testStack() {
		int[][] first_group = { {1, 2, 3, 4}, {5, 6, 7, 8} };
		Layout first = new Layout(first_group);
		int[][] second_group = { {10, 20, 30, 40} };
		Layout second = new Layout(second_group);
		int[][] answer_group = { {1, 2, 3, 4}, 
								{5, 6, 7, 8}, 
								{10, 20, 30, 40} };
		Layout answer = new Layout(answer_group);
		assertEquals(answer, first.stack(second));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testIllegalStack() {
		int[][] first_group = {{1, 2, 3, 4, 5, 6, 7, 8}};
		Layout first = new Layout(first_group);
		int[][] second_group = { {1, 2, 3, 4}, {5, 6, 7, 8} };
		Layout second = new Layout(second_group);
		first.stack(second);
	}

	@Test
	public void testRowCount() {
		assertEquals(4, first_layout.rowCount());
		int[][] second_array = { {1, 2, 3},
								 {4, 5, 6} };
		Layout second_layout = new Layout(second_array);
		assertEquals(2, second_layout.rowCount());
	}

	@Test
	public void testColumnCount() {
		Layout first = new Layout(first_array);
		assertEquals(3, first.columnCount());
	}

	@Test
	public void testRows() {
		int[][] rows = { {4, 5, 6},
						 {7, 8, 9} };
		Layout rows_layout = new Layout(rows);
		assertEquals(rows_layout, first_layout.rows(1, 2));
	}

	@Test(expected=IllegalArgumentException.class)
	public void testRowsException1() {
		first_layout.rows(-1, 2);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testRowsException2() {
		first_layout.rows(2, 5);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testRowsException3() {
		first_layout.rows(2, 1);
	}
	
	@Test
	public void testColumns() {
		Layout first = new Layout(first_array);
		int[][] answer_array = { {2, 3}, {5, 6}, {8, 9}, {11, 12} };
		Layout answer = new Layout(answer_array);
		assertEquals(answer, first.columns(1,  2));
		
		int[][] answer_array2 = { {1}, {4}, {7}, {10} };
		answer = new Layout(answer_array2);
		assertEquals(answer, first.columns(0,  0));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testIllegalColumnsArgs() {
		Layout first = new Layout(first_array);
		first.columns(2,  1);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testSliceException1() {
		first_layout.slice(-1, 2, 1, 2);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testSliceException2() {
		first_layout.slice(3, 2, 1, 2);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testSliceException3() {
		first_layout.slice(0, 2, 1, 5);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testSliceException4() {
		first_layout.slice(0, 2, 2, 0);
	}

	@Test
	public void testReplace() {
		int[][] original_array = { {1, 2, 3, 4, 5},
									{6, 7, 8, 9, 10},
									{11, 12, 13, 14, 15},
									{16, 17, 18, 19, 20} };
		Layout original = new Layout(original_array);
		int[][] input_array = { {55, 66, 77}, {88, 99, 100} };
		Layout input = new Layout(input_array);
		int[][] answer_array = { {1, 2, 3, 4, 5},
							{6, 7, 55, 66, 77},
							{11, 12, 88, 99, 100},
							{16, 17, 18, 19, 20} };
		Layout answer = new Layout(answer_array);
		assertEquals(answer, original.replace(input, 1, 2));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testIllegalReplaceReversedArgs() {
		int[][] original_array = { {1, 2, 3, 4, 5},
									{6, 7, 8, 9, 10},
									{11, 12, 13, 14, 15},
									{16, 17, 18, 19, 20} };
		Layout original = new Layout(original_array);
		int[][] input_array = { {55, 66, 77}, {88, 99, 100} };
		Layout input = new Layout(input_array);
		int[][] answer_array = { {1, 2, 3, 4, 5},
								{6, 7, 55, 66, 77},
								{11, 12, 88, 99, 100},
								{16, 17, 18, 19, 20} };
		Layout answer = new Layout(answer_array);
		assertEquals(answer, original.replace(input, 1, 0));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testIllegalReplaceOverArrayLength() {
		int[][] original_array = { {1, 2, 3, 4, 5},
									{6, 7, 8, 9, 10},
									{11, 12, 13, 14, 15},
									{16, 17, 18, 19, 20} };
		Layout original = new Layout(original_array);
		int[][] input_array = { {55, 66, 77}, {88, 99, 100} };
		Layout input = new Layout(input_array);
		int[][] answer_array = { {1, 2, 3, 4, 5},
								{6, 7, 55, 66, 77},
								{11, 12, 88, 99, 100},
								{16, 17, 18, 19, 20} };
		Layout answer = new Layout(answer_array);
		assertEquals(answer, original.replace(input, 1, 3));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testIllegalReplaceOverArrayLengthBoth() {
		int[][] original_array = { {1, 2, 3, 4, 5},
									{6, 7, 8, 9, 10},
									{11, 12, 13, 14, 15},
									{16, 17, 18, 19, 20} };
		Layout original = new Layout(original_array);
		int[][] input_array = { {55, 66, 77}, {88, 99, 100} };
		Layout input = new Layout(input_array);
		int[][] answer_array = { {1, 2, 3, 4, 5},
								{6, 7, 55, 66, 77},
								{11, 12, 88, 99, 100},
								{16, 17, 18, 19, 20} };
		Layout answer = new Layout(answer_array);
		assertEquals(answer, original.replace(input, 2, 3));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testIllegalReplaceBiggerThanLayout() {
		int[][] original_array = { {1, 2, 3, 4, 5},
									{6, 7, 8, 9, 10},
									{11, 12, 13, 14, 15},
									{16, 17, 18, 19, 20} };
		Layout original = new Layout(original_array);
		int[][] input_array = { {55, 66, 77, 78, 79, 80}, 
								{88, 99, 100, 101, 102, 103} };
		Layout input = new Layout(input_array);
		int[][] answer_array = { {1, 2, 3, 4, 5},
								{6, 7, 55, 66, 77},
								{11, 12, 88, 99, 100},
								{16, 17, 18, 19, 20} };
		Layout answer = new Layout(answer_array);
		assertEquals(answer, original.replace(input, 1, 2));
	}
	
	@Test
	public void testEqualsObject() {
		int[][] second_array = { {1, 2, 3},
								 {4, 5, 6},
								 {7, 8, 9},
								 {10, 11, 12} };
		Layout second_layout = new Layout(second_array);
		assertTrue(first_layout.equals(second_layout));
		int[][] third_array = { {1, 2, 3, 4},
								{5, 6, 7, 8},
								{9, 10, 11, 12} };
		Layout third_layout = new Layout(third_array);
		assertFalse(first_layout.equals(third_layout));
	}

	@Test
	public void testToArray1D() {
		int[] first_array_1d = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		for (int i = 0; i < first_layout.rowCount(); i++) {
			for (int j = 0; j < first_layout.columnCount(); j++) {
				assertEquals(first_array_1d[i * first_layout.columnCount() + j], first_layout.at(i, j));
			}
		}
		int[] second_array = {5, 4, 3, 2, 1};
		Layout second_layout = new Layout(second_array);
		for (int i = 0; i < second_layout.rowCount(); i++) {
			for (int j = 0; j < second_layout.columnCount(); j++) {
				assertEquals(second_array[i * second_layout.columnCount() + j], second_layout.at(i, j));
			}
		}
	}

	@Test
	public void testToArray2D() {
		Layout first = new Layout(first_array);
		int[][] answer = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12} };
		assertTrue(Arrays.deepEquals(answer, first.toArray2D()));
	}

	@Test
	public void testAt() {
		assertEquals(4, first_layout.at(1,0));
		assertEquals(9, first_layout.at(2,2));
		assertEquals(11, first_layout.at(3, 1));
	}

	@Test(expected=IllegalArgumentException.class)
	public void testAtException1() {
		first_layout.at(-1, 0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAtException2() {
		first_layout.at(2, 5);
	}
}
