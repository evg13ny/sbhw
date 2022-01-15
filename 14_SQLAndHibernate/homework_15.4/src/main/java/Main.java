import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        insertInTable(session);
        transaction.commit();

        String lpl = "FROM " + LinkedPurchaseList.class.getSimpleName();
        List<LinkedPurchaseList> linkedPurchaseLists = session.createQuery(lpl).getResultList();
        System.out.println(linkedPurchaseLists.size());

        String pl = "FROM " + PurchaseList.class.getSimpleName();
        List<PurchaseList> purchaseLists = session.createQuery(pl).getResultList();
        System.out.println(purchaseLists.size());

        sessionFactory.close();
    }

    private static void insertInTable(Session session) {
        String hql = "FROM PurchaseList";
        List<PurchaseList> purchaseLists = session.createQuery(hql).getResultList();
        for (PurchaseList purchaseList : purchaseLists) {
            DetachedCriteria studentsCriteria = DetachedCriteria.forClass(Student.class).add(Restrictions.eq("name", purchaseList.getStudentName()));
            Student student = (Student) studentsCriteria.getExecutableCriteria(session).list().stream().findFirst().get();
            DetachedCriteria coursesCriteria = DetachedCriteria.forClass(Course.class).add(Restrictions.eq("name", purchaseList.getCourseName()));
            Course course = (Course) coursesCriteria.getExecutableCriteria(session).list().stream().findFirst().get();

            LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList(new LinkedPurchaseList.LinkedPurchaseListKey(student.getId(), course.getId()), student, course);
            session.save(linkedPurchaseList);
        }
    }
}