package com.example.rakhaa.models;

import com.google.gson.annotations.SerializedName;

public class Product{

	@SerializedName("image")
	private String image;

	@SerializedName("QR")
	private String qR;

	@SerializedName("price_cost")
	private String priceCost;

	@SerializedName("price_purchase")
	private String pricePurchase;

	@SerializedName("color")
	private String color;

	@SerializedName("en_description")
	private String enDescription;

	@SerializedName("weight")
	private String weight;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("ar_name")
	private String arName;

	@SerializedName("ar_description")
	private String arDescription;

	@SerializedName("size")
	private String size;

	@SerializedName("purchase_account_id")
	private String purchaseAccountId;

	@SerializedName("price_sale")
	private String priceSale;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("sub_category_id")
	private String subCategoryId;

	@SerializedName("sale_account_id")
	private String saleAccountId;

	@SerializedName("en_name")
	private String enName;

	@SerializedName("id")
	private String id;

	@SerializedName("vindor_ids")
	private String vindorIds;

	@SerializedName("country_id")
	private String countryId;

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setQR(String qR){
		this.qR = qR;
	}

	public String getQR(){
		return qR;
	}

	public void setPriceCost(String priceCost){
		this.priceCost = priceCost;
	}

	public String getPriceCost(){
		return priceCost;
	}

	public void setPricePurchase(String pricePurchase){
		this.pricePurchase = pricePurchase;
	}

	public String getPricePurchase(){
		return pricePurchase;
	}

	public void setColor(String color){
		this.color = color;
	}

	public String getColor(){
		return color;
	}

	public void setEnDescription(String enDescription){
		this.enDescription = enDescription;
	}

	public String getEnDescription(){
		return enDescription;
	}

	public void setWeight(String weight){
		this.weight = weight;
	}

	public String getWeight(){
		return weight;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setArName(String arName){
		this.arName = arName;
	}

	public String getArName(){
		return arName;
	}

	public void setArDescription(String arDescription){
		this.arDescription = arDescription;
	}

	public String getArDescription(){
		return arDescription;
	}

	public void setSize(String size){
		this.size = size;
	}

	public String getSize(){
		return size;
	}

	public void setPurchaseAccountId(String purchaseAccountId){
		this.purchaseAccountId = purchaseAccountId;
	}

	public String getPurchaseAccountId(){
		return purchaseAccountId;
	}

	public void setPriceSale(String priceSale){
		this.priceSale = priceSale;
	}

	public String getPriceSale(){
		return priceSale;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setSubCategoryId(String subCategoryId){
		this.subCategoryId = subCategoryId;
	}

	public String getSubCategoryId(){
		return subCategoryId;
	}

	public void setSaleAccountId(String saleAccountId){
		this.saleAccountId = saleAccountId;
	}

	public String getSaleAccountId(){
		return saleAccountId;
	}

	public void setEnName(String enName){
		this.enName = enName;
	}

	public String getEnName(){
		return enName;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setVindorIds(String vindorIds){
		this.vindorIds = vindorIds;
	}

	public String getVindorIds(){
		return vindorIds;
	}

	public void setCountryId(String countryId){
		this.countryId = countryId;
	}

	public String getCountryId(){
		return countryId;
	}

	@Override
 	public String toString(){
		return 
			"Product{" + 
			"image = '" + image + '\'' + 
			",qR = '" + qR + '\'' + 
			",price_cost = '" + priceCost + '\'' + 
			",price_purchase = '" + pricePurchase + '\'' + 
			",color = '" + color + '\'' + 
			",en_description = '" + enDescription + '\'' + 
			",weight = '" + weight + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",ar_name = '" + arName + '\'' + 
			",ar_description = '" + arDescription + '\'' + 
			",size = '" + size + '\'' + 
			",purchase_account_id = '" + purchaseAccountId + '\'' + 
			",price_sale = '" + priceSale + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",sub_category_id = '" + subCategoryId + '\'' + 
			",sale_account_id = '" + saleAccountId + '\'' + 
			",en_name = '" + enName + '\'' + 
			",id = '" + id + '\'' + 
			",vindor_ids = '" + vindorIds + '\'' + 
			",country_id = '" + countryId + '\'' + 
			"}";
		}
}