package space.vakar.open.weather.provider;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ApiClientBuilderTest.class, ApiClientImplTest.class,
    JsonDeserializerTest.class})
public class AllTests {

}
