package com.befast.springboot.befastprojeto.venda;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.befast.springboot.befastprojeto.admin.usuario.Usuario;
import com.befast.springboot.befastprojeto.venda.pagamento.FormaPagamento;
import com.befast.springboot.befastprojeto.venda.pagamento.FormaPagamentoService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(value = "/venda")
public class VendaResource {
	@Autowired
	VendaService vendaService;

	@GetMapping(value = "", produces = "application/json")
    public List<Venda> list() throws Exception {
        return vendaService.list();
    }
	
	@PostMapping("/novo")
	public Venda createVenda(@RequestBody Venda venda) throws Exception{
		return vendaService.save(venda);
	}
    
}