package space.vakar.open.weather.persistence;

import org.apache.commons.dbcp.BasicDataSource;

class DbcpDataSource {

  private static final int TWENTY_MINUTES = 20 * 60 * 1000;

  private static BasicDataSource dataSource = new BasicDataSource();

  static {
    JdbcConnectionProperties connProp = JdbcConnectionProperties.getInstance();
    dataSource.setDriverClassName(connProp.getDriver());
    dataSource.setUrl(connProp.getUrl());
    dataSource.setUsername(connProp.getUser());
    dataSource.setPassword(connProp.getPsw());
    dataSource.setMaxWait(TWENTY_MINUTES);
  }

  static BasicDataSource getDataSource() {
    return dataSource;
  }

  private DbcpDataSource() {}
}
