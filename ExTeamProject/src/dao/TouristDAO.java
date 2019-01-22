package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

import db.ConnectionPool;
import tourist.dto.TouristDTO;
import tourist.dto.Tourist_carlistDTO;

public class TouristDAO {

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ConnectionPool pool = new ConnectionPool();
	
	public TouristDAO() {
		con = pool.getConnection();
		
		
	}
	
	// 소형, 중형, 대형 중 하나를 선택 후 선택한 정보를 가져오는 메서드
	public Vector<Tourist_carlistDTO> getCarList(String car_category){
		
		//순서: 소형, 중형, 대형 중 하나 선택  -> Tourist_carlistDTO객체에 저장 -> Vector에 저장 
		
		// 1. Vector 객체생성 : 참조변수이름 v
		Vector<Tourist_carlistDTO> carlistV = new Vector<Tourist_carlistDTO>();
		String sql="";
		Tourist_carlistDTO cardto = new Tourist_carlistDTO(); 
		
		// 2. 소형, 중형, 대형중 선택한 값의 레코드들을 저장할 Tourist_carlistDTO클래스 타입의 T_carlistBean변수 선언
				
		try{
			sql="select * from t_carlist where car_category=? order by car_no";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, car_category);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				cardto.setCar_no(rs.getInt(1));
				cardto.setCar_name(rs.getString(2));
				cardto.setCar_company(rs.getString(3));
				cardto.setCar_price(rs.getInt(4));
				cardto.setCar_usepeople(5);
				cardto.setCar_info(rs.getString(6));
				cardto.setCar_img(rs.getString(7));
				cardto.setCar_category(rs.getString(8));
				
				carlistV.add(cardto);
				
			}
				
		}catch(Exception e){
			System.out.println("소형,중형,대형 중 선택 리스트 보여주기 오류" + e);
		}finally{
			pool.close(con, pstmt, rs);
		}
		
		return carlistV;
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
}



