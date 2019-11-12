package com.example.rakhaa.models;


import com.google.gson.annotations.SerializedName;


public class Locality{

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private String id;

	@SerializedName("state_id")
	private String stateId;

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

	@Override
 	public String toString(){
		return name;
		}
}