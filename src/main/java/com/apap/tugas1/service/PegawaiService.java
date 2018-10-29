package com.apap.tugas1.service;

import java.util.List;
import java.util.Optional;

import com.apap.tugas1.model.InstansiModel;
import com.apap.tugas1.model.PegawaiModel;

public interface PegawaiService {
	Optional<PegawaiModel> getPegawaiByNIP(Long NIP);
	void addPegawai(PegawaiModel Pegawai);
	PegawaiModel pegawaiTertua(InstansiModel instansi);
	PegawaiModel pegawaiTermuda(InstansiModel instansi);
	List<PegawaiModel> findByTahunMasukAndInstansi(String tahunMasuk, InstansiModel instansi);
	void deleteListElement(List<PegawaiModel> listPegawai, int tahunLahir);
	List<PegawaiModel> getFilter(String idInstansi, String idJabatan);


	String makeNip(PegawaiModel pegawai);

	void update(PegawaiModel pegawai, PegawaiModel pegawaiSebelumUpdate);	
}