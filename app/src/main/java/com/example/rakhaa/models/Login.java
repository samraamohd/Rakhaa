package com.example.rakhaa.models;

import com.google.gson.annotations.SerializedName;

public class Login{

	@SerializedName("msg")
	private String msg;

	@SerializedName("erorr")
	private boolean erorr;

	public void setMsg(String msg){
		this.msg = msg;
	}

	public String getMsg(){
		return msg;
	}

	public void setErorr(boolean erorr){
		this.erorr = erorr;
	}

	public boolean isErorr(){
		return erorr;
	}

	@Override
 	public String toString(){
		return 
			"Login{" + 
			"msg = '" + msg + '\'' + 
			",erorr = '" + erorr + '\'' + 
			"}";
		}
}