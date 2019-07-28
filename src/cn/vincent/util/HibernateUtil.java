package cn.vincent.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	private static Configuration cfg;
	private static ServiceRegistry registry;
	private static SessionFactory factory;
	private static ThreadLocal<Session> session;
	static{
		//初始化
		cfg = new Configuration().configure();
		registry = new StandardServiceRegistryBuilder()
					.applySettings(cfg.getProperties())
					.build();
		factory = cfg.buildSessionFactory(registry);
		session  =new ThreadLocal<>();
	}
	//获取连接
	public static Session getSession(){
		if(session.get()==null){
			session.set(factory.openSession());
		}
		return session.get();
	}
	//释放资源
	public static void close(){
		if(session.get()!=null){
			session.get().close();
			session.set(null);
		}
	}
}
