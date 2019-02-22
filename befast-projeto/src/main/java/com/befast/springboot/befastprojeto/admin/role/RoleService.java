package com.befast.springboot.befastprojeto.admin.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


@Service
public class RoleService {
	
	@Autowired
	private RoleRepository roleRepository;

	@Cacheable("list-role")
	public List<Role> list(){
		return roleRepository.list();
	}

	public Role getByNome(String nome) {
		return roleRepository.getByNome(nome);
	}
	
}