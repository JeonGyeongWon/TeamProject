package tourist.dto;

import java.sql.Timestamp;

//tourist_board dto입니다.
public class Tourist {

	int t_no; 
	String t_name; 
	String t_email; 
	String t_title; 
	String t_content; 
	String t_group; //check 조건 추가해주세요~
	int t_level;  
	Timestamp regdate; 
	String imgpath; 
	String imgname;
	int bestcount;
	
	public int getT_no() {
		return t_no;
	}
	public void setT_no(int t_no) {
		this.t_no = t_no;
	}
	public String getT_name() {
		return t_name;
	}
	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
	public String getT_email() {
		return t_email;
	}
	public void setT_email(String t_email) {
		this.t_email = t_email;
	}
	public String getT_title() {
		return t_title;
	}
	public void setT_title(String t_title) {
		this.t_title = t_title;
	}
	public String getT_content() {
		return t_content;
	}
	public void setT_content(String t_content) {
		this.t_content = t_content;
	}
	public String getT_group() {
		return t_group;
	}
	public void setT_group(String t_group) {
		this.t_group = t_group;
	}
	public int getT_level() {
		return t_level;
	}
	public void setT_level(int t_level) {
		this.t_level = t_level;
	}
	public Timestamp getRegdate() {
		return regdate;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	public String getImgpath() {
		return imgpath;
	}
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
	public String getImgname() {
		return imgname;
	}
	public void setImgname(String imgname) {
		this.imgname = imgname;
	}
	public int getBestcount() {
		return bestcount;
	}
	public void setBestcount(int bestcount) {
		this.bestcount = bestcount;
	} 
	
}
