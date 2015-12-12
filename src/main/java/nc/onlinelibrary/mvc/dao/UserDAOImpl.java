package nc.onlinelibrary.mvc.dao;

import nc.onlinelibrary.mvc.domain.Book;
import nc.onlinelibrary.mvc.domain.ListRole;
import nc.onlinelibrary.mvc.domain.User;
import nc.onlinelibrary.mvc.domain.UserRoles;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @Qualifier("sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addUser(User user) {
        User temp = (User) sessionFactory.getCurrentSession().get(User.class, user.getUsername());
        if(temp == null) {
            user.setEnabled(1);
            sessionFactory.getCurrentSession().save(user);
            UserRoles userRoles = new UserRoles();
            userRoles.setUsername(user.getUsername());
            userRoles.setRole(ListRole.ROLE_USER.toString());
            sessionFactory.getCurrentSession().save(userRoles);
        }
    }

    @Override
    public List listUsers() {
        return sessionFactory.getCurrentSession().createQuery("from User").list();
    }

    @Override
    public void deleteUser(String username) {
        User user = (User) sessionFactory.getCurrentSession().get(User.class, username);
        if(user != null){
            sessionFactory.getCurrentSession().delete(user);
        }
    }

    @Override
    public User getUser(String username) {
        User user = (User) sessionFactory.getCurrentSession().get(User.class, username);
        if(user != null){
            return user;
        }
        return null;
    }

    @Override
    public User getUserWithReadList(String username) {
        User user = (User) sessionFactory.getCurrentSession().get(User.class, username);
        Hibernate.initialize(user.getRead());
        return user;
    }

    @Override
    public void addToReadList(Book book, String username) {
        User user = (User) sessionFactory.getCurrentSession().get(User.class, username);
        Hibernate.initialize(user.getRead());
        user.getRead().add(book);
    }
}