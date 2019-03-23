package com.befast.springboot.befastprojeto.admin.filial;
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
@RequestMapping(value = "/admin/filial")
public class FilialResource {
	
	@Autowired
	private FilialService filialService;

	@PostMapping("/list")
	public List<Filial> getAll(String aux) throws Exception{
		return filialService.list();
	}
		
	@PostMapping("/novo")
	public Filial createUsuario(@RequestBody Filial filial) throws Exception{
		return filialService.save(filial);
	}

	@GetMapping("/{id}")
	public Filial getUsuario(@PathVariable long id){
		return filialService.findById(id);
	}
	
	@PutMapping("/edit")
	public Filial updateUsuario(@RequestBody Filial filial) throws Exception{
		return filialService.save(filial);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable long id){
		
		filialService.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
}