package com.masai.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.dto.UserDto;
import com.masai.dto.UserLoginDto;
import com.masai.exception.UserException;
import com.masai.model.Fir;
import com.masai.model.User;
import com.masai.model.UserLogin;
import com.masai.service.UserService;

@RestController
@RequestMapping("/masaifir/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@Valid @RequestBody UserDto userDto) throws UserException{
		return new ResponseEntity<User>(userService.ragisterUser(userDto), HttpStatus.CREATED);
			
	}
	@PostMapping("/login")
	public ResponseEntity<UserLogin> loginUser(@RequestBody UserLoginDto userLoginDto) throws UserException{
		return new ResponseEntity<UserLogin>(userService.userLogin(userLoginDto),HttpStatus.OK);
	}
	@GetMapping("/fir")
	public ResponseEntity<List<Fir>> getListOfFirPast24(@RequestParam("token") String token) throws UserException{
		return new ResponseEntity<List<Fir>>(userService.seeFirpast24(token),HttpStatus.OK);
	}
	@DeleteMapping("fir/{firId}")
	public ResponseEntity<Fir> withdrawFir(@RequestParam("token") String token ,@PathVariable("firId") Integer firId) throws UserException{
		return new ResponseEntity<Fir>(userService.withdrawfir(token, firId), HttpStatus.OK);
	}
	
}
