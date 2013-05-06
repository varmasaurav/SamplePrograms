package com.t51.base.controllers;

import java.net.UnknownHostException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.tamaram.domain.user.User;


@Controller
 class HelloWorldController {
	
	@RequestMapping(value="home")
	public String home(){
		
		return "home";
	}
		
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String doSomething(Model model) throws UnknownHostException{
		MongoClient mongo = new MongoClient();
		DB db = mongo.getDB("doctors");
		DBCollection collection = db.getCollection("ddoctors");
		
		
		DBObject name = collection.findOne();
		
		model.addAttribute("name", name.get("full_name"));
		return "loggedIn/profile";
	}
	
	@RequestMapping(value="signup", method=RequestMethod.POST)
	public String doSomethingAgain(@ModelAttribute("user") User user, BindingResult result, Model model) throws UnknownHostException{
		MongoClient mongo = new MongoClient();
		DB db = mongo.getDB("doctors");
		DBCollection collection = db.getCollection("ddoctors");
		
		DBObject a_duty_doctor = new BasicDBObject("_id",user.getEmail()).append("full_name",user.getFullname())
																		.append("email", user.getEmail())
																		.append("pwd", user.getPassword()); 
		collection.insert(a_duty_doctor);
		
		String name = user.getEmail();
		
		model.addAttribute("name", name);
		return "loggedIn/profile";
	}
	@RequestMapping(value="settings")
	public String showSettings(){
		
		return "loggedIn/settings";
	}
	
	@RequestMapping(value="resume")
	public String showResume(){
		
		return "loggedIn/resume";
	}
	
	@RequestMapping(value="profile")
	public String showProfile(){
		
		return "loggedIn/profile";
	}
}


