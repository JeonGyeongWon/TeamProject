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
	private double f_addr_latitude;
	private double f_addr_longitude;
	private String f_imgpath;
	private String f_imgname;
	private Timestamp f_regdate;
	private Timestamp f_latestupdate;
	private int f_bestcount;
	
	
	//**********************************************************충돌 방지용
	private int h_no;
	private String h_name;
	private String h_content;
	private String h_addr;
	private String h_caution;
	private String h_rule;
	private String h_detail;
	private Timestamp h_regdate;
	private String h_imgpath;
	private String h_imgname;
	private int h_bestcount;
	private String latitude;
	private String hardness;
	
	public int getH_no() {
		return h_no;
	}
	public void setH_no(int h_no) {
		this.h_no = h_no;
	}
	public String getH_name() {
		return h_name;
	}
	public void setH_name(String h_name) {
		this.h_name = h_name;
	}
	public String getH_content() {
		return h_content;
	}
	public void setH_content(String h_content) {
		this.h_content = h_content;
	}
	public String getH_addr() {
		return h_addr;
	}
	public void setH_addr(String h_addr) {
		this.h_addr = h_addr;
	}
	public String getH_caution() {
		return h_caution;
	}
	public void setH_caution(String h_caution) {
		this.h_caution = h_caution;
	}
	public String getH_rule() {
		return h_rule;
	}
	public void setH_rule(String h_rule) {
		this.h_rule = h_rule;
	}
	public String getH_detail() {
		return h_detail;
	}
	public void setH_detail(String h_detail) {
		this.h_detail = h_detail;
	}
	public Timestamp getH_regdate() {
		return h_regdate;
	}
	public void setH_regdate(Timestamp h_regdate) {
		this.h_regdate = h_regdate;
	}
	public String getH_imgpath() {
		return h_imgpath;
	}
	public void setH_imgpath(String h_imgpath) {
		this.h_imgpath = h_imgpath;
	}
	public String getH_imgname() {
		return h_imgname;
	}
	public void setH_imgname(String h_imgname) {
		this.h_imgname = h_imgname;
	}
	public int getH_bestcount() {
		return h_bestcount;
	}
	public void setH_bestcount(int h_bestcount) {
		this.h_bestcount = h_bestcount;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getHardness() {
		return hardness;
	}
	public void setHardness(String hardness) {
		this.hardness = hardness;
	}
	//**********************************************************충돌 방지용
	
	
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
	public double getF_addr_latitude() {
		return f_addr_latitude;
	}
	public void setF_addr_latitude(double f_addr_latitude) {
		this.f_addr_latitude = f_addr_latitude;
	}
	public double getF_addr_longitude() {
		return f_addr_longitude;
	}
	public void setF_addr_longitude(double f_addr_longitude) {
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
