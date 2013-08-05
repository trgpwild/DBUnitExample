package org.sharkness.dbunit.config;

import java.io.FileInputStream;
import java.sql.Connection;

import org.dbunit.DatabaseTestCase;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Before;

public abstract class _DBUnitConfiguration extends DatabaseTestCase {
	
	private  final String pathDataSet = "src/test/resources/";
	
	private String defaultDataSet = "application-dataset.xml";
	
	public _DBUnitConfiguration() {
		super();
	}

	public _DBUnitConfiguration(String name) {
		super(name);
	}
	
	protected void setDefaultDataSet(String defaultDataSet) {
		this.defaultDataSet = defaultDataSet;
	}
	
	@Override
	protected IDatabaseConnection getConnection() throws Exception {
		IDatabaseConnection iDataBaseConnection = new DatabaseConnection(getJdbcConnection());
		return iDataBaseConnection ;
	}
	
	protected Connection getJdbcConnection() throws Exception {
		com.mchange.v2.c3p0.ComboPooledDataSource ds = new com.mchange.v2.c3p0.ComboPooledDataSource();
		ds.setJdbcUrl("jdbc:hsqldb:mem:database-acceptance-test");
		ds.setDriverClass("org.hsqldb.jdbcDriver");
		ds.setUser("sa");
		ds.setPassword("");
		return ds.getConnection();
	}

	@Override
	protected IDataSet getDataSet() throws Exception {
		FileInputStream loadFile = new FileInputStream(getDataSetXml());
		IDataSet dataSet = new FlatXmlDataSetBuilder().build(loadFile);
		return dataSet;
	}
	
	private String getDataSetXml() {
		return pathDataSet + defaultDataSet;
	}

	@Override
	protected DatabaseOperation getSetUpOperation() throws Exception {
		return DatabaseOperation.CLEAN_INSERT;
	}
	
	@Before
	public void setUp() throws Exception {
		getSetUpOperation().execute(getConnection(), getDataSet());
	}

}