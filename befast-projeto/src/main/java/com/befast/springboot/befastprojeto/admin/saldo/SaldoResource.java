package com.befast.springboot.befastprojeto.admin.saldo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(value = "/responsavel/saldo")
public class SaldoResource {
	
	@Autowired
	private SaldoService usuarioService;

	@PostMapping("/list")
	public SaldoPageResponse getAll(@RequestBody SaldoFilter filter) throws Exception{
		return usuarioService.list(filter);
	}
}