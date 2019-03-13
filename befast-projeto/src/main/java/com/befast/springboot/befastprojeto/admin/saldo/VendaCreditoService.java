package com.befast.springboot.befastprojeto.admin.saldo;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
public class VendaCreditoService {
			
	@Transactional
	public boolean gerarBoleto(float valor) throws Exception {
		/**
		 * Valida campos obrigatórios
		 */
		if (valor > 0) {
			throw new Exception("ERROR_CAMPOS_OBRIGATORIOS");
		}
		new GerarBoletoUsuario().gerarBoleto(valor);		
		return true;
	}

}
