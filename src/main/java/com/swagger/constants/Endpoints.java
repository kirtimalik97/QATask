package com.swagger.constants;

public enum Endpoints {

	
	ADD_UPDATE_PET("/pet"),
	GET_FINDPETBYSTATUS("/pet/findByStatus"),
	OPERATE_PET_BY_ID("/pet/{petId}"),
	UPLOAD_IMAGE("/pet/{petId}/uploadImage"),
	
	GET_STORE_INVENTORY("/store/inventory"),
	ADD_ORDER("/store/order"),
	GET_ORDER_BY_ID("/store/order/{orderId}"),
	DELETE_ORDER("/store/order/{orderId}"),

	CREATE_USER_LIST("/user/createWithList"),
	
	;
	
	public final String path;
	Endpoints(String path){
		this.path = path;
	}
	
	public String getConstant() 
    { 
        return this.path; 
    } 
}
