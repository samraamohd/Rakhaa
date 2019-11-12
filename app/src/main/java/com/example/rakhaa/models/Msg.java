package com.example.rakhaa.models;

import com.google.gson.annotations.SerializedName;


public class Msg{

	@SerializedName("national_id")
	private String nationalId;

	@SerializedName("address2")
	private String address2;

	@SerializedName("level")
	private String level;

	@SerializedName("address1")
	private String address1;

	@SerializedName("box")
	private String box;

	@SerializedName("password")
	private String password;

	@SerializedName("locality_id")
	private String localityId;

	@SerializedName("phone")
	private String phone;

	@SerializedName("street")
	private String street;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private String id;

	@SerializedName("state_id")
	private String stateId;

	@SerializedName("email")
	private String email;

	public void setNationalId(String nationalId){
		this.nationalId = nationalId;
	}

	public String getNationalId(){
		return nationalId;
	}

	public void setAddress2(String address2){
		this.address2 = address2;
	}

	public String getAddress2(){
		return address2;
	}

	public void setLevel(String level){
		this.level = level;
	}

	public String getLevel(){
		return level;
	}

	public void setAddress1(String address1){
		this.address1 = address1;
	}

	public String getAddress1(){
		return address1;
	}

	public void setBox(String box){
		this.box = box;
	}

	public String getBox(){
		return box;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setLocalityId(String localityId){
		this.localityId = localityId;
	}

	public String getLocalityId(){
		return localityId;
	}

	public void setPhone(String phone){
		this.phone = phone;
	}

	public String getPhone(){
		return phone;
	}

	public void setStreet(String street){
		this.street = street;
	}

	public String getStreet(){
		return street;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setStateId(String stateId){
		this.stateId = stateId;
	}

	public String getStateId(){
		return stateId;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	@Override
 	public String toString(){
		return 
			"Msg{" + 
			"national_id = '" + nationalId + '\'' + 
			",address2 = '" + address2 + '\'' + 
			",level = '" + level + '\'' + 
			",address1 = '" + address1 + '\'' + 
			",box = '" + box + '\'' + 
			",password = '" + password + '\'' + 
			",locality_id = '" + localityId + '\'' + 
			",phone = '" + phone + '\'' + 
			",street = '" + street + '\'' + 
			",name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			",state_id = '" + stateId + '\'' + 
			",email = '" + email + '\'' + 
			"}";
		}
}