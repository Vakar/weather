package space.vakar.weather.domain.core;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({WeatherAgentImplTest.class, WeatherContainerTest.class, WeatherServiceImplTest.class})
public class AllTests {}
