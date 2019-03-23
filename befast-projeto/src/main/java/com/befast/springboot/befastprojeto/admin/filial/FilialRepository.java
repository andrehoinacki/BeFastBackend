package com.befast.springboot.befastprojeto.admin.filial;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FilialRepository extends JpaRepository<Filial, Long>{		
	@Query("SELECT u FROM Filial u")
	List<Filial> list();
	
	@Query("SELECT u FROM Filial u  WHERE u.id=:#{#id} ")
	Filial findFilialById(long id);	
}