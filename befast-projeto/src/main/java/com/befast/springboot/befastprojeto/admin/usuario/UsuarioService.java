package com.befast.springboot.befastprojeto.admin.usuario;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public UsuarioPageResponse list(UsuarioFilter filter) {
		PageRequest pageRequest = PageRequest.of(filter.getPageNumber() - 1, filter.getPageSize(),
				new Sort(Sort.Direction.ASC, "nome"));
		Page<Usuario> page = usuarioRepository.list(pageRequest, filter);

		UsuarioPageResponse pageResponse = new UsuarioPageResponse();
		pageResponse.setList(page.getContent());
		pageResponse.setTotalElements(page.getTotalElements());
		pageResponse.setTotalPages(page.getTotalPages());

		return pageResponse;
	}
	
	public List<Usuario> listVinculo(Long id) {
		
		return usuarioRepository.listVinculo(id);		
	}

	@Transactional
	public Usuario save(Usuario usuario) throws Exception {
		/**
		 * Valida campos obrigatórios
		 */
		if (usuario.getUsername() == null || usuario.getNome() == null || usuario.getPassword() == null
				|| usuario.getRole() == null) {
			throw new Exception("ERROR_CAMPOS_OBRIGATORIOS");
		}

		/**
		 * Verifica se já não existe usuario com mesmo username
		 */
		if (null == usuario.getId()) {
			Usuario unique = this.verifyUnique(usuario);
			if (unique != null && !unique.getId().equals(usuario.getId())) {
				throw new Exception("ERROR_REGISTRO_DUPLICADO");
			}
		}

		/**
		 * Criptografa senha
		 */
		usuario.setPassword(this.generateCryptedPassword(usuario.getPassword()));
		return usuarioRepository.save(usuario);
	}

	public Usuario verifyUnique(Usuario usuario) {
		return usuarioRepository.qryUniqueUsuario(usuario);
	}

	private String generateCryptedPassword(String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt(4));
	}

	public Usuario findById(long id) {
		return usuarioRepository.findUsuarioById(id);
	}

	public void deleteById(long id) {
		usuarioRepository.deleteById(id);
	}

	public Usuario findByMatricula(String matricula) {
		return usuarioRepository.findByMatricula(matricula);
	}

}