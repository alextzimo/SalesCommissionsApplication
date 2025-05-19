package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ HTMLInputTest.class, HTMLOutputTest.class, TXTInputTest.class, TXTOutputTest.class, XMLInputTest.class,
		XMLOutputTest.class })
public class AllTests {

}
