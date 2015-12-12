package nc.onlinelibrary.mvc.dao;

import nc.onlinelibrary.mvc.domain.Book;

import java.util.List;

public interface BookDAO {
    void addBook(Book book);
    List<Book> listBook();
    void removeBook(Integer id);
    Book getBook(Integer id);
    Book returnBook(Integer id);
    List<Book> searchBooks(String str);
    Book getBookWithRead(Integer id);
}
