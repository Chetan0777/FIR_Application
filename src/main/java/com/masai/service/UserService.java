package com.masai.service;

import java.util.List;

import com.masai.dto.UserDto;
import com.masai.dto.UserLoginDto;
import com.masai.exception.UserException;
import com.masai.model.Fir;
import com.masai.model.User;
import com.masai.model.UserLogin;

public interface UserService {
	public User ragisterUser(UserDto userDto) throws UserException;
	public UserLogin userLogin(UserLoginDto userLogginDto) throws UserException;
	public List<Fir> seeFirpast24(String key)throws UserException;
	public Fir withdrawfir(String key,Integer id) throws UserException;
}
