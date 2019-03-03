
package com.befast.springboot.befastprojeto.venda.pagamento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(value = "/venda/pagamento")
public class FormaPagamentoResource {
	@Autowired
	FormaPagamentoService formaPagamentoService;

	@GetMapping(value = "", produces = "application/json")
    public List<FormaPagamento> list() throws Exception {
        return formaPagamentoService.list();
    }

    @GetMapping(value = "/{nome}", produces = "application/json")
    public FormaPagamento getByNome(@PathVariable String nome) throws Exception {
        return formaPagamentoService.getByNome(nome);
    }
}