package com.emc.xcelerators.community.bpm.predicateutils.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Ingemar Axelsson <ingemar.axelsson@emc.com>
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses( { BooleanComparatorTests.class, DateComparatorTests.class, DoubleComparatorTests.class, EqualComparatorTests.class  })
public class AllTests {

	/**
	 * @return suite
	 */
	public static Test suite() {
		TestSuite suite = new TestSuite(
				"Test for com.emc.xcelerators.community.bpm.predicateutils.tests");
		//$JUnit-BEGIN$

		//$JUnit-END$
		return suite;
	}

}
