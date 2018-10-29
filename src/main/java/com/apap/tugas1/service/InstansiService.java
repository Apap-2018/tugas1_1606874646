package com.apap.tugas1.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import com.apap.tugas1.model.InstansiModel;
import com.apap.tugas1.model.PegawaiModel;
import com.apap.tugas1.model.ProvinsiModel;

public interface InstansiService {
	Optional<InstansiModel> getIntansiById(Long id);
	
	List<InstansiModel> getAllInstansi();

	InstansiModel findById(long parseLong);

	List<InstansiModel> getAllInstansiByProvinsi(ProvinsiModel provinsi);

}