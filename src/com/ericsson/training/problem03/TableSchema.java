package com.ericsson.training.problem03;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ericsson.training.common.ConstantFile;
/**
 * Connect the database and retrive the table schema
 * @author ezaksch
 * @see Connection,DatabaseMetaData,DriverManager,ResultSet,SQLException.
 */
public class TableSchema {
	public static void main(String[] args) throws Exception {
		TableSchema TableSchemaObject = new TableSchema();
		TableSchemaObject.tableSchema();
	}
/**
 * to build up a connection with the database using JDBC driver
 * @return Connection
 */
	private Connection buildConnection() {
		Connection connection = null;
		String database = ConstantFile.DATABASE;
		String userName = ConstantFile.USER_NAME;
		String password = ConstantFile.PASSWORD;
		try {
			Class.forName(ConstantFile.DRIVER);
			connection = DriverManager.getConnection(ConstantFile.URL + database, userName, password);
		} catch (Exception e) {
			System.out.println(e);
		}

		return connection;

	}
/**
 * To print the tableSchema from the database
 */
	private void tableSchema() {
		Connection connection = null;
		try {
			String tableName,tableCatalog,tableSchema,type,output,columnName,result ;
			connection = buildConnection();
			DatabaseMetaData dataBaseMetaData = connection.getMetaData();
			String[] types = { ConstantFile.TABLE };
			ResultSet resultSet = dataBaseMetaData.getTables(null, null, "%", types);
			ResultSet columns;
			while (resultSet.next()) {
			tableName = resultSet.getString(3);
			tableCatalog = resultSet.getString(1);
			tableSchema = resultSet.getString(2);
			type=resultSet.getString(4);
			columns = dataBaseMetaData.getColumns(null,null,tableName,null);
			output = String.format("%s %s %s %s", tableName, tableCatalog, tableSchema,type);
			System.out.println("\t"+output); 
		     while(columns.next())
		     {
		      columnName = columns.getString(1);
		      result = String.format("%s", columnName);
		      System.out.println(result);
		     }

			}
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}

	}
}
