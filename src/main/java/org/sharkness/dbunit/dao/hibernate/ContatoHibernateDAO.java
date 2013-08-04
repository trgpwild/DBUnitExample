package org.sharkness.dbunit.dao.hibernate;

import org.sharkness.dbunit.dao.interfaces.ContatoDAO;
import org.sharkness.dbunit.entity.Contato;
import org.springframework.stereotype.Repository;

@Repository
public class ContatoHibernateDAO extends GenericHibernateDAO<Contato> implements ContatoDAO {

	public ContatoHibernateDAO() {
		super(Contato.class);
	}

}