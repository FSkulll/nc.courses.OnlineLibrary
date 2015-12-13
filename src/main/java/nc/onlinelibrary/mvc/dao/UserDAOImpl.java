package nc.onlinelibrary.mvc.dao;

import nc.onlinelibrary.mvc.domain.*;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @Qualifier("sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addUser(Users user) {
        Users temp = (Users) sessionFactory.getCurrentSession().get(Users.class, user.getUsername());
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
        return sessionFactory.getCurrentSession().createQuery("from Users").list();
    }

    @Override
    public void deleteUser(String username) {
        Users user = (Users) sessionFactory.getCurrentSession().get(Users.class, username);
        if(user != null){
            sessionFactory.getCurrentSession().delete(user);
        }
    }

    @Override
    public Users getUser(String username) {
        Users user = (Users) sessionFactory.getCurrentSession().get(Users.class, username);
        if(user != null){
            return user;
        }
        return null;
    }

    @Override
    public List<Issue> getUserIssue(String username) {
        Users user = (Users) sessionFactory.getCurrentSession().get(Users.class, username);
        Hibernate.initialize(user.getIssueList());
        return user.getIssueList();
    }

    @Override
    public void addBookToList(Users users, Book book) {
        Issue issue = new Issue();
        issue.setDateOfIssue(new Date());
        issue.setReadBook(book);
        issue.setReadUsername(users);
        sessionFactory.getCurrentSession().save(issue);
    }

    @Override
    public List<Book> getUserReadList(String username) {
        List<Book> bookList = new ArrayList<Book>();

        Users user = (Users) sessionFactory.getCurrentSession().get(Users.class, username);
        for (Issue issue : user.getIssueList()) {
            bookList.add(issue.getReadBook());
        }

        return bookList;
    }
}