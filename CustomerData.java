package com.microservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER_DATA")
public class CustomerData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CUST_ACCT_NUM", nullable = false, updatable = false)
	private Integer id;

	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;

	@Column(name = "LAST_NAME", nullable = false)
	private String lastName;

	@Column(name = "MOBILE_NUMBER", nullable = false)
	private String mobNumber;

	@Column(name = "ADDRESS", nullable = false)
	private String address;

	@Column(name = "BALANCE", nullable = false)
	private Integer balance;

	public CustomerData(String firstName, String lastName, String mobNumber, String address, Integer balance) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobNumber = mobNumber;
		this.address = address;
		this.balance = balance;
	}

	public CustomerData() {
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the mobNumber
	 */
	public String getMobNumber() {
		return mobNumber;
	}

	/**
	 * @param mobNumber the mobNumber to set
	 */
	public void setMobNumber(String mobNumber) {
		this.mobNumber = mobNumber;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the balance
	 */
	public Integer getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(Integer balance) {
		this.balance = balance;
	}

}
