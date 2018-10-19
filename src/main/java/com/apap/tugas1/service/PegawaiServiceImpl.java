package com.apap.tugas1.service;

import com.apap.tugas1.model.InstansiModel;
import com.apap.tugas1.model.PegawaiModel;
import com.apap.tugas1.repository.*;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PegawaiServiceImpl implements PegawaiService{
	@Autowired
	private PegawaiDB PegawaiDB;

	@Override
	public Optional<PegawaiModel> getPegawaiByNIP(Long NIP) {
		// TODO Auto-generated method stub
		return PegawaiDB.findByNip(String.valueOf(NIP));
	}

	@Override
	public void addPegawai(PegawaiModel Pegawai) {
		// TODO Auto-generated method stub
		PegawaiDB.save(Pegawai);
	}

	@Override
	public PegawaiModel pegawaiTertua(InstansiModel instansi) {
		// TODO Auto-generated method stub
		List<PegawaiModel> listPegawai = PegawaiDB.findByInstansiOrderByTanggalLahirAsc(instansi);
		return listPegawai.get(0);
	}

	@Override
	public PegawaiModel pegawaiTermuda(InstansiModel instansi) {
		// TODO Auto-generated method stub
		List<PegawaiModel> listPegawai = PegawaiDB
				.findByInstansiOrderByTanggalLahirAsc(instansi);
		return listPegawai.get(listPegawai.size()-1);
	}

}
