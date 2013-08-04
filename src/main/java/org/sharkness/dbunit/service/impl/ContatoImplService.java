package org.sharkness.dbunit.service.impl;

import org.sharkness.dbunit.dao.interfaces.ContatoDAO;
import org.sharkness.dbunit.entity.Contato;
import org.sharkness.dbunit.service.interfaces.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContatoImplService extends GenericImplService<Contato, ContatoDAO> implements ContatoService {

	@Autowired
	public ContatoImplService(ContatoDAO dao) {
		setDao(dao);
	}
	
}