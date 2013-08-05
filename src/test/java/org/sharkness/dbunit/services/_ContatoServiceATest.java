package org.sharkness.dbunit.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sharkness.dbunit.config._DBUnitConfiguration;
import org.sharkness.dbunit.entity.Contato;
import org.sharkness.dbunit.service.interfaces.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContextTest.xml")
@TransactionConfiguration(defaultRollback=true,transactionManager="transactionManager")
public class _ContatoServiceATest extends _DBUnitConfiguration {
	
	@Autowired private ContatoService contatoService;
	
	protected int countSizeForAll() throws Exception {
		PreparedStatement pmst = getJdbcConnection().prepareStatement("select count(*) as size from contato");
		ResultSet rs = pmst.executeQuery();
		while (rs.next()) {
			return rs.getInt("size");
		}
		return 0;
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
		assertEquals(4, countSizeForAll());
	}

}