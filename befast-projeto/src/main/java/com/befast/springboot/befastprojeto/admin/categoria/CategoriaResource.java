
package com.befast.springboot.befastprojeto.admin.categoria;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(value = "/admin/categoria")
public class CategoriaResource {
	@Autowired
	CategoriaService categoriaService;

	@GetMapping(value = "", produces = "application/json")
    public List<Categoria> list() throws Exception {
        return categoriaService.list();
    }

    @GetMapping(value = "/{nome}", produces = "application/json")
    public Categoria getByNome(@PathVariable String nome) throws Exception {
        return categoriaService.getByNome(nome);
    }
}