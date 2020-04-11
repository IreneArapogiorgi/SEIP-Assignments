package math;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * A class that groups MyMathParameterizedTest
 * and MyMathTest classes.
 *
 * @author Irene Arapogiorgi
 * @version 1.0
 * @since   2020-04-10
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({MyMathTest.class, MyMathTest.class, MyMathParameterizedTest.class})
public class MyMathTestSuite {
	/*
	 * This class remains empty. Is used only
	 * as a holder of the above annotations.
	 */
}