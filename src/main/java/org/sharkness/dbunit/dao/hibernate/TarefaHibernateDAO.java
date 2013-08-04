package org.sharkness.dbunit.dao.hibernate;

import org.sharkness.dbunit.dao.interfaces.TarefaDAO;
import org.sharkness.dbunit.entity.Tarefa;
import org.springframework.stereotype.Repository;

@Repository
public class TarefaHibernateDAO extends GenericHibernateDAO<Tarefa> implements TarefaDAO {

	public TarefaHibernateDAO() {
		super(Tarefa.class);
	}

}