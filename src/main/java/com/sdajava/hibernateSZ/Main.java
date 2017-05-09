package main.java.com.sdajava.hibernateSZ;


import main.java.com.sdajava.hibernateSZ.utility.Controller;
import main.java.com.sdajava.hibernateSZ.utility.Hibernateutil;
import org.hibernate.Session;

import java.text.ParseException;


public class Main {

    public static void main(String[] args) throws ParseException {
	// write your code here
        Session session = Hibernateutil.getHibernateSession();
        Controller controller = new Controller();

        controller.insertBook(session, "tytul", "autor", "11-11-1111", "opis");
        controller.showAll();

    }
}
