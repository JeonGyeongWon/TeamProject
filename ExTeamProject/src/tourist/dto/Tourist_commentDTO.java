package tourist.dto;

import java.sql.Timestamp;

public class Tourist_commentDTO {

	int t_no; 
	int t_cno;  
	int user_no; 
	String subject;
	String content; 
	Timestamp regdate; 
	int bestcount;
	
	public int getT_no() {
		return t_no;
	}
	public void setT_no(int t_no) {
		this.t_no = t_no;
	}
	public int getT_cno() {
		return t_cno;
	}
	public void setT_cno(int t_cno) {
		this.t_cno = t_cno;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getRegdate() {
		return regdate;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	public int getBestcount() {
		return bestcount;
	}
	public void setBestcount(int bestcount) {
		this.bestcount = bestcount;
	}
	
}
