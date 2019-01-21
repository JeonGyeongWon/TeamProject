package food.dto;

import java.sql.Timestamp;

public class FoodDTO {

	private int f_no;
	private int user_no;
	private String f_name;
	private String f_menu;
	private String f_content;
	private String f_group;
	private String f_addr;
	private String f_addr_latitude;
	private String f_addr_longitude;
	private String f_imgpath;
	private String f_imgname;
	private Timestamp f_regdate;
	private Timestamp f_latestupdate;
	private int f_bestcount;
	
	public int getF_no() {
		return f_no;
	}
	public void setF_no(int f_no) {
		this.f_no = f_no;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public String getF_menu() {
		return f_menu;
	}
	public void setF_menu(String f_menu) {
		this.f_menu = f_menu;
	}
	public String getF_content() {
		return f_content;
	}
	public void setF_content(String f_content) {
		this.f_content = f_content;
	}
	public String getF_group() {
		return f_group;
	}
	public void setF_group(String f_group) {
		this.f_group = f_group;
	}
	public String getF_addr() {
		return f_addr;
	}
	public void setF_addr(String f_addr) {
		this.f_addr = f_addr;
	}
	public String getF_addr_latitude() {
		return f_addr_latitude;
	}
	public void setF_addr_latitude(String f_addr_latitude) {
		this.f_addr_latitude = f_addr_latitude;
	}
	public String getF_addr_longitude() {
		return f_addr_longitude;
	}
	public void setF_addr_longitude(String f_addr_longitude) {
		this.f_addr_longitude = f_addr_longitude;
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
	public Timestamp getF_regdate() {
		return f_regdate;
	}
	public void setF_regdate(Timestamp f_regdate) {
		this.f_regdate = f_regdate;
	}
	public Timestamp getF_latestupdate() {
		return f_latestupdate;
	}
	public void setF_latestupdate(Timestamp f_latestupdate) {
		this.f_latestupdate = f_latestupdate;
	}
	public int getF_bestcount() {
		return f_bestcount;
	}
	public void setF_bestcount(int f_bestcount) {
		this.f_bestcount = f_bestcount;
	}
	
	
}
