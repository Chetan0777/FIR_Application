package com.masai.serviceimpl;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.dto.UserDto;
import com.masai.dto.UserLoginDto;
import com.masai.exception.UserException;
import com.masai.model.Fir;
import com.masai.model.User;
import com.masai.model.UserLogin;
import com.masai.repository.FirRepo;
import com.masai.repository.UserLoginRepo;
import com.masai.repository.UserRepo;
import com.masai.service.UserService;

import net.bytebuddy.utility.RandomString;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private FirRepo firRepo;
	@Autowired
	private UserLoginRepo userLoginRepo;


	@Override
	public User ragisterUser(UserDto userDto) throws UserException {
		User user=new User();
		user.setAddress(userDto.getAddress());
		user.setAge(userDto.getAge());
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setGender(userDto.getGender());
		user.setMobileNumber(userDto.getMobileNumber());
		user.setPassword(userDto.getPassword());
		user.setEmail(userDto.getEmail());
		
		return userRepo.save(user);
	}

	@Override
	public UserLogin userLogin(UserLoginDto userLogginDto) throws UserException {
		User user= userRepo.findByEmailAndPassword(userLogginDto.getEmail(),userLogginDto.getPassword());
		if(user!=null) {
			UserLogin userLoggin=new UserLogin();
			userLoggin.setUserId(user.getUserId());
			userLoggin.setKey(RandomString.make(6));
			userLoggin.setLocalDate(LocalDate.now());
			return userLoginRepo.save(userLoggin);
		}
		throw new UserException("please Enter Valid key");
	}

	@Override
	public List<Fir> seeFirpast24(String key) throws UserException {
			UserLogin userLoggin=this.checkPermisson(key);
			if(userLoggin!=null) {
				
				Optional<User> useroptional=userRepo.findById(userLoggin.getUserId());
				List<Fir> list=useroptional.get().getFirs();
				return list;
			}
			throw new UserException("Token Not valid");
	}

	@Override
	public Fir withdrawfir(String key, Integer fid) throws UserException {
		UserLogin userLoggin=this.checkPermisson(key);
		if(userLoggin!=null) {
			Optional<User> useroptional=userRepo.findById(userLoggin.getUserId());
			List<Fir> list=useroptional.get().getFirs();
			int c=0;
			for(Fir i:list) {
				if(i.getFirId()==fid) {
					LocalDateTime dateTime=i.getTimeStamp();
					LocalDateTime localDateTime=LocalDateTime.now();
					Duration duration=Duration.between(dateTime, localDateTime);
					int value=(int) (duration.getSeconds()/3600);
					if(value<=24) {
						list.remove(c);
						firRepo.delete(i);
						userRepo.save(useroptional.get());
						return i;
					}
								
					
				}
				c++;
			}
			throw new UserException("Not found");

		}
		throw new UserException("Token Not valid");
	}
	
	public UserLogin checkPermisson(String key) {
		return userLoginRepo.findByKey(key);
	}

}
