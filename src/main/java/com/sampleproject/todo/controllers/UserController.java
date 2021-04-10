package com.sampleproject.todo.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sampleproject.todo.models.ListTodo;
import com.sampleproject.todo.models.User;
import com.sampleproject.todo.models.UserAuthentication;
import com.sampleproject.todo.repositories.UserRepo;

import net.minidev.json.JSONValue;

@RestController("/")
@CrossOrigin
public class UserController {
	@Autowired
	private UserRepo repo;
	@RequestMapping(method = RequestMethod.POST, value = "user/new", produces = {org.springframework.http.MediaType.APPLICATION_JSON_VALUE})
	public User addUser(@RequestBody User user)
	{
		try {
		System.out.println(user.toString());
		return repo.save(user);
		}
		catch(Exception e)
		{
			return null;
		}
	}
	@RequestMapping(method = RequestMethod.PUT, value = "user/{id}", produces = {org.springframework.http.MediaType.APPLICATION_JSON_VALUE})
	public User changeUser(@RequestBody ListTodo str,@PathVariable(name = "id") int id)
	{
		User temp=repo.findById(id).get();
		temp.setList(str.getList());
		System.out.println(id+Arrays.toString(str.getList()));
		return repo.save(temp);	
	}
	@RequestMapping(method = RequestMethod.GET, value = "user/{id}"
			+ "", produces = {org.springframework.http.MediaType.APPLICATION_JSON_VALUE})
	public Optional<User> getUser(@PathVariable int id)
	{
		return repo.findById(id);
	}
	/*
	 * @RequestMapping(method = RequestMethod.POST, value = "user/new", produces =
	 * {org.springframework.http.MediaType.APPLICATION_JSON_VALUE}) public User
	 * addUser(@RequestBody User user) { return repo.save(user); }
	 */
	@RequestMapping(method = RequestMethod.POST, value = "user/check"
			+ "", produces = {org.springframework.http.MediaType.APPLICATION_JSON_VALUE})
	public User getUser(@RequestBody UserAuthentication au)
	{
		User temp=repo.findByUserName(au.getUserName());
		if(temp!=null)
		{
				return temp;
		}
		else return null;
	}
}

