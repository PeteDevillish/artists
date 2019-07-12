package pl.artists;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collection;

public class EntityDao<T> {
    private SessionFactory sessionFactory;
    private Class<T> clazz;

    public EntityDao(Class<T> clazz) {
        this.clazz = clazz;
        this.sessionFactory = new Configuration()
                .configure()
                .buildSessionFactory();
    }

    public void save(T entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
    }

    public void delete(T entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        session.close();
    }

    public void update(T entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
    }

    public T findById(int id) {
        Session session = sessionFactory.openSession();
        T entity = session.get(clazz, id);
        session.close();
        return entity;
    }

    public Collection<T> findAll() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(clazz);
        Root<T> rootEntry = cq.from(clazz);
        CriteriaQuery<T> all = cq.select(rootEntry);

        TypedQuery<T> allQuery = session.createQuery(all);
        return allQuery.getResultList();
    }
}
