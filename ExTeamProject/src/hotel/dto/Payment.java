package hotel.dto;

public class Payment {

	boolean ckprice;
	int user_no;
	int total_price;
	
	public boolean isCkprice() {
		return ckprice;
	}
	public void setCkprice(boolean ckprice) {
		this.ckprice = ckprice;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public int getTotal_price() {
		return total_price;
	}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
	
	
}
