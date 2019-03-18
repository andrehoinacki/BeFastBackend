package com.befast.springboot.befastprojeto.venda.boleto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.befast.springboot.befastprojeto.admin.saldo.Saldo;
import com.befast.springboot.befastprojeto.admin.usuario.Usuario;
import com.befast.springboot.befastprojeto.admin.usuario.UsuarioService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(value = "/venda/download")
public class GerarBoletoResource {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/download")
	public void downloadFile(String fileName, HttpServletResponse res) throws Exception {
		res.setHeader("Content-Disposition", "attachment; filename=" + fileName);
		res.getOutputStream().write(contentOf(fileName));
	}
	
	@GetMapping("/{valor}")
	public void download(@PathVariable Float valor, String matricula, HttpServletResponse res) throws IOException, Exception{		
		Usuario user = usuarioService.findByMatricula(matricula);
				
		GerarBoletoUsuario gerarBoleto = new GerarBoletoUsuario();
		String filename = ""; 
		try {
			Saldo saldo = new Saldo();
			saldo.setCredito(valor);
			saldo.setStatus("Pendente");
			List<Saldo> list = new ArrayList<>();
			list.add(saldo);
			user.setSaldo(list);
			
			user = usuarioService.save(user);
			
			filename = gerarBoleto.gerarBoleto(valor, user);
			System.out.println(filename);
		
			res.setHeader("Content-Disposition", "attachment; filename=" + filename);
			res.getOutputStream().write(contentOf(filename));
			
			
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private byte[] contentOf(String fileName) throws Exception {
//		return Files.readAllBytes( Paths.get(getClass().getClassLoader().getResource(fileName).toURI()));
//		Paths.get(fileName, "").toUri();
		return Files.readAllBytes( Paths.get(fileName, ""));
	}
}