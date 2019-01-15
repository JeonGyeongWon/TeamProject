package tourist.dto;

import java.sql.Timestamp;

public class Tourist_carorder {

	int orderid; 
	int car_no; 
	int user_no; 
	int car_qty;
	Timestamp carreservday;
	Timestamp carbegindate;
	int carins;
	int carwifi; 
	int carnave;
	int carbabyseat;
	
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getCar_no() {
		return car_no;
	}
	public void setCar_no(int car_no) {
		this.car_no = car_no;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public int getCar_qty() {
		return car_qty;
	}
	public void setCar_qty(int car_qty) {
		this.car_qty = car_qty;
	}
	public Timestamp getCarreservday() {
		return carreservday;
	}
	public void setCarreservday(Timestamp carreservday) {
		this.carreservday = carreservday;
	}
	public Timestamp getCarbegindate() {
		return carbegindate;
	}
	public void setCarbegindate(Timestamp carbegindate) {
		this.carbegindate = carbegindate;
	}
	public int getCarins() {
		return carins;
	}
	public void setCarins(int carins) {
		this.carins = carins;
	}
	public int getCarwifi() {
		return carwifi;
	}
	public void setCarwifi(int carwifi) {
		this.carwifi = carwifi;
	}
	public int getCarnave() {
		return carnave;
	}
	public void setCarnave(int carnave) {
		this.carnave = carnave;
	}
	public int getCarbabyseat() {
		return carbabyseat;
	}
	public void setCarbabyseat(int carbabyseat) {
		this.carbabyseat = carbabyseat;
	}
	
}
