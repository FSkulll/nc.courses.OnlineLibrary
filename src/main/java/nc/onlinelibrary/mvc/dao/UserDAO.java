package nc.onlinelibrary.mvc.dao;

import nc.onlinelibrary.mvc.domain.Book;
import nc.onlinelibrary.mvc.domain.Issue;
import nc.onlinelibrary.mvc.domain.Users;

import java.util.List;

public interface UserDAO {
    void addUser(Users user);
    List listUsers();
    void deleteUser(String username);
    Users getUser(String username);
    List<Issue> getUserIssue(String username);
    void addBookToList(Users users, Book book);
    List<Book> getUserReadList(String username);

}
