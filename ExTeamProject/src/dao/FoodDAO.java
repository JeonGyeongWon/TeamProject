package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
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
	
		//foodMain.jsp페이지에서 등록된 글을 뿌려주는 메서드(미완)
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
				
				int f_no = rs.getInt("f_no");
				int user_no = rs.getInt("user_no");
				String f_name = rs.getString("f_name");
				String f_menu = rs.getString("f_menu");
				String f_content = rs.getString("f_content");
				String f_group = rs.getString("f_group");
				String f_addr = rs.getString("f_addr");
				double f_addr_latitude = rs.getDouble("f_addr_latitude");
				double f_addr_longitude = rs.getDouble("f_addr_longitude");
				String f_imgpath = rs.getString("f_imgpath");
				String f_imgname = rs.getString("f_imgname");
				Timestamp f_regdate = rs.getTimestamp("f_regdate");
				Timestamp f_latestupdate = rs.getTimestamp("f_latestupdate");
				int f_bestcount = rs.getInt("f_bestcount");
				
				
				//개발자 상태 확인 → 추후 삭제 예정
				System.out.println("f_no는 " + f_no + "입니다.");
				System.out.println("user_no는 " + user_no + "입니다.");
				System.out.println("f_name은 " + f_name + "입니다.");
				System.out.println("f_menu는 " + f_menu + "입니다.");
				System.out.println("f_content는 " + f_content + "입니다.");
				System.out.println("f_group은 " + f_group + "입니다.");
				System.out.println("f_addr은 " + f_addr + "입니다.");
				System.out.println("f_addr_latitude는 " + f_addr_latitude + "입니다.");
				System.out.println("f_longitude는 " + f_addr_longitude + "입니다.");
				System.out.println("f_imgpath는 " + f_imgpath + "입니다.");
				System.out.println("f_imgname은 " + f_imgname + "입니다.");
				System.out.println("f_regdate는 " + f_regdate + "입니다.");
				System.out.println("f_latestupdate는 " + f_latestupdate + "입니다.");
				System.out.println("f_bestcount는 " + f_bestcount + "입니다.");
				//개발자 상태 확인 → 추후 삭제 예정
				
				
				fDTO.setF_no(f_no);
				fDTO.setUser_no(user_no);
				fDTO.setF_name(f_name);
				fDTO.setF_menu(f_menu);
				fDTO.setF_content(f_content);
				fDTO.setF_group(f_group);
				fDTO.setF_addr(f_addr);
				fDTO.setF_addr_latitude(f_addr_latitude);
				fDTO.setF_addr_longitude(f_addr_longitude);
				fDTO.setF_imgpath(f_imgpath);
				fDTO.setF_imgname(f_imgname);
				fDTO.setF_regdate(f_regdate);
				fDTO.setF_latestupdate(f_latestupdate);
				fDTO.setF_bestcount(f_bestcount);
				
				list.add(fDTO);
			}
			
		} catch (Exception e) {
			System.out.print("allSelectedFood()메서드 내부 오류: ");
			e.printStackTrace();
		}
		return list;
	}
	
	public int insertFood(FoodDTO fdto){
		int result = -1;
		try {
			con = cp.getConnection();
			String sql = "insert into food (f_no, user_no, f_name, f_group, f_menu, f_content, f_addr, f_addr_latitude, f_addr_longitude,"
					+ " f_imgpath, f_imgname, f_regdate, f_latestupdate, f_bestcount)"
					+ " values (null, ?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			int user_no = fdto.getUser_no();
			String f_name = fdto.getF_name();
			String f_group = fdto.getF_group();
			String f_menu = fdto.getF_menu();
			String f_content = fdto.getF_content();
			String f_addr = fdto.getF_addr();
			String f_imgname = fdto.getF_imgname();
			String f_imgpath = fdto.getF_imgpath();
			double f_addr_latitude = fdto.getF_addr_latitude();
			double f_addr_longitude = fdto.getF_addr_longitude();
			
			pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, user_no);
				pstmt.setString(2, f_name);
				pstmt.setString(3, f_group);
				pstmt.setString(4, f_menu);
				pstmt.setString(5, f_content);
				pstmt.setString(6, f_addr);
				pstmt.setDouble(7, f_addr_latitude);
				pstmt.setDouble(8, f_addr_longitude);
				pstmt.setString(9, f_imgpath);
				pstmt.setString(10, f_imgname);
				pstmt.setTimestamp(11, new Timestamp(System.currentTimeMillis()));
				pstmt.setTimestamp(12, new Timestamp(System.currentTimeMillis()));
				pstmt.setInt(13, 0);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.print("insertFood()메서드 내부 오류: ");
			e.printStackTrace();
		} finally {
			cp.close(con, pstmt, rs);
		}
		return result;
	}
}
