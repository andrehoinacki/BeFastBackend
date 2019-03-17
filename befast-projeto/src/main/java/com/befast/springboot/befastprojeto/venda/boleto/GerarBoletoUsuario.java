package com.befast.springboot.befastprojeto.venda.boleto;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jrimum.bopepo.BancosSuportados;
import org.jrimum.bopepo.Boleto;
import org.jrimum.bopepo.view.BoletoViewer;
import org.jrimum.domkee.comum.pessoa.endereco.CEP;
import org.jrimum.domkee.comum.pessoa.endereco.Endereco;
import org.jrimum.domkee.comum.pessoa.endereco.UnidadeFederativa;
import org.jrimum.domkee.financeiro.banco.febraban.Agencia;
import org.jrimum.domkee.financeiro.banco.febraban.Carteira;
import org.jrimum.domkee.financeiro.banco.febraban.Cedente;
import org.jrimum.domkee.financeiro.banco.febraban.ContaBancaria;
import org.jrimum.domkee.financeiro.banco.febraban.NumeroDaConta;
import org.jrimum.domkee.financeiro.banco.febraban.Sacado;
import org.jrimum.domkee.financeiro.banco.febraban.SacadorAvalista;
import org.jrimum.domkee.financeiro.banco.febraban.TipoDeTitulo;
import org.jrimum.domkee.financeiro.banco.febraban.Titulo;
import org.jrimum.domkee.financeiro.banco.febraban.Titulo.Aceite;

import com.befast.springboot.befastprojeto.admin.usuario.Usuario;

/**
 * <p>
 * Exemplo de código para geração de um boleto simples.
 * </p>
 * <p>
 * Utiliza o Banco Bradesco como exemplo, já que possui um implementação
 * simples.
 * </p>
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L</a>
 * @author <a href="mailto:misaelbarreto@gmail.com">Misael Barreto</a>
 * @author <a href="mailto:romulomail@gmail.com">Rômulo Augusto</a>
 * 
 * @since 0.2
 * 
 * @version 0.2
 */
public class GerarBoletoUsuario {

	public String gerarBoleto(float valor, Usuario user) {

		/*
		 * INFORMANDO DADOS SOBRE O CEDENTE.
		 */
		Cedente cedente = new Cedente("Projeto BeFast", "00.000.208/0001-00");

		/*
		 * INFORMANDO DADOS SOBRE O SACADO.
		 */
		Sacado sacado = new Sacado(user.getNome(), "222.222.222-22");

		// Informando o endereço do sacado.
		Endereco enderecoSac = new Endereco();
		enderecoSac.setUF(UnidadeFederativa.PR);
		enderecoSac.setLocalidade("Curitiba");
		enderecoSac.setCep(new CEP("81315-000"));
		enderecoSac.setBairro("CIC");
		enderecoSac.setLogradouro("Rua poeta dos programas");
		enderecoSac.setNumero("1");
		sacado.addEndereco(enderecoSac);

		/*
		 * INFORMANDO DADOS SOBRE O SACADOR AVALISTA.
		 */
		SacadorAvalista sacadorAvalista = new SacadorAvalista("BeFast LTDA", "00.000.000/0001-91");

		// Informando o endereço do sacador avalista.
		Endereco enderecoSacAval = new Endereco();
		enderecoSacAval.setUF(UnidadeFederativa.PR);
		enderecoSacAval.setLocalidade("Curitiba");
		enderecoSacAval.setCep(new CEP("81315-000"));
		enderecoSacAval.setBairro("Centro");
		enderecoSacAval.setLogradouro("Rua Eternamente Principal");
		enderecoSacAval.setNumero("001");
		sacadorAvalista.addEndereco(enderecoSacAval);

		/*
		 * INFORMANDO OS DADOS SOBRE O TÍTULO.
		 */

		// Informando dados sobre a conta bancária do título.
		ContaBancaria contaBancaria = new ContaBancaria(BancosSuportados.BANCO_BRADESCO.create());
		contaBancaria.setNumeroDaConta(new NumeroDaConta(123456, "0"));
		contaBancaria.setCarteira(new Carteira(30));
		contaBancaria.setAgencia(new Agencia(1234, "1"));

		Titulo titulo = new Titulo(contaBancaria, sacado, cedente, sacadorAvalista);
		titulo.setNumeroDoDocumento("123456");
		titulo.setNossoNumero("99345678912");
		titulo.setDigitoDoNossoNumero("5");
		titulo.setValor(BigDecimal.valueOf(valor));
		titulo.setDataDoDocumento(new Date());
		titulo.setDataDoVencimento(new Date());
		titulo.setTipoDeDocumento(TipoDeTitulo.DM_DUPLICATA_MERCANTIL);
		titulo.setAceite(Aceite.A);
		titulo.setDesconto(new BigDecimal(0.05));
		titulo.setDeducao(BigDecimal.ZERO);
		titulo.setMora(BigDecimal.ZERO);
		titulo.setAcrecimo(BigDecimal.ZERO);
		titulo.setValorCobrado(BigDecimal.ZERO);

		/*
		 * INFORMANDO OS DADOS SOBRE O BOLETO.
		 */
		Boleto boleto = new Boleto(titulo);

		boleto.setLocalPagamento("Pagável preferencialmente em agências Bradesco ou em " + "qualquer Banco até o Vencimento.");
		boleto.setInstrucaoAoSacado(
				"Inserir texto aqui!");		
		boleto.setInstrucao4("PARA PAGAMENTO até 30 após vencimentos COBRAR O VALOR DE: R$ 01,00");
		
		String dataFormatada = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
		
		String nomeBoleto = user.getMatricula() + "_" + dataFormatada + ".pdf";

		/*
		 * GERANDO O BOLETO BANCÁRIO.
		 */
		// Instanciando um objeto "BoletoViewer", classe responsável pela
		// geração do boleto bancário.
		BoletoViewer boletoViewer = new BoletoViewer(boleto);
	
		String diretorio = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator;
//		String diretorio = "C:/temp/";
		
		File arquivoPdf = boletoViewer.getPdfAsFile(diretorio + nomeBoleto);

		return diretorio+nomeBoleto;
	}

	/**
	 * Exibe o arquivo na tela.
	 * 
	 * @param arquivoBoleto
	 */
	private static void mostreBoletoNaTela(File arquivoBoleto) {

		java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

		try {
			desktop.open(arquivoBoleto);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
