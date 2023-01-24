package com.masai.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.dto.FirDto;
import com.masai.dto.UserDto;
import com.masai.exception.FirException;
import com.masai.model.Fir;
import com.masai.model.User;
import com.masai.repository.FirRepo;
import com.masai.repository.UserRepo;
import com.masai.service.FirService;
@Service
public class FirServiceImpl implements FirService {
	@Autowired
	private FirRepo firRepo;
	@Autowired
	private UserRepo userRepo;

	@Override
	public Fir ragisterFir(FirDto firDto) throws FirException {
		Fir fir=new Fir();
		fir.setCrimeDetail(firDto.getCrimeDetail());
		fir.setPoliceStation(firDto.getPoliceStation());
		fir.setTimeStamp(firDto.getTimeStamp());
		Fir fir2= firRepo.save(fir);
		List<UserDto> list=firDto.getUsers();
		for(UserDto i:list) {
			User user=new User();
			user.setAddress(i.getAddress());
			user.setAge(i.getAge());
			user.setFirstName(i.getFirstName());
			user.setLastName(i.getLastName());
			user.setGender(i.getGender());
			user.setMobileNumber(i.getMobileNumber());
			user.setPassword(i.getPassword());
			user.setEmail(i.getEmail());
			user.getFirs().add(fir2);
			User user2=userRepo.findByEmail(i.getEmail());
			if(user!=null) {
				user2.getFirs().add(fir2);
				userRepo.save(user2);
			}
			else {
			 	userRepo.save(user);
			}
		}
		return fir2;
	}

}
