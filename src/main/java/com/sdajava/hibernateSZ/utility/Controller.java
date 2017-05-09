package main.java.com.sdajava.hibernateSZ.utility;

import main.java.com.sdajava.hibernateSZ.entity.Book;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by RENT on 2017-05-09.
 */
public class Controller {

    Session session = Hibernateutil.getHibernateSession();

    public void showAll(){

        try{
            session.beginTransaction();
            List<Book> books = session.createQuery("FROM " + Book.class.getName()).list();

            for (Book book: books){

                System.out.println(" Id: " + book.getId());
                System.out.println(" Tytul: " + book.getTitle());
                System.out.println(" Autor: " + book.getAuthor());
                System.out.println(" Rok Wydania: " + book.getPublished());
                System.out.println(" Opis: " + book.getDescription());
            }
            session.getTransaction().commit();
        }
        catch (HibernateException e) {
            if (session.getTransaction()!=null) session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    public void insertBook(Session session, String title, String author, String date, String desc) throws ParseException{

        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date d = df.parse(date);

        Book book =new Book(title, author, d, desc);

        try{
            session.beginTransaction();
            session.save(book);
            session.getTransaction().commit();
        }catch (HibernateException e) {
            if (session.getTransaction()!=null) session.getTransaction().rollback();
            e.printStackTrace();
    }
    }
}

