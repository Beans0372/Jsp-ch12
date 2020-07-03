package db;

import java.sql.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JdbcUtil {

	public static Connection getConnection() {
		Connection con = null;
		
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context)initCtx.lookup("java:/comp/env");
			DataSource ds = (DataSource)envCtx.lookup("jdbc/myoracle");
			con = ds.getConnection();
			System.out.println("JdbcUtil : 데이터베이스 연결 성공");
			con.setAutoCommit(false);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("JdbcUtil : 데이터베이스 연결 실패");
			System.out.println("JdbcUtil : Message : " + e.getMessage());
		}
		return con;
	}

	public static void close(Connection con) {

		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void close(Statement stmt) {

		try {
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void close(ResultSet rs) {

		try {
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void commit(Connection con) {

		try {
			con.commit();
			System.out.println("commit success");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void rollback(Connection con) {

		try {
			con.rollback();
			System.out.println("rollback success");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

