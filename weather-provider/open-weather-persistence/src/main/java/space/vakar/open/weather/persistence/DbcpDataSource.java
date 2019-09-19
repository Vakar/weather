package space.vakar.open.weather.persistence;

import org.apache.commons.dbcp.BasicDataSource;

public class DbcpDataSource {

  private static BasicDataSource ds = new BasicDataSource();

  static {
    JdbcConnectionProperties connProp = JdbcConnectionProperties.getInstance();
    ds.setDriverClassName(connProp.getDriver());
    ds.setUrl(connProp.getUrl());
    ds.setUsername(connProp.getUser());
    ds.setPassword(connProp.getPswd());
  }

  public static BasicDataSource getDataSource() {
    return ds;
  }

  private DbcpDataSource() {}
}
