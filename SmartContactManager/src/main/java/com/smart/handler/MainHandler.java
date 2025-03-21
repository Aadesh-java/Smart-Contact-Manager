package com.smart.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smart.dao.userRepository;
import com.smart.entities.User;

import jakarta.validation.Valid;

@Controller
public class MainHandler {

	@Autowired
	private userRepository userRepository;

	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user, BindingResult result,
			@RequestParam(value = "agreement", defaultValue = "false") boolean agreement, Model m) {
		
		if(result.hasErrors()) {
			return "signup";
		}
		
		if (!agreement) {
			System.out.println("Please Accept terms and condition !!");
			m.addAttribute("msg","Please Accept terms and condition !!");
		}else {
	
			System.out.println(agreement);

			user.setRole("Normal User");
			user.setEnable(true);
			
			User save = userRepository.save(user);
			System.out.println(save);
			m.addAttribute("msg1","Registered Successfully !!");
		
		}
		return "signup";
	}
}
