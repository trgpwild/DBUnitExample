package org.sharkness.dbunit.services;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.sharkness.dbunit.entity.Tarefa;
import org.sharkness.dbunit.service.interfaces.TarefaService;
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
@DatabaseSetup("classpath:dataset/tarefa.xml")
public class TarefaServiceAT extends AbstractTransactionalJUnit4SpringContextTests {
	
	@Autowired private SessionFactory sessionFactory;
	
	@Autowired private TarefaService tarefaService;
	
	protected List<Tarefa> listAllforTest() {
		return sessionFactory.getCurrentSession().createCriteria(Tarefa.class).list();
	}
	
	protected Tarefa getForTest(Long id) {
		return (Tarefa) sessionFactory.getCurrentSession().get(Tarefa.class, id);
	}

	@Test
	public void testListTarefas() throws Exception {
		assertEquals(3, tarefaService.list().size());
	}

	@Test
	public void testInsertTarefas() throws Exception {
		Tarefa tarefa = new Tarefa();
		tarefa.setNome("Benjamin");
		tarefa.setDataExecucao(Calendar.getInstance());
		tarefaService.save(tarefa);
		assertEquals(4, listAllforTest().size());
	}

	@Test
	public void testUpdateTarefas() throws Exception {
		Tarefa tarefa = getForTest(3l);
		Calendar dataNova = Calendar.getInstance();
		dataNova.set(2015, 02, 22);
		tarefa.setDataExecucao(dataNova);
		tarefaService.save(tarefa);
		tarefa = getForTest(3l);
		Calendar dataEsperada = Calendar.getInstance();
		dataEsperada.set(2015, 02, 22);
		assertEquals(dataEsperada.get(Calendar.YEAR), tarefa.getDataExecucao().get(Calendar.YEAR));
		assertEquals(dataEsperada.get(Calendar.MONTH), tarefa.getDataExecucao().get(Calendar.MONTH));
		assertEquals(dataEsperada.get(Calendar.DAY_OF_MONTH), tarefa.getDataExecucao().get(Calendar.DAY_OF_MONTH));
	}

	@Test
	public void testDeleteTarefas() throws Exception {
		Tarefa tarefa = getForTest(3l);
		tarefaService.delete(tarefa);
		assertEquals(2, listAllforTest().size());
	}

}