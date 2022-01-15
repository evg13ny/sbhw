import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        int maxId = (int) session.createQuery("SELECT max(id) FROM Course").list().get(0);

        for (int id = 1; id < maxId; id++) {
            System.out.println(session.get(Course.class, id).getName() + " - " + session.get(Course.class, id).getStudentsCount() + " студентов");
        }

        sessionFactory.close();
    }
}
