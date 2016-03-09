package hello;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Address")
public class Address {
	private int address_id;
	private int houseNo;
//	private String AddressLine1;
//	private String CityandState;
//	private String zipcode;
	
	@Id
	@Column(name="ID",nullable=false)
	public int getAddress_id() {
		return address_id;
	}
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}
	
	@Column(name="HOUSENO",nullable=false)
	public int getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}
	
//	@Column(name="ADDRESSLINE1")
//	public String getAddressLine1() {
//		return AddressLine1;
//	}
//	public void setAddressLine1(String addressLine1) {
//		AddressLine1 = addressLine1;
//	}
//	
//	@Column(name="CITYANDSTATE")
//	public String getCityandState() {
//		return CityandState;
//	}
//	public void setCityandState(String cityandState) {
//		CityandState = cityandState;
//	}
//	
//	@Column(name="ZIPCODE")
//	public String getZipcode() {
//		return zipcode;
//	}
//	public void setZipcode(String zipcode) {
//		this.zipcode = zipcode;
//	}
//	
	
}
