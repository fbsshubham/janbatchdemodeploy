package springdemo.config;

import java.io.IOException;
import java.io.InputStream;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Address;
import model.Student;



public class HibernateConfig {

	private static SessionFactory sf;
	static
	{
		try {
			System.out.println("Hibernate config hone lage");
			Properties props = new Properties();
			InputStream is = HibernateConfig.class.getClassLoader()
			        .getResourceAsStream("application.properties");
			props.load(is);

		
			props.setProperty("hibernate.connection.username",
			        System.getenv("DB_USERNAME"));
			props.setProperty("hibernate.connection.password",
			        System.getenv("DB_PASSWORD"));

			Configuration config = new Configuration();
			config.setProperties(props);
			config.addAnnotatedClass(Student.class);
			config.addAnnotatedClass(Address.class);

			sf = config.buildSessionFactory();
		 
		
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	
	public static SessionFactory getSessionFactory()
	{
		return sf;
	}
}
