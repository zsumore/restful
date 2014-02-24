/* Copyright (c) restSQL Project Contributors. Licensed under MIT. */
package org.restsql.core;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.restsql.core.sqlresource.SqlResourceDefinition;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcOperations;

/**
 * Represents meta data for sql resource. Queries database for table and column
 * meta data and primary and foreign keys.
 * 
 * @author Mark Sawers
 */
public interface SqlResourceMetaData {

	public List<ColumnMetaData> getAllReadColumns();

	public TableMetaData getChild();

	public List<TableMetaData> getChildPlusExtTables();

	public List<ColumnMetaData> getChildReadColumns();

	public TableMetaData getJoin();

	public List<TableMetaData> getJoinList();

	public int getNumberTables();

	public TableMetaData getParent();

	public List<TableMetaData> getParentPlusExtTables();

	public List<ColumnMetaData> getParentReadColumns();

	public Map<String, TableMetaData> getTableMap();

	public List<TableMetaData> getTables();

	public boolean hasJoinTable();

	public boolean hasMultipleDatabases();

	public boolean isHierarchical();

	public void init(String sqlResourceName, SqlResourceDefinition definition,
			DataSource dataSource) throws SqlResourceException,
			DataAccessException;

	public JdbcOperations getJdbcOperations();

	public String toXml();
}