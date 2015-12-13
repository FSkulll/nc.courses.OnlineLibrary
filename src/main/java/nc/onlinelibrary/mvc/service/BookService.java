package nc.onlinelibrary.mvc.service;

import nc.onlinelibrary.mvc.domain.Book;
import nc.onlinelibrary.mvc.domain.Users;

import java.util.List;

public interface BookService {

    void addBook(Book book);
    List<Book> listBook();
    void removeBook(Integer book_id);
    Book getBook(Integer book_id);
    Book returnBook(Integer book_id, Users user);
    void editBook(Integer book_id);
    List<Book> searchBook(String str);
    Book getBookIssue(Integer book_id);
    void setAvailable(Integer book_id, boolean value);

}
