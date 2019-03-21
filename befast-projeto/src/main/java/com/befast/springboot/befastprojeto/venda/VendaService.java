package com.befast.springboot.befastprojeto.venda;

import java.util.List;

import javax.transaction.Transactional;

import com.befast.springboot.befastprojeto.admin.produto.ProdutoRepository;
import com.befast.springboot.befastprojeto.admin.saldo.Saldo;
import com.befast.springboot.befastprojeto.admin.usuario.Usuario;
import com.befast.springboot.befastprojeto.admin.usuario.UsuarioRepository;
import com.befast.springboot.befastprojeto.venda.pagamento.FormaPagamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class VendaService {
	
	@Autowired
	private VendaRepository vendaRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private ProdutoRepository produtoRepository;

	@Cacheable("list-venda")
	public List<Venda> list(){
		return vendaRepository.list();
	}
	
	@Transactional
	public Venda save(Venda venda) throws Exception {
		/**
		 * Valida campos obrigatórios
		 */
		if (venda.getCliente() == null || venda.getFuncionario() == null ) {
			throw new Exception("ERROR_CAMPOS_OBRIGATORIOS");
		}
		Venda vendaRetorno = vendaRepository.save(venda);
		//ATUALIZA SALDO USUÁRIO
		usuarioRepository.save(venda.getCliente());

		//ATUALIZA PRODUTO
		for (ItemVenda vi : venda.getItens()) {
			produtoRepository.save(vi.getProduto());
		}

		return vendaRetorno;
	}

}
