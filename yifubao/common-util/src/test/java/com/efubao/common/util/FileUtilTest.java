/**
 * FileUtilTest.java
 * Copyright (c) 2013 by efubao.com
 */
package com.efubao.common.util;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.io.Writer;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.efubao.common.util.Charset;
import com.efubao.common.util.FileUtil;

/**
 *
 */
public class FileUtilTest {
	/** directory name 1 */
	private String testDir1;
	/** directory name 2 */
	private String testDir2;
	/** test directory name */
	private String testDir = "/tmp/java-unit-test";
	/** test file name */
	private String testFile1;
	/** test file name */
	private String testFile2;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		testDir1 = testDir + File.separator + RandomStringUtils.randomAlphabetic(10);
		testDir2 = testDir + File.separator + RandomStringUtils.randomAlphabetic(10);
		testFile1 = testDir + File.separator + "/f1.txt";
		testFile2 = testDir + File.separator + "/f2.txt";
		Writer w = null;
		try {
			w = FileUtil.getFileWriter(testFile1, true);
			w.write("test123");
			w.flush();
			w.close();
			Assert.isTrue(FileUtil.getFile(testFile1).length() > 0);
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} finally {
			if (w != null) {
				try {
					w.close();
				} catch (IOException e) {
					// ignore
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		FileUtil.deleteDirectory(testDir);
	}

	/**
	 * Test method for {@link com.efubao.common.util.FileUtil#mkdir(java.lang.String)}.
	 * @throws IOException 
	 */
	@Test
	public void testMkdir() {
		Assert.isTrue(FileUtil.mkdir(testDir1));
		try {
			FileUtil.deleteDirectory(testDir1);
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link com.efubao.common.util.FileUtil#exists(java.lang.String)}.
	 */
	@Test
	public void testExists() {
		Assert.isTrue(!FileUtil.exists(testDir1));
		Assert.isTrue(!FileUtil.exists(testDir2));
		FileUtil.mkdir(testDir1);
		FileUtil.mkdir(testDir2);
		Assert.isTrue(FileUtil.exists(testDir1));
		Assert.isTrue(FileUtil.exists(testDir2));
		try {
			FileUtil.deleteDirectory(testDir1);
			FileUtil.deleteDirectory(testDir2);
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link com.efubao.common.util.FileUtil#mv(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testMv() {
		Assert.isTrue(FileUtil.exists(testFile1));
		FileUtil.mv(testFile1, testFile2);
		Assert.isTrue(!FileUtil.exists(testFile1));
		Assert.isTrue(FileUtil.exists(testFile2));
		FileUtil.mv(testFile2, testFile1);
	}

	/**
	 * Test method for {@link com.efubao.common.util.FileUtil#getFile(java.lang.String)}.
	 */
	@Test
	public void testGetFileString() {
		Assert.isTrue(!FileUtil.getFile(testDir1).exists());
	}

	/**
	 * Test method for {@link com.efubao.common.util.FileUtil#delete(java.lang.String)}.
	 */
	@Test
	public void testDelete() {
		FileUtil.mkdir(testDir1);
		Assert.isTrue(FileUtil.delete(testDir1));
	}

	/**
	 * Test method for {@link com.efubao.common.util.FileUtil#getFileWriter(java.lang.String, boolean)}.
	 */
	@Test
	public void testGetFileWriterStringBoolean() {
		String file = testDir1 + "/test.txt";
		Writer w = null;
		try {
			w = FileUtil.getFileWriter(file, true);
			w.write("test123");
			w.flush();
			w.close();
			Assert.isTrue(FileUtil.getFile(file).length() > 0);
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} finally {
			if (w != null) {
				try {
					w.close();
				} catch (IOException e) {
					// ignore
					e.printStackTrace();
				}
			}
		}
		try {
			FileUtil.deleteDirectory(testDir1);
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link com.efubao.common.util.FileUtil#getFileWriter(java.lang.String, boolean, java.lang.String)}.
	 */
	@Test
	public void testGetFileWriterStringBooleanString() {
		String file = testDir1 + "/test.txt";
		Writer w = null;
		try {
			w = FileUtil.getFileWriter(file, true, Charset.UTF_8.getValue());
			w.write("test123");
			w.flush();
			w.close();
			Assert.isTrue(FileUtil.getFile(file).length() > 0);
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} finally {
			if (w != null) {
				try {
					w.close();
				} catch (IOException e) {
					// ignore
					e.printStackTrace();
				}
			}
		}
		try {
			FileUtil.deleteDirectory(testDir1);
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link com.efubao.common.util.FileUtil#cp(java.io.File, java.io.File)}.
	 */
	@Test
	public void testCpFileFile() {
		Assert.isTrue(FileUtil.exists(testFile1));
		FileUtil.cp(new File(testFile1), new File(testFile2));
		Assert.isTrue(FileUtil.exists(testFile1));
		Assert.isTrue(FileUtil.exists(testFile2));
		FileUtil.delete(testFile2);
	}

	/**
	 * Test method for {@link com.efubao.common.util.FileUtil#cp(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testCpStringString() {
		Assert.isTrue(FileUtil.exists(testFile1));
		FileUtil.cp(testFile1, testFile2);
		Assert.isTrue(FileUtil.exists(testFile1));
		Assert.isTrue(FileUtil.exists(testFile2));
		FileUtil.delete(testFile2);
	}

	/**
	 * Test method for {@link com.efubao.common.util.FileUtil#delAllFile(java.lang.String)}.
	 */
	@Test
	public void testDelAllFile() {
		Assert.isTrue(FileUtil.exists(testFile1));
		FileUtil.cp(new File(testFile1), new File(testFile2));
		Assert.isTrue(FileUtil.getFile(testDir).list().length == 2);
		FileUtil.delete(testFile2);
	}

}
