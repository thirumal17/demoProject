package com.example.demo.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="user_table")
public class Users {
@Id
@Column(name="user_id")
private Long id;
@Size(max=10,message="upto 10 characters only")
@Column
private String name;
@Column
private String address;

public Users() {

	// TODO Auto-generated constructor stub
}
public Users(Long id, String name, String address) {
	super();
	this.id = id;
	this.name = name;
	this.address = address;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("Users [id=");
	builder.append(id);
	builder.append(", name=");
	builder.append(name);
	builder.append(", address=");
	builder.append(address);
	builder.append("]");
	return builder.toString();
}

}
