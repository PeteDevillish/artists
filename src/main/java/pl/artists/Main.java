package pl.artists;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Artist artist = new Artist("Paul", "McCartney");
        session.save(artist);
        session.getTransaction().commit();
        session.close();
    }

}
