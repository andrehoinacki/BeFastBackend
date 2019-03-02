
package com.befast.springboot.befastprojeto.admin.restricao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(value = "/admin/restricao")
public class RestricaoResource {
	@Autowired
	RestricaoService restricaoService;

	@GetMapping(value = "", produces = "application/json")
    public List<Restricao> list() throws Exception {
        return restricaoService.list();
    }

    @GetMapping(value = "/{nome}", produces = "application/json")
    public Restricao getByNome(@PathVariable String nome) throws Exception {
        return restricaoService.getByNome(nome);
    }
}