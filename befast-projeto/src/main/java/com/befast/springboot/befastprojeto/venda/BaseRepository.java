package com.befast.springboot.befastprojeto.venda;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@SuppressWarnings("unused")
@NoRepositoryBean
public interface BaseRepository<T extends Transacao> extends JpaRepository<T, Long> {

}