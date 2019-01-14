package hotel.dto;

import java.sql.Timestamp;

public class ReservationDTO {

	int h_no;
	int h_rno;
	int user_no;
	Timestamp begindate;
	Timestamp enddate;
	int total_price;
	boolean ckprice;
	Timestamp ckin;
	Timestamp ckout;
	
	public int getH_no() {
		return h_no;
	}
	public void setH_no(int h_no) {
		this.h_no = h_no;
	}
	public int getH_rno() {
		return h_rno;
	}
	public void setH_rno(int h_rno) {
		this.h_rno = h_rno;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public Timestamp getBegindate() {
		return begindate;
	}
	public void setBegindate(Timestamp begindate) {
		this.begindate = begindate;
	}
	public Timestamp getEnddate() {
		return enddate;
	}
	public void setEnddate(Timestamp enddate) {
		this.enddate = enddate;
	}
	public int getTotal_price() {
		return total_price;
	}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
	public boolean isCkprice() {
		return ckprice;
	}
	public void setCkprice(boolean ckprice) {
		this.ckprice = ckprice;
	}
	public Timestamp getCkin() {
		return ckin;
	}
	public void setCkin(Timestamp ckin) {
		this.ckin = ckin;
	}
	public Timestamp getCkout() {
		return ckout;
	}
	public void setCkout(Timestamp ckout) {
		this.ckout = ckout;
	}
	
	
	
}
