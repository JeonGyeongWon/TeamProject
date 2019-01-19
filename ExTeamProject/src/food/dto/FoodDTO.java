package food.dto;

import java.sql.Timestamp;

public class FoodDTO {

	int f_no;
	String f_name;
	String f_content;
	String f_menu;	
	String f_detail;
	Timestamp f_regdate;
	String f_imgpath;
	String f_imgname;
	int f_bestcount;
	int user_no;
	
	
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	
	public int getf_no() {
		return f_no;
	}
	public void setf_no(int f_no) {
		this.f_no = f_no;
	}
	public String getf_name() {
		return f_name;
	}
	public void setf_name(String f_name) {
		this.f_name = f_name;
	}
	public String getH_content() {
		return f_content;
	}
	public void setH_content(String f_content) {
		this.f_content = f_content;
	}
	public String getH_addr() {
		return f_menu;
	}
	public void setH_addr(String f_menu) {
		this.f_menu = f_menu;
	}
	
	public String getH_detail() {
		return f_detail;
	}
	public void setH_detail(String f_detail) {
		this.f_detail = f_detail;
	}
	public Timestamp getH_regdate() {
		return f_regdate;
	}
	public void setH_regdate(Timestamp f_regdate) {
		this.f_regdate = f_regdate;
	}
	public String getH_imgpath() {
		return f_imgpath;
	}
	public void setH_imgpath(String f_imgpath) {
		this.f_imgpath = f_imgpath;
	}
	public String getf_imgname() {
		return f_imgname;
	}
	public void setf_imgname(String f_imgname) {
		this.f_imgname = f_imgname;
	}
	public int getf_bestcount() {
		return f_bestcount;
	}
	public void setH_bestcount(int f_bestcount) {
		this.f_bestcount = f_bestcount;
	}
	
	
	
		
	
}
