package nc.onlinelibrary.mvc.dao;

import nc.onlinelibrary.mvc.domain.Book;
import nc.onlinelibrary.mvc.domain.Users;

import java.util.List;

public interface BookDAO {
    void addBook(Book book);
    List<Book> listBook();
    void removeBook(Integer book_id);
    Book getBook(Integer id);
    Book returnBook(Integer book_id, Users user);
    List<Book> searchBooks(String str);
    Book getBookIssue(Integer book_id);
    void setAvailable(Integer book_id, boolean value);
}
