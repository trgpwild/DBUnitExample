package org.sharkness.dbunit.standalone;
import org.sharkness.dbunit.service.interfaces.ContatoService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		ctx.getBean(ContatoService.class).list();
	}

}