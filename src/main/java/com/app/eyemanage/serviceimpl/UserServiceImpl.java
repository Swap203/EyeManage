package com.app.eyemanage.serviceimpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.Transactional;
import com.app.eyemanage.controller.UserController;
import com.app.eyemanage.model.ForgotPassword;
import com.app.eyemanage.model.SecQuestions;
import com.app.eyemanage.model.UserLogin;
import com.app.eyemanage.pojo.UserPOJO;
import com.app.eyemanage.service.SecQuestionService;
import com.app.eyemanage.service.UserService;

@ComponentScan
@Service
@Transactional
public class UserServiceImpl {
	
	private static final Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SecQuestionService passwordService;
	
	public UserServiceImpl(UserService userService) {
		this.userService = userService;
	}

	public UserServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Transactional
	public boolean add(UserPOJO userDetails) {
		logger.info("User Service Impl , User ::: " + userDetails.toString());
		UserPOJO demoUser	=	this.userService.save(userDetails);
		logger.info("Returned Object::: " + demoUser.toString());
		if( demoUser.getUserId() != 0){
			return true;
		}
		else
			return false;
		
	}
	
	public boolean forgotPassCheck(ForgotPassword forgotUser) {
		logger.info("forgotPassCheck method");
		if( forgotUser.getNewPassword().toString().equals(forgotUser.getConfirmPassword().toString()))
			return true;
		else
			return false;
	}
}