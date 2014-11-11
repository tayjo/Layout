package layout;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LayoutTest {
	
	int[][] first_array = { {1, 2, 3},
							{4, 5, 6},
							{7, 8, 9},
							{10, 11, 12} };
	Layout first_layout = new Layout(first_array);

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testHashCode() {
		fail("Not yet implemented");
	}

	@Test
	public void testLayoutIntArrayArray() {
		int[][] my_array = { {1, 2, 3},
							 {4, 5, 6},
							 {7, 8, 9} };
		Layout my_layout = new Layout(my_array);
		for (int n = 0; n < my_array.length; n++) {
			for (int p = 0; p < my_array[0].length; p++) {
				assertEquals(my_array[n][p], my_layout.contents[n][p]);
			}
		}
		my_array[0][0] = 2;
		assertNotEquals(my_array[0][0], my_layout.contents[0][0]);
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
			assertEquals(my_layout.contents[0][j], my_1d_array[j]);
		}
		my_1d_array[0] = 2;
		assertNotEquals(my_1d_array[0], my_layout.contents[0][0]);
		// What if my_1d_array.length = 0?
	}

	@Test
	public void testLayoutInt() {
		int length = 12;
		Layout my_layout = new Layout(length);
		for (int j = 0; j < length; j++) {
			assertEquals(j + 1, my_layout.contents[0][j]);
		}
		// What if length = 0?
	}

	@Test
	public void testReverse() {
		fail("Not yet implemented");
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
		
		// Maybe try length 0?
	}

	@Test
	public void testRotateLeft() {
		fail("Not yet implemented");
	}

	@Test
	public void testTranspose() {
		int[][] transpose = { {1, 4, 7, 10},
						 		 {2, 5, 8, 11},
						 		 {3, 6, 9, 12} };
		Layout transpose_layout = new Layout(transpose);
		assertEquals(first_layout.transpose(), transpose_layout);

		// Maybe try other dimensions or length 0?
	}

	@Test
	public void testRavel() {
		fail("Not yet implemented");
	}

	@Test
	public void testUnravel() {
		int[] unraveled = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		Layout unraveled_layout = new Layout(unraveled);
		assertEquals(first_layout.unravel(), unraveled_layout);
		
		// Maybe try length 0?
	}

	@Test
	public void testReshape() {
		fail("Not yet implemented");
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
		int[][] empty_array = { {},
								{},
								{},
								{} };
		Layout empty_layout = new Layout(empty_array);
		assertEquals(first_layout, first_layout.join(empty_layout));
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
		fail("Not yet implemented");
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
		fail("Not yet implemented");
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
		fail("Not yet implemented");
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
		fail("Not yet implemented");
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
		fail("Not yet implemented");
	}

	@Test
	public void testToArray2D() {
		fail("Not yet implemented");
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
