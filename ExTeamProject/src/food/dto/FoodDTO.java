package food.dto;

import java.sql.Timestamp;

public class FoodDTO {

	private int f_no;
	private String f_name;
	private String f_content;
	private String f_menu;	
	private String f_detail;
	private Timestamp f_regdate;
	private String f_imgpath;
	private String f_imgname;
	private int f_bestcount;
	private int user_no;
	
	
	public int getF_no() {
		return f_no;
	}
	public void setF_no(int f_no) {
		this.f_no = f_no;
	}
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public String getF_content() {
		return f_content;
	}
	public void setF_content(String f_content) {
		this.f_content = f_content;
	}
	public String getF_menu() {
		return f_menu;
	}
	public void setF_menu(String f_menu) {
		this.f_menu = f_menu;
	}
	public String getF_detail() {
		return f_detail;
	}
	public void setF_detail(String f_detail) {
		this.f_detail = f_detail;
	}
	public Timestamp getF_regdate() {
		return f_regdate;
	}
	public void setF_regdate(Timestamp f_regdate) {
		this.f_regdate = f_regdate;
	}
	public String getF_imgpath() {
		return f_imgpath;
	}
	public void setF_imgpath(String f_imgpath) {
		this.f_imgpath = f_imgpath;
	}
	public String getF_imgname() {
		return f_imgname;
	}
	public void setF_imgname(String f_imgname) {
		this.f_imgname = f_imgname;
	}
	public int getF_bestcount() {
		return f_bestcount;
	}
	public void setF_bestcount(int f_bestcount) {
		this.f_bestcount = f_bestcount;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	
		
	
}
