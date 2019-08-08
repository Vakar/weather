package org.open.weather.persistence;

import java.sql.SQLException;
import java.util.List;

interface Dao<T extends Dto> {

	void create(T cityDto) throws SQLException;

	T read(int id) throws SQLException;

	void update(T cityDto) throws SQLException;

	void delete(int id) throws SQLException;

	List<T> search(String columnName, String substring) throws SQLException;

}
