package com.befast.springboot.befastprojeto.admin.saldo;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class SaldoService {

	@Autowired
	private SaldoRepository saldoRepository;

	public SaldoPageResponse list(SaldoFilter filter) {
		PageRequest pageRequest = PageRequest.of(filter.getPageNumber() - 1, filter.getPageSize());
		Page<Saldo> page = saldoRepository.list(pageRequest, filter);

		SaldoPageResponse pageResponse = new SaldoPageResponse();
		pageResponse.setList(page.getContent());
		pageResponse.setTotalElements(page.getTotalElements());
		pageResponse.setTotalPages(page.getTotalPages());

		return pageResponse;
	}
}