package com.pachanga.appsecurity.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pachanga.appsecurity.cross.JwtTokenCross;
import com.pachanga.appsecurity.dto.AuthRequest;
import com.pachanga.appsecurity.dto.AuthResponse;
import com.pachanga.appsecurity.model.AccessModel;
import com.pachanga.appsecurity.services.AuthService;

@RestController
@RequestMapping("api/auth")
public class AuthController {

	@Autowired
	AuthService authService;
	
	@Autowired
	private JwtTokenCross tokenCross;
	
	Logger logger = LoggerFactory.getLogger(AuthController.class);
	
	@GetMapping
	public List<AccessModel> get() {
		return authService.getAccess();
	}
	
	@PostMapping("/authentication")
	public ResponseEntity<?> post(@RequestBody AuthRequest request) throws Exception {
		String username = request.getUserName();
		String password = request.getPassword();
		if ((null != username && !username.isEmpty()) && (null != password && !password.isEmpty())) {
			var token = tokenCross.generateToken(request);
			AuthResponse response = new AuthResponse(token, username, "1d");
			return ResponseEntity.ok(response);
		} else {
			return (ResponseEntity<?>) ResponseEntity.badRequest();
		}
	}
}
