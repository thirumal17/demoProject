package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.BootService;
import com.example.demo.beans.Users;
import com.example.demo.exception.UserNotFound;
import com.example.demo.exception.UsererrorResponse;



@RestController
public class BootRestController {
	@Autowired
	BootService bootsvc;

	private List<Users> userlist;

	//through post construct data will loaded at once
	@PostConstruct
	public void findallusers() {
		userlist = bootsvc.getUsers();
	}
	@ExceptionHandler
	public ResponseEntity<UsererrorResponse> catcherror(UserNotFound unf){
		UsererrorResponse ur = new UsererrorResponse();
		ur.setMsg(unf.getMessage());
		ur.setRespcode("105");
		return new ResponseEntity<UsererrorResponse>(ur, HttpStatus.NOT_FOUND);
		
	}


	@GetMapping(value = "/get/{id}", produces = "application/json")
	public Users getmsg(@PathVariable("id") Long id) {
		List<Long> ids = new ArrayList<Long>();
		for(Users u: userlist) {
		ids.add(u.getId());
	}
		if(! ids.contains(id)) {
			throw new UserNotFound("user not found on id: "+id);
		}
		Users u = null;
		for (Users u1 : userlist) {
			if (id == u1.getId()) {
				System.out.println(u1);
				u = u1;
			}

		}

		return u;

	}

	@PostMapping(value = "/nu", produces = "application/json")
	public ResponseEntity<Users> createUser(@Valid @RequestBody Users user) {
		
		userlist.add(user);
		return new ResponseEntity<Users>(user, HttpStatus.CREATED);

	}

	@GetMapping(value = "/getall", produces = "application/json")
	public List<Users> getall() {
		
		return userlist;

	}
}
