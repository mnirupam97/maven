package model;

public class Users {
private String cid;
private String cname;
private String coursetype;
private String city;
private String fees;
private String pincode;
public Users(String cid, String cname, String coursetype, String city, String fees, String pincode) {
	super();
	this.cid = cid;
	this.cname = cname;
	this.coursetype = coursetype;
	this.city = city;
	this.fees = fees;
	this.pincode = pincode;
}
public Users() {
	super();
}
public String getCid() {
	return cid;
}
public void setCid(String cid) {
	this.cid = cid;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
public String getCoursetype() {
	return coursetype;
}
public void setCoursetype(String coursetype) {
	this.coursetype = coursetype;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getFees() {
	return fees;
}
public void setFees(String fees) {
	this.fees = fees;
}
public String getPincode() {
	return pincode;
}
public void setPincode(String pincode) {
	this.pincode = pincode;
}


}
