package com.tambaram.service.user;

import java.net.UnknownHostException;

import org.springframework.stereotype.Service;
import org.springframework.webflow.execution.Action;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.tamaram.domain.user.User;

@Service
public class UserOperations  {
	
	private User newUser = new User();
	
	
	// Operations done with User

}
