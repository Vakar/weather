package space.vakar.open.weather.impl;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ParserTest.class, ProviderTest.class, RetrieverTest.class})
public class AllTests {

}
