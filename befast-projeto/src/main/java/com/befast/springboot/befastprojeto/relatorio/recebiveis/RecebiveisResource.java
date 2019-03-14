package com.befast.springboot.befastprojeto.relatorio.recebiveis;

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
@RequestMapping(value = "/relatorio/recebiveis")
public class RecebiveisResource {
	
	@Autowired
	private RecebiveisService recebiveisService;

	@PostMapping("/list")
	public RecebiveisPageResponse getAll(@RequestBody RecebiveisFilter filter) throws Exception{
		return recebiveisService.list(filter);
	}
}