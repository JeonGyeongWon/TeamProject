package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.ConnectionPool;
import food.dto.FoodDTO;

public class FoodDAO {

	ConnectionPool cp;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	public FoodDAO() {
		cp = new ConnectionPool();
	}
	
	public int insertFood(){
		int result = 0;
		return result;
	}

	public ArrayList<FoodDTO> allSelectedFood() {
		ArrayList<FoodDTO> list = null;
		FoodDTO fDTO = null;
		try {
			con = cp.getConnection();
			String sql = "select * from food order by f_no desc";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				list = new ArrayList<>();
				fDTO = new FoodDTO();
				/*
				f_no int primary key auto_increment,
				user_no int references users(user_no) on delete cascade on update cascade,
				f_brand varchar(45) not null,
				f_tel varchar(20) not null,
				f_group varchar(10) not null,
				f_title varchar(45) not null,
				f_content varchar(300) not null,
				f_addr_latitude int not null,
				f_map_level int not null,
				f_regdate timestamp not null,
				f_latestupdate timestamp,
				f_bestcount int default 0 not null
				*/
				int f_no = rs.getInt("f_no");
				int user_no = rs.getInt("user_no");
				String f_brand = rs.getString("f_brand");
				String f_tel = rs.getString("f_tel");
				String f_group = rs.getString("f_group");
				String f_title = rs.getString("f_title");
				String f_content = rs.getString("f_content");
				String f_addr_latitude = rs.getString("");
				
			}
			
		} catch (Exception e) {
			System.out.print("allSelectedFood()메서드 내부 오류: ");
			e.printStackTrace();
		}
		return null;
	}
}
