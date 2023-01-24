package com.masai.service;

import com.masai.dto.FirDto;
import com.masai.exception.FirException;
import com.masai.model.Fir;

public interface FirService {
	public Fir ragisterFir(FirDto firDto) throws FirException;

}
