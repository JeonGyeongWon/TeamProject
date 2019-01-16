package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConnectionPool {
	
	Connection con;
	DataSource ds;
	
	public Connection getConnection(){
		try {
			Context initCtx = new InitialContext();
			ds = (DataSource) initCtx.lookup("java:comp/env/jdbc/promotion");
			con = ds.getConnection();
			System.out.println("ConnectionPool 생성");
			con.setAutoCommit(true);
		} catch (Exception e) {
			System.out.print("커넥션풀 얻기 실패: ");
			e.printStackTrace();
		}
		return con;
	}
	
	public void close(Connection con, PreparedStatement pstmt, ResultSet rs){
		if(rs!=null) try{rs.close();} catch(Exception e){}
		if(pstmt!=null) try{pstmt.close();} catch(Exception e){}
		if(con!=null) try{con.close();} catch(Exception e){}
	}
}
