package com.apap.tugas1.repository;


import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.apap.tugas1.model.InstansiModel;
import com.apap.tugas1.model.PegawaiModel;

@Repository
public interface PegawaiDB extends JpaRepository<PegawaiModel, Long>{
	List<PegawaiModel> findByInstansi(InstansiModel Instansi);
	
	PegawaiModel findPegawaiByNip(String Nip);
	
	Optional<PegawaiModel> findByNip(String Nip);
	
	List<PegawaiModel> findByInstansiOrderByTanggalLahirAsc(InstansiModel instansi);
	List<PegawaiModel> findByTahunMasukAndInstansi(@Param("tahun_masuk") String tahunMasuk, InstansiModel instansi );
	List<PegawaiModel> findAllByInstansi(InstansiModel instansi);

	List<PegawaiModel> findByTanggalLahirAndTahunMasukAndInstansi(Date tanggal_lahir, String tahunMasuk,
			InstansiModel instansi);

}