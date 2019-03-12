package com.befast.springboot.befastprojeto.relatorio.vendas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(value = "/relatorio/vendas")
public class VendasResource {
	
	@Autowired
	private VendasService vendasService;

	@PostMapping("/list")
	public VendasPageResponse getAll(@RequestBody VendasFilter filter) throws Exception{
		return vendasService.list(filter);
	}
}