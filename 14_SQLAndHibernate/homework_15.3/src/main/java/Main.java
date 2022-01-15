import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
        Transaction transaction = session.beginTransaction();
        Student student = session.get(Student.class, 1);

        System.out.println("Студент - " + student.getName() + " - учится на " + student.getCourses().size() + " курсах");
        student.getCourses().forEach(course -> {
            Subscription subscription = session.get(Subscription.class, new SubscriptionKey(student.getId(), course.getId()));
            PurchaseList purchaseList = session.get(PurchaseList.class, new PurhaseListKey(student.getName(), course.getName()));
            System.out.println("Курс " + course.getName() + ", продолжительность месяцев - " + course.getDuration() + ", преподаватель - " + course.getTeacher().getName() + ", стоимость - " + purchaseList.getPrice() + " рублей, подписан с " + subscription.getSubscriptionDate() + ", одногрупников - " + (course.getStudents().size() - 1));
        });

        transaction.commit();
        sessionFactory.close();
    }
}
