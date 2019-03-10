package com.befast.springboot.befastprojeto.venda;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends BaseRepository<Transacao>{
	
	@Query("SELECT v FROM Venda v ORDER BY v.dataVenda")
	List<Venda> list();

}
