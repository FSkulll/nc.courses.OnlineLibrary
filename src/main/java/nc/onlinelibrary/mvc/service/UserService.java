package nc.onlinelibrary.mvc.service;

import nc.onlinelibrary.mvc.domain.Book;
import nc.onlinelibrary.mvc.domain.Issue;
import nc.onlinelibrary.mvc.domain.Users;

import java.util.List;

public interface UserService {
    void addUser(Users user);
    List<Users> listUsers();
    void deleteUser(String username);
    Users getUser(String username);
    List<Issue> getUserIssue(String username);
    void addBookToList(Users user, Book book);
    List<Book> getUserReadList(String username);
}
