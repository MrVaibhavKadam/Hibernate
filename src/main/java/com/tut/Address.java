package com.tut;

import java.beans.Transient;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "student_address")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private int addId;
	
	@Column(length = 50)
	private String street;
	
	@Column(length = 50)
	private String city;
	
	@Column(name = "is_open")
	private boolean isOpen;
	
//	@Transient
//	private double x;
	
	@Column(name = "Add_Date")
	@Temporal(TemporalType.DATE)
	private Date addDate;
	
	@Lob
	private byte[] image;
	
	
	public int getAddId() {
		return addId;
	}
	public void setAddId(int addId) {
		this.addId = addId;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public boolean isOpen() {
		return isOpen;
	}
	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}
//	public double getX() {
//		return x;
//	}
//	public void setX(double x) {
//		this.x = x;
//	}
	public Date getAddDate() {
		return addDate;
	}
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public Address(int addId, String street, String city, boolean isOpen, double x, Date addDate, byte[] image) {
		super();
		this.addId = addId;
		this.street = street;
		this.city = city;
		this.isOpen = isOpen;
		//this.x = x;
		this.addDate = addDate;
		this.image = image;
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

}
