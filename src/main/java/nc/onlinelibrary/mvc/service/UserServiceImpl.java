package nc.onlinelibrary.mvc.service;

import nc.onlinelibrary.mvc.dao.UserDAO;
import nc.onlinelibrary.mvc.domain.Book;
import nc.onlinelibrary.mvc.domain.Issue;
import nc.onlinelibrary.mvc.domain.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Named;
import java.util.List;

@Named("userService")
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Transactional
    @Override
    public void addUser(Users user) {
        userDAO.addUser(user);
    }

    @Transactional
    @Override
    public List<Users> listUsers() {
        return userDAO.listUsers();
    }

    @Transactional
    @Override
    public void deleteUser(String username) {
        userDAO.deleteUser(username);
    }

    @Transactional
    @Override
    public Users getUser(String username) {
        return userDAO.getUser(username);
    }

    @Transactional
    @Override
    public List<Issue> getUserIssue(String username) {
        return userDAO.getUserIssue(username);
    }

    @Transactional
    @Override
    public void addBookToList(Users user, Book book) {
        userDAO.addBookToList(user,book);
    }
}
