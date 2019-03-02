package com.befast.springboot.befastprojeto.admin.produto;

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
@RequestMapping(value = "/admin/produto")
public class ProdutoResource {
	
	@Autowired
	private ProdutoService produtoService;

	@PostMapping("/list")
	public ProdutoPageResponse getAll(@RequestBody ProdutoFilter filter) throws Exception{
		return produtoService.list(filter);
	}
	
	@PostMapping("/novo")
	public Produto createProduto(@RequestBody Produto produto) throws Exception{
		return produtoService.save(produto);
	}

	@GetMapping("/{id}")
	public Produto getProduto(@PathVariable long id){
		return produtoService.findById(id);
	}

	@PutMapping("/edit")
	public Produto updateProduto(@RequestBody Produto produto) throws Exception{
		return produtoService.save(produto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable long id){
		
		produtoService.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
}