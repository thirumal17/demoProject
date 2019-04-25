package com.example.demo.exception;

public class UsererrorResponse {
private String msg;
private String respcode;


public UsererrorResponse() {
	
	// TODO Auto-generated constructor stub
}
public UsererrorResponse(String msg, String respcode) {
	super();
	this.msg = msg;
	this.respcode = respcode;
}
public String getMsg() {
	return msg;
}
public void setMsg(String msg) {
	this.msg = msg;
}
public String getRespcode() {
	return respcode;
}
public void setRespcode(String respcode) {
	this.respcode = respcode;
}

}
