package com.apap.tugas1.model;

import java.io.Serializable;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="pegawai")
public class PegawaiModel implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNip() {
		return nip;
	}

	public void setNip(String nip) {
		nip= nip;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getTempat_lahir() {
		return tempat_lahir;
	}

	public void setTempat_lahir(String tempat_lahir) {
		this.tempat_lahir = tempat_lahir;
	}

	public Date getTanggalLahir() {
		return tanggalLahir;
	}

	public void setTanggalLahir(Date tanggalLahir) {
		this.tanggalLahir = tanggalLahir;
	}

	public String getTahunMasuk() {
		return tahunMasuk;
	}

	public void setTahunMasuk(String tahun_masuk) {
		this.tahunMasuk = tahunMasuk;
	}

	public InstansiModel getInstansi() {
		return instansi;
	}

	public void setInstansi(InstansiModel instansi) {
		this.instansi = instansi;
	}

	@NotNull
	@Size(max=255)
	@Column(name="nip",nullable=false, unique=true)
	private String nip;
	
	@NotNull
	@Size(max=255)
	@Column(name="nama",nullable=false)
	private String nama;
	
	@NotNull
	@Size(max=255)
	@Column(name="tempat_lahir",nullable=false)
	private String tempat_lahir;
	
	@NotNull
	@Column(name="tanggalLahir",nullable=false)
	private Date tanggalLahir;
	
	@NotNull
	@Size(max=255)
	@Column(name="tahunMasuk",nullable=false)
	private String tahunMasuk;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_instansi",referencedColumnName="id", nullable=false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	@JsonIgnore
	private InstansiModel instansi;
	
//	@OneToMany(mappedBy="pegawai", fetch=FetchType.LAZY)
//	@OnDelete(action= OnDeleteAction.CASCADE)
//	@JsonIgnore
//	private List<JabatanModel> jabatanList;
	
	@OneToMany(mappedBy = "pegawai", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private List<JabatanPegawaiModel> listJabatanPegawai;
	
//	public void setJabatanList(List<JabatanModel> jabatanList) {
//		// TODO Auto-generated method stub
//		this.jabatanList = jabatanList;
//	}
//	public List<JabatanModel> getJabatanList() {
//		return jabatanList;
//
//}


	public String getTanggalLahirStr() {
		DateFormat dateFormat = new SimpleDateFormat("ddMMyy");
		String tglLahir = dateFormat.format(tanggalLahir);
		return tglLahir;
}
	
	public String getTahunLahir() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy");
		String tahunLahir = dateFormat.format(tanggalLahir);
		return tahunLahir;
}

	public List<JabatanPegawaiModel> getListJabatanPegawai() {
		return listJabatanPegawai;
	}

	public void setListJabatanPegawai(List<JabatanPegawaiModel> listJabatanPegawai) {
		this.listJabatanPegawai = listJabatanPegawai;
}
}