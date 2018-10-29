package com.apap.tugas1.service;

import com.apap.tugas1.model.InstansiModel;
import com.apap.tugas1.model.PegawaiModel;
import com.apap.tugas1.model.ProvinsiModel;
import com.apap.tugas1.repository.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class InstansiServiceImpl implements InstansiService{
	@Autowired
	private InstansiDB InstansiDB;

	@Override
	public Optional<InstansiModel> getIntansiById(Long id) {
		// TODO Auto-generated method stub
		return InstansiDB.findById(id);
	}

	@Override
	public List<InstansiModel> getAllInstansi() {
		// TODO Auto-generated method stub
		return InstansiDB.findAll();
	}

	@Override
	public InstansiModel findById(long parseLong) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<InstansiModel> getAllInstansiByProvinsi(ProvinsiModel provinsi) {
		// TODO Auto-generated method stub
		return InstansiDB.findAllInstansiByProvinsi(provinsi);
}
	
	

}