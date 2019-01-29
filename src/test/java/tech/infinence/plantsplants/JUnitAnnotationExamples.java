package tech.infinence.plantsplants;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class JUnitAnnotationExamples {

	/**
	 * Run only once before the class
	 */
	@BeforeClass
	public static void setupEverything() {
		int i = 1 + 1;
	}

	/**
	 * Runs exactly once, runs last
	 */
	@AfterClass
	public static void teardownEverything() {
		int i = 1 + 1;
	}

	/**
	 * Runs before every test
	 */
	@Before
	public void setupBeforeEachTest() {
		int i = 1 + 1;
	}

	/**
	 * Runs after every test
	 */
	@After
	public void teardownBeforeEachTest() {
		int i = 1 + 1;
	}

	@Test
	public void runTests() {
		int i = 1 + 1;
		assertEquals(2, i);
	}

	@Test
	public void runMoreTests() {
		int i = 1 + 1;
		assertEquals(2, i);
	}
}
