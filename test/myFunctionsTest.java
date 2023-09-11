import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class myFunctionsTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testMySwap() {
		myFunctions myFuncs = new myFunctions();
		int[] sample = {1, 2};
		myFuncs.mySwap(sample, 0, 1);
		int[] expected = {2, 1};
		assertEquals(expected[0], sample[0]);
		assertEquals(expected[1], sample[1]);
	}

	@Test
	void testMyMin() {
		myFunctions myFuncs = new myFunctions();
		int[] myArr = {1, 2, 3, 4, 5};
		int actual = myFuncs.myMin(myArr);
		int expected = 1;
		assertEquals(expected, actual);
	}

	@Test
	void testMyMax() {
		myFunctions myFuncs = new myFunctions();
		int[] myArr = {1, 2, 3, 4, 5};
		int actual = myFuncs.myMax(myArr);
		int expected = 5;
		assertEquals(expected, actual);
	}

	@Test
	void testMySearch() {
		myFunctions myFuncs = new myFunctions();
		int[] myArr = {1, 2, 3, 4, 5};
		int actual = myFuncs.mySearch(myArr, 3);
		int expected = 2;
		assertEquals(expected, actual);
	}

}
