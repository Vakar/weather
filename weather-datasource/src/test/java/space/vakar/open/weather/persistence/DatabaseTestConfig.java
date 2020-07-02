package space.vakar.open.weather.persistence;

import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.ext.h2.H2DataTypeFactory;

abstract class DatabaseTestConfig extends DBTestCase {

  DatabaseTestConfig(String name) {
    super(name);
    JdbcConnectionProperties connProps = JdbcConnectionProperties.getInstance();
    System.setProperty(
        PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, connProps.getDriver());
    System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, connProps.getUrl());
    System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, connProps.getUser());
    System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, connProps.getPsw());
  }

  @Override
  protected void setUpDatabaseConfig(DatabaseConfig config) {
    config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new H2DataTypeFactory());
  }
}
