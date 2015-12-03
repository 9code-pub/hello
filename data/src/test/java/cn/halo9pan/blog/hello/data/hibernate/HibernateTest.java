package cn.halo9pan.blog.hello.data.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateTest {

	protected SessionFactory sessionFactory;
	protected ServiceRegistry serviceRegistry;

	public HibernateTest() {
		super();
	}

	protected SessionFactory configureSessionFactory() throws HibernateException {
	    Configuration configuration = new Configuration();
	    configuration.configure();
	    StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
	    this.serviceRegistry = builder.applySettings(configuration.getProperties()).build();
	    this.sessionFactory = configuration.buildSessionFactory(this.serviceRegistry);
	    return this.sessionFactory;
	}

}