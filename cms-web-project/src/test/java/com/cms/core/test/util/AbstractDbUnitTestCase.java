package com.cms.core.test.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import junit.framework.Assert;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatDtdDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlProducer;
import org.dbunit.operation.DatabaseOperation;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.xml.sax.InputSource;

public class AbstractDbUnitTestCase {
	public static IDatabaseConnection dbunitCon;
	private File tempFile;
	private File dtdFile;
	@BeforeClass
	public static void init() throws DatabaseUnitException, SQLException {
		dbunitCon = new DatabaseConnection(DbUtil.getConnection());
	}
	
	/**
	 * 根据配置文件的名称创建DateSet
	 * @param tname配置文件的名称
	 * @return
	 * @throws DataSetException
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	protected IDataSet createDateSet(String tname) throws DataSetException, FileNotFoundException, IOException {
		//配置文件在classes的根目录下
		InputStream is = AbstractDbUnitTestCase
					.class
					.getClassLoader().getResourceAsStream(tname+".xml");
		Assert.assertNotNull("dbunit的基本数据文件不存在",is);
		//创建DataSet
		return new FlatXmlDataSet(new FlatXmlProducer(new InputSource(is), new FlatDtdDataSet(new FileReader(dtdFile))));
	}
	
	protected void backupAllTable() throws SQLException, IOException, DataSetException {
		IDataSet ds = dbunitCon.createDataSet();
		writeBackupFile(ds);
	}
	
	private void writeBackupFile(IDataSet ds) throws IOException, DataSetException {
		tempFile = File.createTempFile("back","xml");
		dtdFile = File.createTempFile("back","dtd");
//		tempFile = new File("~/workspace/backup.xml");
//		dtdFile = new File("~/workspace/backup.dtd");
		FlatDtdDataSet.write(ds, new FileWriter(dtdFile));
		FlatXmlDataSet.write(ds, new FileWriter(tempFile));
	}
	
	protected void backupCustomTable(String[] tname) throws DataSetException, IOException {
		QueryDataSet ds = new QueryDataSet(dbunitCon);
		for(String str:tname) {
			ds.addTable(str);
		}
		writeBackupFile(ds);
	}
	
	protected void bakcupOneTable(String tname) throws DataSetException, IOException {
		backupCustomTable(new String[]{tname});
	}
	
	protected void resumeTable() throws DatabaseUnitException, SQLException, IOException {
		IDataSet ds = new FlatXmlDataSet(new FlatXmlProducer(new InputSource(new FileInputStream(tempFile)),new FlatDtdDataSet(new FileReader(dtdFile))));
		DatabaseOperation.CLEAN_INSERT.execute(dbunitCon, ds);
	}
	
	
	@AfterClass
	public static void destory() {
		try {
			if(dbunitCon!=null) dbunitCon.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
