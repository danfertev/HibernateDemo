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
        UserDetails user = new UserDetails();
        user.setUserName("Test User");

        Configuration configuration = new Configuration().configure();
        ServiceRegistryBuilder serviceRegistryBuilder = new ServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistryBuilder.buildServiceRegistry());
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.save(user);

        user.setUserName("Updated User");
        user.setUserName("Updated User Again");

        session.getTransaction().commit();
        session.close();

        user.setUserName("Updated User After Session Closed");
    }
}
