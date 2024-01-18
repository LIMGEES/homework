package com.mysite.sbb;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HelloController {
	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
		 
		return "hello Spring Boot Board";
	}
	
}
