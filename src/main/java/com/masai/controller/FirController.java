package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.dto.FirDto;
import com.masai.exception.FirException;
import com.masai.model.Fir;
import com.masai.service.FirService;

@RestController
public class FirController {
	
	@Autowired
	private FirService firService;
	@PostMapping("/masaifir/user/fir")
	public ResponseEntity<Fir> ragisterFirWith(@RequestBody FirDto firDto) throws FirException{
		return new ResponseEntity<Fir>(firService.ragisterFir(firDto), HttpStatus.CREATED);
	}

}
