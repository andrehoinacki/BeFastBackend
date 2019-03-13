package com.befast.springboot.befastprojeto.admin.saldo;

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
@RequestMapping(value = "/venda/boleto")
public class VendaCreditoResource {
	@Autowired
	VendaCreditoService vendacreditoService;

	@GetMapping(value = "", produces = "application/json")
    public boolean gerarBoleto(@PathVariable float valor) throws Exception {
        return vendacreditoService.gerarBoleto(valor);
    }
		    
}