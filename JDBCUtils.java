package com.tedu.jt.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {

	private static ComboPooledDataSource cpds = new ComboPooledDataSource();

	private JDBCUtils() {}

	public static Connection getConn() throws Exception {
		try {
			return cpds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	//close方法是把连接还回连接池,不是关闭连接!
	public static void close(Connection conn,Statement stat,ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				rs = null;
			}
		}

		if(stat != null) {
			try {
				stat.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				stat = null;
			}
		}

		if(conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				conn = null;
			}
		}
	}
}
