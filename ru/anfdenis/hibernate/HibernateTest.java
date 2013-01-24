package ru.anfdenis.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;
import ru.anfdenis.dto.UserDetails;

/**
 * Denis Anfertev
 * 21.01.13 16:29
 */
public class HibernateTest {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();
        ServiceRegistryBuilder serviceRegistryBuilder = new ServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistryBuilder.buildServiceRegistry());
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        UserDetails user;
        for (int i = 0; i < 10; i++) {
            user = new UserDetails();
            user.setUserName("User" + i);
            session.save(user);
        }
        session.getTransaction().commit();
        session.close();

        session = sessionFactory.openSession();
        session.beginTransaction();

        user = (UserDetails) session.get(UserDetails.class, 6);
        session.delete(user);

        user = (UserDetails) session.get(UserDetails.class, 5);
        user.setUserName("Updated User");
        session.update(user);

        session.getTransaction().commit();
        session.close();

        System.out.println("User name pulled up is " + user.getUserName());
    }
}
