package layout;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LayoutTest {

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
		fail("Not yet implemented");
	}

	@Test
	public void testReverse() {
		fail("Not yet implemented");
	}

	@Test
	public void testRotateRight() {
		fail("Not yet implemented");
	}

	@Test
	public void testRotateLeft() {
		fail("Not yet implemented");
	}

	@Test
	public void testTranspose() {
		fail("Not yet implemented");
	}

	@Test
	public void testRavel() {
		fail("Not yet implemented");
	}

	@Test
	public void testUnravel() {
		fail("Not yet implemented");
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