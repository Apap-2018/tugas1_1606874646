package com.apap.tugas1.service;

import com.apap.tugas1.repository.*;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.tugas1.model.JabatanModel;

@Service
@Transactional
public class JabatanServiceImpl implements JabatanService{
	@Autowired
	private JabatanDB JabatanDB;
	
	@Override
	public Optional<JabatanModel> getJabatanById(Long id) {
		// TODO Auto-generated method stub
		return JabatanDB.findById(id);
	}

	@Override
	public void addJabatan(JabatanModel jabatan) {
		// TODO Auto-generated method stub
		JabatanDB.save(jabatan);
	}

	@Override
	public void deleteJabatan(JabatanModel jabatan) {
		// TODO Auto-generated method stub
		JabatanDB.delete(jabatan);
	}

	@Override
	public List<JabatanModel> getAll() {
		// TODO Auto-generated method stub
		return JabatanDB.findAll();
	}

	@Override
	public void updateJabatan(JabatanModel jabatan, Long jabatanId) {
		// TODO Auto-generated method stub
		JabatanModel jabatanUpdate = JabatanDB.getOne(jabatanId);
		jabatanUpdate.setNama(jabatan.getNama());
		jabatanUpdate.setGaji_pokok(jabatan.getGaji_pokok());
		jabatanUpdate.setDeskripsi(jabatan.getDeskripsi());
		JabatanDB.save(jabatanUpdate);
}
		
	}

