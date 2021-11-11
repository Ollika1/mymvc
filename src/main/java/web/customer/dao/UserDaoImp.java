package web.customer.dao;

import org.springframework.stereotype.Repository;
import web.customer.model.User;

import javax.persistence.*;
import java.util.List;


@Repository
public class UserDaoImp implements UserDao{

//  @Autowired
//  private SessionFactory sessionFactory;

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    public UserDaoImp() {
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        //TypedQuery<User> query= sessionFactory.getCurrentSession().createQuery("select a from User a");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query= entityManager.createQuery("select a from User a");
        List<User> list =query.getResultList();
        entityManager.getTransaction().commit();
        return list;
    }

    @Override
    public void save(User user) {
//      Session session = sessionFactory.getCurrentSession();
//      session.save(user);
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(int id) {
//      Session session = sessionFactory.getCurrentSession();
//      User user= session.get(User.class, id);
//      session.remove(user);
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
        entityManager.getTransaction().commit();
    }

    @Override
    public void edit(int id,User user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        User userEdited = entityManager.find(User.class, id);
        userEdited.setName(user.getName());
        userEdited.setLastName(user.getLastName());
        userEdited.setEmail(user.getEmail());
        entityManager.getTransaction().commit();
    }

    @Override
    public User getById(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class, id);
        entityManager.getTransaction().commit();
        return user;
//      Session session = sessionFactory.getCurrentSession();
//      return session.get(User.class, id);
    }

}
