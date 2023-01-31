package com.zohocrm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrm.util.EmailService;

@Controller
public class EmailController {

	//LET'S CREATE A BEAN 
	@Autowired
	private EmailService emailService;
	
	
	//LET'S BUILD A HANDLER METHOD
	
	// some people may write this way
		@RequestMapping(value="/composeEmail", method = RequestMethod.POST)
		//@RequestMapping("/composeEmail")
	public String composeEmail(@RequestParam("email")String email,Model model) { // we are going to read --> email
		//System.out.println(email);
			
		model.addAttribute("email",email);	
		return "compose_email"; // we will build this jsp page	
	}
	
		//BUILD ONE METHOD FOR SEND EMAIL
	@RequestMapping("/sendEmail")          // we will start reading "to" field , then read Sub,then read msg
	public String sendEmail(@RequestParam("to")String to,@RequestParam("sub")String sub,@RequestParam("msg")String msg,Model model) { 
		emailService.sendEmail(to, sub, msg);
		model.addAttribute("msg", "Email Sent!!");  // displaying one message Email Sent
		// take this msg go to compose_email & display this --> ${msg}
		return "compose_email"; // once done we will remain on the same page
	}
		
		
}
