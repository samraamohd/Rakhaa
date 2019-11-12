package com.example.rakhaa.models;


import com.google.gson.annotations.SerializedName;


public class Regist{

	@SerializedName("msg")
	private Msg msg;

	@SerializedName("erorr")
	private boolean erorr;

	public void setMsg(Msg msg){
		this.msg = msg;
	}

	public Msg getMsg(){
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
			"Regist{" + 
			"msg = '" + msg + '\'' + 
			",erorr = '" + erorr + '\'' + 
			"}";
		}
}