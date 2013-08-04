package org.sharkness.dbunit.service.impl;

import org.sharkness.dbunit.dao.interfaces.TarefaDAO;
import org.sharkness.dbunit.entity.Tarefa;
import org.sharkness.dbunit.service.interfaces.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TarefaImplService extends GenericImplService<Tarefa, TarefaDAO> implements TarefaService {

	@Autowired
	public TarefaImplService(TarefaDAO dao) {
		setDao(dao);
	}
	
}