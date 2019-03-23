package com.befast.springboot.befastprojeto.admin.filial;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilialService {

	@Autowired
	private FilialRepository filialRepository;

	public List<Filial> list() {		
		return filialRepository.list();		
	}

	@Transactional
	public Filial save(Filial filial) throws Exception {		
		return filialRepository.save(filial);
	}
	
	public Filial findById(long id) {
		return filialRepository.findFilialById(id);
	}

	public void deleteById(long id) {
		filialRepository.deleteById(id);
	}

}