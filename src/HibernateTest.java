import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 * Created by Burak Köken on 5.7.2017.
 */
public class HibernateTest {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.configure();

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        String hql = "DELETE Product AS p WHERE p.id = :paramId";
        Query query = session.createQuery(hql);
        query.setParameter("paramId", 3);
        query.executeUpdate();

        session.close();

    }
}
