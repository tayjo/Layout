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
		// What if my_array.length = 0?
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
		fail("Not yet implemented");
	}

	@Test
	public void testStack() {
		fail("Not yet implemented");
	}

	@Test
	public void testRowCount() {
		fail("Not yet implemented");
	}

	@Test
	public void testColumnCount() {
		fail("Not yet implemented");
	}

	@Test
	public void testRows() {
		fail("Not yet implemented");
	}

	@Test
	public void testColumns() {
		fail("Not yet implemented");
	}

	@Test
	public void testSlice() {
		fail("Not yet implemented");
	}

	@Test
	public void testReplace() {
		fail("Not yet implemented");
	}

	@Test
	public void testEqualsObject() {
		fail("Not yet implemented");
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
		fail("Not yet implemented");
	}

}
