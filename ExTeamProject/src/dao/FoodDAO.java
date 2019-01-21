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
				
//				private int f_no;
//				private int user_no;
//				private String f_name;
//				private String f_menu;
//				private String f_content;
//				private String f_group;
//				private String f_addr;
//				private String f_addr_latitude;
//				private String f_addr_longitude;
//				private String f_imgpath;
//				private String f_imgname;
//				private Timestamp f_regdate;
//				private Timestamp f_latestupdate;
//				private int f_bestcount;	
							
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
	
	public int insertFood(FoodDTO fdto){
		int result = -1;
		try {
			con = cp.getConnection();
			String sql = "insert into food (f_no, user_no, f_name, f_group, f_menu, f_content, f_addr, f_addr_latitude, f_addr_longitude,"
					+ " f_imgpath, f_imgname, f_regdate, f_latestupdate, f_bestcount)"
					+ " values (null, ?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
/*
			 f_no INT PRIMARY KEY AUTO_INCREMENT,	-- 맛집 고유번호
			 user_no INT NOT NULL,					-- 회원번호(참조: users 테이블)
			 f_name VARCHAR(100) NOT NULL,			-- 맛집(식당) 이름
			 f_group VARCHAR(10) NOT NULL,			-- 맛집 분류 카테고리
			 f_menu VARCHAR(500) NOT NULL,			-- 추천메뉴
			 f_content VARCHAR(4000) NOT NULL,		-- 맛집 상세 설명
			 f_addr VARCHAR(1000) NOT NULL,			-- 주소
			 f_addr_latitude VARCHAR(100),			-- 주소(위도)
			 f_addr_longitude VARCHAR(100),			-- 주소(경도)
			 f_imgpath VARCHAR(1000),				-- 맛집 이미지 경로
			 f_imgname VARCHAR(1000),				-- 맛집 이미지 이름
			 f_regdate TIMESTAMP NOT NULL,			-- 게시글 등록일
			 f_latestupdate TIMESTAMP NOT NULL,		-- 게시글 최신 수정일
			 f_bestcount INT NOT NULL default 0		-- 게시글 조회수
*/
			int user_no = fdto.getUser_no();
			String f_name = fdto.getF_name();
			String f_group = fdto.getF_group();
			String f_menu = fdto.getF_menu();
			String f_content = fdto.getF_content();
			String f_addr = fdto.getF_addr();
			String f_imgname = fdto.getF_imgname();
			String f_imgpath = fdto.getF_imgpath();
			
			pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, user_no);
				pstmt.setString(2, f_name);
				pstmt.setString(3, f_group);
				pstmt.setString(4, f_menu);
				pstmt.setString(5, f_content);
				pstmt.setString(6, f_addr);
				pstmt.setString(7, "f_addr_latitude");		//주소-위도값 추후 변경
				pstmt.setString(8, "f_addr_longitude");		//주소-경도값 추후 변경
				pstmt.setString(9, f_imgpath);				//이미지-경로값 추후 변경
				pstmt.setString(10, f_imgname);				//이미지-이름값 추후 변경
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
