package com.apap.tugas1.repository;

import com.apap.tugas1.model.*;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstansiDB extends JpaRepository<InstansiModel, Long>{

	InstansiModel findInstansiById(long id);

	List<InstansiModel> findAllInstansiByProvinsi(ProvinsiModel provinsi);


}