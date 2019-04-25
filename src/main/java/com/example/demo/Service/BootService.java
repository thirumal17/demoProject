package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.beans.Users;
import com.example.demo.repo.UserRepo;

@Service
public class BootService {
@Autowired
UserRepo userrepo;

	public List<Users> getUsers() {
	//List<Users> userlist = userrepo.findAll();
		List<Users> userlist = new ArrayList<>();
		userlist.add(new Users(10L,"ram","Sr Nagar"));
		userlist.add(new Users(11L,"sam","Lb Nagar"));
		userlist.add(new Users(12L,"kam","bal Nagar"));
		return userlist;
		
	}
	public List<Users>  usersfromRepo(){
		
		
		
		return userrepo.findAll();
		
	}
	public void saveUser(Users u) {
		userrepo.save(u);
	}
	
}
