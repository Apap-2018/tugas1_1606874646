package com.apap.tugas1.service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.tugas1.model.InstansiModel;
import com.apap.tugas1.model.PegawaiModel;
import com.apap.tugas1.model.JabatanPegawaiModel;
import com.apap.tugas1.repository.JabatanPegawaiDB;
import com.apap.tugas1.repository.PegawaiDB;

@Service
@Transactional
public class PegawaiServiceImpl implements PegawaiService{
	@Autowired
	private PegawaiDB PegawaiDB;
	
	@Autowired
	private JabatanPegawaiDB jabatanPegawaiDb;

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




	@Override
	public List<PegawaiModel> findByTahunMasukAndInstansi(String tahunMasuk, InstansiModel instansi ){
		return PegawaiDB.findByTahunMasukAndInstansi(tahunMasuk, instansi);
}
	@Override
	public void deleteListElement(List<PegawaiModel> listPegawai, int tglLahir) {
		Iterator<PegawaiModel> i = listPegawai.iterator();
		while (i.hasNext()) {
			PegawaiModel peg = i.next();
			if(Integer.parseInt(peg.getTanggalLahirStr()) != tglLahir) {
				i.remove();
			} 
		}
}


//	@Override
//	public PegawaiModel getPegawaiByNip(String nip) {
//		return PegawaiDB.findPegawaiByNip(nip);
//		
//}
//	@Override
//	public List<PegawaiModel> getFilter(String idInstansi, String idJabatan) {
//		List<PegawaiModel> list = new ArrayList<PegawaiModel>();
//		InstansiModel instansi = InstansiDB.getInstansiById(Long.parseLong(idInstansi));
//		List<PegawaiModel> listPegawai = PegawaiDB.findAllByInstansi(instansi);
//		JabatanModel jabatan = JabatanDB.findJabatanById(Long.parseLong(idJabatan));
//		for(PegawaiModel pegawai : listPegawai) {
//			for(JabatanModel jabatanA : pegawai.getJabatanList()) {
//				if(jabatanA.getId() == Long.parseLong(idJabatan)) {
//					list.add(pegawai);
//				}
//			}
//		}
//		return list;
//}

//	@Override
//	public List<PegawaiModel> findByInstansi(InstansiModel instansi) {
//		List<PegawaiModel> listPegawai = pegawaiDb.findAllByInstansi(instansi);
//		return listPegawai;
//}

@Override
public List<PegawaiModel> getFilter(String idInstansi, String idJabatan) {
	// TODO Auto-generated method stub
	return null;
}


@Override
public String makeNip(PegawaiModel Pegawai) {
	// TODO Auto-generated method stub
	String nip = "";
	nip += Pegawai.getInstansi().getId();
	Date date = Pegawai.getTanggalLahir();
	String[] tglLahir = (""+date).split("-");
	for (int i = tglLahir.length-1; i >= 0; i--) {
		int ukuranTgl = tglLahir[i].length();
		nip += tglLahir[i].substring(ukuranTgl-2, ukuranTgl);
	}
	nip += Pegawai.getTahunMasuk();
	
	List<PegawaiModel> listPegawai = PegawaiDB.findByTanggalLahirAndTahunMasukAndInstansi(Pegawai.getTanggalLahir(), Pegawai.getTahunMasuk(), Pegawai.getInstansi());
	
	int banyakPegawai = listPegawai.size();
	
	if (banyakPegawai >= 10) {
		nip += banyakPegawai;
	}
	else {
		nip += "0" + (banyakPegawai+1);
	}
	
	return nip;
}

@Override
public void update(PegawaiModel updatePegawai, PegawaiModel pegawaiSebelumUpdate) {
	// TODO Auto-generated method stub
	pegawaiSebelumUpdate.setInstansi(updatePegawai.getInstansi());
	pegawaiSebelumUpdate.setNama(updatePegawai.getNama());
	pegawaiSebelumUpdate.setNip(updatePegawai.getNip());
	pegawaiSebelumUpdate.setTahunMasuk(updatePegawai.getTahunMasuk());
	pegawaiSebelumUpdate.setTanggalLahir(updatePegawai.getTanggalLahir());
	pegawaiSebelumUpdate.setTempat_lahir(updatePegawai.getTempat_lahir());
	
	
	//update jabatan
	int jumlahList = pegawaiSebelumUpdate.getListJabatanPegawai().size();
	for(int i = 0; i<jumlahList; i++ ) {
		pegawaiSebelumUpdate.getListJabatanPegawai().get(i).setJabatan(updatePegawai.getListJabatanPegawai().get(i).getJabatan());
	}
	
	for (int i = jumlahList; i < updatePegawai.getListJabatanPegawai().size(); i++) {
		updatePegawai.getListJabatanPegawai().get(i).setPegawai(pegawaiSebelumUpdate);
		jabatanPegawaiDb.save(updatePegawai.getListJabatanPegawai().get(i));
	}
	}
	
}



