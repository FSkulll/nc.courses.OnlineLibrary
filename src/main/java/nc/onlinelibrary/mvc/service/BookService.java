package nc.onlinelibrary.mvc.service;

import nc.onlinelibrary.mvc.domain.Book;

import java.util.List;

public interface BookService {

    void addBook(Book book);
    List<Book> listBook();
    void removeBook(Integer id);
    Book getBook(Integer id);
    Book returnBook(Integer id);
    void editBook(Integer id);
    List<Book> searchBook(String str);

}
