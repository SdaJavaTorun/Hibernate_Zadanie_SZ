package main.java.com.sdajava.hibernateSZ.utility;

import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * Created by RENT on 2017-05-09.
 */
public class Hibernateutil {


    private final static SessionFactory sf = new Configuration()
            .configure().buildSessionFactory();
    private volatile static Session session = sf.openSession();

    private Hibernateutil() {
    }

    public static Session getHibernateSession() {
        if (session == null) {
            session = (Session) new Hibernateutil();
        }
        return session;
    }
}

