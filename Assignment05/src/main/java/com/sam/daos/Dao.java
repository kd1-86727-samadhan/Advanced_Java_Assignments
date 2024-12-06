package com.sam.daos;

import java.sql.Connection;

import com.sam.utils.DbUtil;

public abstract class Dao implements AutoCloseable {
	protected Connection con;
	public Dao() throws Exception {
		con = DbUtil.getConnection();
	}
	public void close() throws Exception {
		con.close();
	}
}
