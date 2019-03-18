package com.befast.springboot.befastprojeto.admin.saldo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.befast.springboot.befastprojeto.admin.usuario.Usuario;
import com.befast.springboot.befastprojeto.admin.usuario.UsuarioService;

@Controller
public class AtualizarRetornoController {
	@Autowired
	private UsuarioService usuarioService;
	
	public boolean atualizarRetorno(List<Usuario> usuarios) {
		try {
			Map<Long,String> titulos = recuperarRetorno();
			for (Usuario user : usuarios) {				
				for (Saldo saldo : user.getSaldo()) {
					System.out.println(user.getNome());
					if ("Pendente".equals(saldo.getStatus())) {
						System.out.println("Entrei");
						if (titulos.containsKey(saldo.getId()) ) {
							System.out.println("Entrei AQUI TAMBEM");
							saldo.setStatus("Creditado");
							usuarioService.save(user);
			            }
					}
				}
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	private Map<Long,String> recuperarRetorno() {
		Map<Long,String> titulos = new HashMap<Long,String>();
		try {
			String nome = "C:/temp/RetornoBanco.txt";
			FileReader arq = new FileReader(nome);
			BufferedReader lerArq = new BufferedReader(arq);
			
			String linha = lerArq.readLine(); // lê a primeira linha	
			int cont = 0;
			String[] campos;
			while (linha != null) {
				System.out.println(linha);
				if (cont > 0) {
					campos = linha.split(";");
					if ("2".equals(campos[2])) {
						titulos.put(new Long(campos[1]), campos[2]);
					}
				}

				linha = lerArq.readLine(); // lê da segunda até a última linha
				cont++;
			}

			arq.close();
			lerArq.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return titulos;
	}
}