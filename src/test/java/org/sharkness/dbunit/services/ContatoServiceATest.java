package org.sharkness.dbunit.services;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.sharkness.dbunit.entity.Contato;
import org.sharkness.dbunit.service.interfaces.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

@SuppressWarnings("unchecked")
@ContextConfiguration("classpath:applicationContextTest.xml")
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class})
@DatabaseSetup("classpath:dataset/contato.xml")
public class ContatoServiceATest extends AbstractTransactionalJUnit4SpringContextTests {
	
	@Autowired private SessionFactory sessionFactory;
	
	@Autowired private ContatoService contatoService;
	
	protected List<Contato> listAllforTest() {
		return sessionFactory.getCurrentSession().createCriteria(Contato.class).list();
	}
	
	protected Contato getForTest(Long id) {
		return (Contato) sessionFactory.getCurrentSession().get(Contato.class, id);
	}

	@Test
	public void testListContatos() throws Exception {
		assertEquals(3, contatoService.list().size());
	}

	@Test
	public void testInsertContatos() throws Exception {
		Contato contato = new Contato();
		contato.setNome("Benjamin");
		contato.setEndereco("Mais uma Rua de louco nr 1109");
		contatoService.save(contato);
		assertEquals(4, listAllforTest().size());
	}

	@Test
	public void testUpdateContatos() throws Exception {
		Contato contato = getForTest(3l);
		contato.setNome("Alterado");
		contatoService.save(contato);
		contato = getForTest(3l);
		assertEquals("Alterado", contato.getNome());
	}

	@Test
	public void testDeleteContatos() throws Exception {
		Contato contato = getForTest(3l);
		contatoService.delete(contato);
		assertEquals(2, listAllforTest().size());
	}

}