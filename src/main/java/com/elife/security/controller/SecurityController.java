package com.elife.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

	@RequestMapping(method = RequestMethod.GET, value = "/security/hellosecurity")
	
//	@GetMapping("/security/hellosecurity")
	public String helloSecurity() {
		return "hello its secured call";
	}
}
