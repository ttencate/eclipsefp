package net.sf.eclipsefp.haskell.core.jparser.test;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests_PDESuite {

	public static Test suite() {
		TestSuite suite = new TestSuite();
		//$JUnit-BEGIN$
		suite.addTest(net.sf.eclipsefp.haskell.core.jparser.test.MainTests_PDESuite.suite());
		suite.addTest(net.sf.eclipsefp.haskell.core.jparser.ast.test.AllTests.suite());
		//$JUnit-END$
		return suite;
	}

}
