package space.vakar.open.weather.persistence;

import org.apache.commons.dbcp.BasicDataSource;

public class DbcpDataSource {

  private static final long TWENTY_MIN = 20L * 60L * 1000L;

  private static BasicDataSource dataSource = new BasicDataSource();

  static {
    JdbcConnectionProperties connProp = JdbcConnectionProperties.getInstance();
    dataSource.setDriverClassName(connProp.getDriver());
    dataSource.setUrl(connProp.getUrl());
    dataSource.setUsername(connProp.getUser());
    dataSource.setPassword(connProp.getPsw());
    dataSource.setMaxWait(TWENTY_MIN);
  }

  public static BasicDataSource getDataSource() {
    return dataSource;
  }

  private DbcpDataSource() {}
}
